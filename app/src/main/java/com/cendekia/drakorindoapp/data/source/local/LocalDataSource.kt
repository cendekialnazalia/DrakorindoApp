package com.cendekia.drakorindoapp.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.cendekia.drakorindoapp.data.source.local.entity.DramaEntity
import com.cendekia.drakorindoapp.data.source.local.entity.DramaWithDetail
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyEntity
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyWithDetail
import com.cendekia.drakorindoapp.data.source.local.room.FilmDao

class LocalDataSource private constructor(private val mFilmDao: FilmDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(filmDao: FilmDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(filmDao)
    }

    fun getAllDramases(): DataSource.Factory<Int, DramaEntity> = mFilmDao.getDramases()

    fun getDramaWithDetail(dramaId: String): LiveData<DramaWithDetail> =
        mFilmDao.getDetailWithDramaById(dramaId)

    fun getFavoritedDramases(): DataSource.Factory<Int, DramaEntity> = mFilmDao.getFavoritedDrama()

    fun insertDramases(dramases: List<DramaEntity>) = mFilmDao.insertDramases(dramases)

    fun setDramaFavorite(drama: DramaEntity, newState: Boolean) {
        drama.favorited = newState
        mFilmDao.updateDrama(drama)
    }

    fun getAllVarietises(): DataSource.Factory<Int, VarietyEntity> = mFilmDao.getVarieties()

    fun getVarietyWithDetail(varietyId: String): LiveData<VarietyWithDetail> =
        mFilmDao.getDetailWithVarietyById(varietyId)

    fun getFavoritedVarietises(): DataSource.Factory<Int, VarietyEntity> =
        mFilmDao.getFavoritedVariety()

    fun insertVarietises(varietises: List<VarietyEntity>) = mFilmDao.insertVarietises(varietises)

    fun setVarietyFavorite(variety: VarietyEntity, newState: Boolean) {
        variety.favorited = newState
        mFilmDao.updateVariety(variety)
    }
}