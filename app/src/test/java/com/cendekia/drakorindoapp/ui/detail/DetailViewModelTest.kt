package com.cendekia.drakorindoapp.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.cendekia.drakorindoapp.data.DrakorindoRepository
import com.cendekia.drakorindoapp.data.source.local.entity.DramaWithDetail
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyWithDetail
import com.cendekia.drakorindoapp.utils.DataDrama
import com.cendekia.drakorindoapp.utils.DataVarietyShow
import com.cendekia.drakorindoapp.vo.Resource
import com.nhaarman.mockitokotlin2.times
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyDrama = DataDrama.generateDummyDrama()[0]
    private val dummyVariety = DataVarietyShow.generateDummyVarietyShow()[0]
    private val dramaId = dummyDrama.drakorindoId
    private val varietyId = dummyVariety.drakorindoId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dramaObserver: Observer<Resource<DramaWithDetail>>

    @Mock
    private lateinit var varietyObserver: Observer<Resource<VarietyWithDetail>>

    @Mock
    private lateinit var drakorindoRepository: DrakorindoRepository

    @Before
    fun setUp() {
        viewModel = DetailViewModel(drakorindoRepository)
        viewModel.setSelectedDrama(dramaId)
        viewModel.setSelectedVariety(varietyId)
    }

    @Test
    fun `setSelectedDrama should be success`() {
        val expected = MutableLiveData<Resource<DramaWithDetail>>()
        expected.value = Resource.success(DataDrama.generateDummyDramaWithDetail(dummyDrama, true))

        `when`(drakorindoRepository.getDramaWithDetail(dramaId)).thenReturn(expected)

        viewModel.dramaModule.observeForever(dramaObserver)

        Mockito.verify(dramaObserver).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.dramaModule.value

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `setDramaFavorited should be success trigger dramaModule observer`() {
        viewModel.setSelectedDrama(dummyDrama.drakorindoId)
        val expected = MutableLiveData<Resource<DramaWithDetail>>()
        expected.value = Resource.success(DataDrama.generateDummyDramaWithDetail(dummyDrama, false))

        `when`(drakorindoRepository.getDramaWithDetail(dramaId)).thenReturn(expected)
        viewModel.dramaModule.observeForever(dramaObserver)
        viewModel.setDramaFavorite()
        verify(drakorindoRepository, times(1)).setDramaFavorite(dummyDrama, true)
    }

    @Test
    fun `setSelectedVariety should be success`() {
        val expected = MutableLiveData<Resource<VarietyWithDetail>>()
        expected.value =
            Resource.success(DataVarietyShow.generateDummyVarietyWithDetail(dummyVariety, true))

        `when`(drakorindoRepository.getVarietyWithDetail(varietyId)).thenReturn(expected)

        viewModel.varietyModule.observeForever(varietyObserver)

        Mockito.verify(varietyObserver).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.varietyModule.value

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `setVarietyFavorited should be success trigger varietyModule observer`() {
        viewModel.setSelectedVariety(dummyVariety.drakorindoId)
        val expected = MutableLiveData<Resource<VarietyWithDetail>>()
        expected.value =
            Resource.success(DataVarietyShow.generateDummyVarietyWithDetail(dummyVariety, false))

        `when`(drakorindoRepository.getVarietyWithDetail(varietyId)).thenReturn(expected)
        viewModel.varietyModule.observeForever(varietyObserver)
        viewModel.setVarietyFavorite()
        verify(drakorindoRepository, times(1)).setVarietyFavorite(dummyVariety, true)
    }

}