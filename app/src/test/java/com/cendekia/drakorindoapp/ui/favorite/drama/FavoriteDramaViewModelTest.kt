package com.cendekia.drakorindoapp.ui.favorite.drama

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.cendekia.drakorindoapp.data.DrakorindoRepository
import com.cendekia.drakorindoapp.data.source.local.entity.DramaEntity
import com.cendekia.drakorindoapp.utils.DataDrama
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class FavoriteDramaViewModelTest {
    private lateinit var viewModel: FavoriteDramaViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var drakorindoRepository: DrakorindoRepository

    @Mock
    private lateinit var observer: Observer<PagedList<DramaEntity>>

    @Before
    fun setUp() {
        viewModel = FavoriteDramaViewModel(drakorindoRepository)
    }

    @Test
    fun `getFavoritedDramases should be success`() {
        val expected = MutableLiveData<PagedList<DramaEntity>>()
        expected.value = PagedTestDataSources.snapshot(DataDrama.generateDummyDrama())

        `when`(drakorindoRepository.getFavoritedDramases()).thenReturn(expected)

        viewModel.getDramaFavorites().observeForever(observer)
        Mockito.verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getDramaFavorites().value
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.snapshot(), actualValue?.snapshot())
        assertEquals(expectedValue?.size, actualValue?.size)
    }

    @Test
    fun `getFavoritedDramases should be success but data is empty`() {
        val expected = MutableLiveData<PagedList<DramaEntity>>()
        expected.value = PagedTestDataSources.snapshot()

        `when`(drakorindoRepository.getFavoritedDramases()).thenReturn(expected)

        viewModel.getDramaFavorites().observeForever(observer)
        Mockito.verify(observer).onChanged(expected.value)

        val actualValueDataSize = viewModel.getDramaFavorites().value?.size
        Assert.assertTrue(
            "size of data should be 0, actual is $actualValueDataSize",
            actualValueDataSize == 0
        )
    }

    class PagedTestDataSources private constructor(private val items: List<DramaEntity>) :
        PositionalDataSource<DramaEntity>() {
        companion object {
            fun snapshot(items: List<DramaEntity> = listOf()): PagedList<DramaEntity> {
                return PagedList.Builder(PagedTestDataSources(items), 10)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }

        override fun loadInitial(
            params: LoadInitialParams,
            callback: LoadInitialCallback<DramaEntity>
        ) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<DramaEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }
}