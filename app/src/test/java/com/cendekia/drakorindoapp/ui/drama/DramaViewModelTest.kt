package com.cendekia.drakorindoapp.ui.drama

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.cendekia.drakorindoapp.data.DrakorindoRepository
import com.cendekia.drakorindoapp.data.source.local.entity.DramaEntity
import com.cendekia.drakorindoapp.utils.DataDrama
import com.cendekia.drakorindoapp.vo.Resource
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class DramaViewModelTest {

    private lateinit var viewModel: DramaViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var drakorindoRepository: DrakorindoRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<DramaEntity>>>

    @Before
    fun setUp() {
        viewModel = DramaViewModel(drakorindoRepository)
    }

    @Test
    fun `getDramases should be success`() {
        val dramases = PagedTestDataSources.snapshot(DataDrama.generateDummyDrama())
        val expected = MutableLiveData<Resource<PagedList<DramaEntity>>>()
        expected.value = Resource.success(dramases)

        `when`(drakorindoRepository.getAllDramases()).thenReturn(expected)

        viewModel.getDramas().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getDramas().value
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.data, actualValue?.data)
        assertEquals(expectedValue?.data?.size, actualValue?.data?.size)
    }

    @Test
    fun `getDramases should be success but data is empty`() {
        val dramases = PagedTestDataSources.snapshot()
        val expected = MutableLiveData<Resource<PagedList<DramaEntity>>>()
        expected.value = Resource.success(dramases)

        `when`(drakorindoRepository.getAllDramases()).thenReturn(expected)

        viewModel.getDramas().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val actualValueDataSize = viewModel.getDramas().value?.data?.size
        Assert.assertTrue(
            "size of data should be 0, actual is $actualValueDataSize",
            actualValueDataSize == 0
        )
    }

    @Test
    fun `getDramases should be error`() {
        val expectedMessage = "Something happen bro!"
        val expected = MutableLiveData<Resource<PagedList<DramaEntity>>>()
        expected.value = Resource.error(expectedMessage, null)

        `when`(drakorindoRepository.getAllDramases()).thenReturn(expected)

        viewModel.getDramas().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val actualMessage = viewModel.getDramas().value?.message
        assertEquals(expectedMessage, actualMessage)
    }

    class PagedTestDataSources private constructor(private val items: List<DramaEntity>) : PositionalDataSource<DramaEntity>() {
        companion object {
            fun snapshot(items: List<DramaEntity> = listOf()): PagedList<DramaEntity> {
                return PagedList.Builder(PagedTestDataSources(items), 10)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }

        override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<DramaEntity>) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<DramaEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }
}