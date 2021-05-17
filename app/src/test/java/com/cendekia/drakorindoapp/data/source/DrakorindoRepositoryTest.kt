package com.cendekia.drakorindoapp.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.cendekia.drakorindoapp.data.source.local.LocalDataSource
import com.cendekia.drakorindoapp.data.source.local.entity.DramaEntity
import com.cendekia.drakorindoapp.data.source.local.entity.DramaWithDetail
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyEntity
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyWithDetail
import com.cendekia.drakorindoapp.data.source.remote.RemoteDataSource
import com.cendekia.drakorindoapp.utils.*
import com.cendekia.drakorindoapp.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.util.concurrent.Executor

class DrakorindoRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val drakorindoRepository = FakeDrakorindoRepository(remote, local, appExecutors)

    private val dramaResponses = DataDrama.generateRemoteDummyDrama()
    private val dramaId = dramaResponses[0].drakorindoId
    private val varietyResponses = DataVarietyShow.generateRemoteDummyVarietyShow()
    private val varietyId = varietyResponses[0].drakorindoId

    @Test
    fun getAllDramases() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, DramaEntity>
        `when`(local.getAllDramases()).thenReturn(dataSourceFactory)
        drakorindoRepository.getAllDramases()

        val dramaEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDrama.generateDummyDrama()))
        verify(local).getAllDramases()
        assertNotNull(dramaEntities.data)
        assertEquals(dramaResponses.size.toLong(), dramaEntities.data?.size?.toLong())
    }

    @Test
    fun getDramaWithDetail() {
        val dummyDrama = MutableLiveData<DramaWithDetail>()
        dummyDrama.value =
            DataDrama.generateDummyDramaWithDetail(DataDrama.generateDummyDrama()[0], false)
        `when`(local.getDramaWithDetail(dramaId)).thenReturn(dummyDrama)

        val dramaEntities =
            LiveDataTestUtil.getValue(drakorindoRepository.getDramaWithDetail(dramaId))
        verify(local).getDramaWithDetail(dramaId)
        assertNotNull(dramaEntities.data)
        assertNotNull(dramaEntities.data?.mDrama?.title)
        assertEquals(dramaResponses[0].title, dramaEntities.data?.mDrama?.title)
    }

    @Test
    fun getFavoritedDramases() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, DramaEntity>
        `when`(local.getFavoritedDramases()).thenReturn(dataSourceFactory)
        drakorindoRepository.getFavoritedDramases()

        val dramaEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDrama.generateDummyDrama()))
        verify(local).getFavoritedDramases()
        assertNotNull(dramaEntities)
        assertEquals(dramaResponses.size.toLong(), dramaEntities.data?.size?.toLong())
    }

    @Test
    fun setDramaFavorite() {
        val dummyDrama = DataDrama.generateDummyDrama()[0]
        `when`(appExecutors.diskIO()).thenReturn(Executor {
            local.setDramaFavorite(dummyDrama, !dummyDrama.favorited)
        })
        drakorindoRepository.setDramaFavorite(
            dummyDrama, !dummyDrama.favorited
        )
        verify(appExecutors).diskIO()
        verify(local).setDramaFavorite(dummyDrama, !dummyDrama.favorited)
    }


    @Test
    fun getAllVarietises() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, VarietyEntity>
        `when`(local.getAllVarietises()).thenReturn(dataSourceFactory)
        drakorindoRepository.getAllVarietises()

        val varietyEntities =
            Resource.success(PagedListUtil.mockPagedList(DataVarietyShow.generateDummyVarietyShow()))
        verify(local).getAllVarietises()
        assertNotNull(varietyEntities.data)
        assertEquals(varietyResponses.size.toLong(), varietyEntities.data?.size?.toLong())
    }

    @Test
    fun getVarietyWithDetail() {
        val dummyVariety = MutableLiveData<VarietyWithDetail>()
        dummyVariety.value = DataVarietyShow.generateDummyVarietyWithDetail(
            DataVarietyShow.generateDummyVarietyShow()[0],
            false
        )
        `when`(local.getVarietyWithDetail(varietyId)).thenReturn(dummyVariety)

        val varietyEntities =
            LiveDataTestUtil.getValue(drakorindoRepository.getVarietyWithDetail(varietyId))
        verify(local).getVarietyWithDetail(varietyId)
        assertNotNull(varietyEntities.data)
        assertNotNull(varietyEntities.data?.mVariety?.title)
        assertEquals(varietyResponses[0].title, varietyEntities.data?.mVariety?.title)
    }

    @Test
    fun getFavoritedVarietises() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, VarietyEntity>
        `when`(local.getFavoritedVarietises()).thenReturn(dataSourceFactory)
        drakorindoRepository.getFavoritedVarietises()

        val varietyEntities =
            Resource.success(PagedListUtil.mockPagedList(DataVarietyShow.generateDummyVarietyShow()))
        verify(local).getFavoritedVarietises()
        assertNotNull(varietyEntities)
        assertEquals(varietyResponses.size.toLong(), varietyEntities.data?.size?.toLong())
    }

    @Test
    fun setVarietyFavorite(){
        val dummyVariety = DataVarietyShow.generateDummyVarietyShow()[0]
        `when`(appExecutors.diskIO()).thenReturn(Executor {
            local.setVarietyFavorite(dummyVariety, !dummyVariety.favorited)
        })
        drakorindoRepository.setVarietyFavorite(
            dummyVariety, !dummyVariety.favorited
        )
        verify(appExecutors).diskIO()
        verify(local).setVarietyFavorite(dummyVariety, !dummyVariety.favorited)
    }


}