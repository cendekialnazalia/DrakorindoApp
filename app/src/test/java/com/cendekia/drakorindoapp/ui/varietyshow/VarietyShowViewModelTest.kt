package com.cendekia.drakorindoapp.ui.varietyshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.cendekia.drakorindoapp.data.DrakorindoRepository
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyEntity
import com.cendekia.drakorindoapp.utils.DataVarietyShow
import com.cendekia.drakorindoapp.vo.Resource
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
class VarietyShowViewModelTest {
    private lateinit var viewModel: VarietyShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var drakorindoRepository: DrakorindoRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<VarietyEntity>>>

    @Before
    fun setUp() {
        viewModel = VarietyShowViewModel(drakorindoRepository)
    }

    @Test
    fun `getVarietises should be success`() {
        val varietises = PagedTestDataSources.snapshot(DataVarietyShow.generateDummyVarietyShow())
        val expected = MutableLiveData<Resource<PagedList<VarietyEntity>>>()
        expected.value = Resource.success(varietises)

        `when`(drakorindoRepository.getAllVarietises()).thenReturn(expected)

        viewModel.getVarietyShows().observeForever(observer)
        Mockito.verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getVarietyShows().value
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.data, actualValue?.data)
        assertEquals(expectedValue?.data?.size, actualValue?.data?.size)
    }

    @Test
    fun `getVarietises  should be success but data is empty`() {
        val varietises = PagedTestDataSources.snapshot()
        val expected = MutableLiveData<Resource<PagedList<VarietyEntity>>>()
        expected.value = Resource.success(varietises)

        `when`(drakorindoRepository.getAllVarietises()).thenReturn(expected)

        viewModel.getVarietyShows().observeForever(observer)
        Mockito.verify(observer).onChanged(expected.value)

        val actualValueDataSize = viewModel.getVarietyShows().value?.data?.size
        Assert.assertTrue(
            "size of data should be 0, actual is $actualValueDataSize",
            actualValueDataSize == 0
        )
    }

    @Test
    fun `getVarietises should be error`() {
        val expectedMessage = "Something happen bro!"
        val expected = MutableLiveData<Resource<PagedList<VarietyEntity>>>()
        expected.value = Resource.error(expectedMessage, null)

        `when`(drakorindoRepository.getAllVarietises()).thenReturn(expected)

        viewModel.getVarietyShows().observeForever(observer)
        Mockito.verify(observer).onChanged(expected.value)

        val actualMessage = viewModel.getVarietyShows().value?.message
        assertEquals(expectedMessage, actualMessage)
    }

    class PagedTestDataSources private constructor(private val items: List<VarietyEntity>) : PositionalDataSource<VarietyEntity>() {
        companion object {
            fun snapshot(items: List<VarietyEntity> = listOf()): PagedList<VarietyEntity> {
                return PagedList.Builder(PagedTestDataSources(items), 10)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }

        override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<VarietyEntity>) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<VarietyEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }
}