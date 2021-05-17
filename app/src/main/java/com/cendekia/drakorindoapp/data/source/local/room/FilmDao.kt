package com.cendekia.drakorindoapp.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.cendekia.drakorindoapp.data.source.local.entity.DramaEntity
import com.cendekia.drakorindoapp.data.source.local.entity.DramaWithDetail
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyEntity
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyWithDetail

@Dao
interface FilmDao {

    @Query("SELECT * FROM dramaentities")
    fun getDramases(): DataSource.Factory<Int, DramaEntity>

    @Transaction
    @Query("SELECT * FROM dramaentities WHERE dramaId = :dramaId")
    fun getDetailWithDramaById(dramaId: String): LiveData<DramaWithDetail>

    @Query("SELECT * FROM dramaentities where favorited = 1")
    fun getFavoritedDrama(): DataSource.Factory<Int, DramaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDramases(dramases: List<DramaEntity>)

    @Update
    fun updateDrama(drama: DramaEntity)

    @Query("SELECT * FROM varietyentities")
    fun getVarieties(): DataSource.Factory<Int, VarietyEntity>

    @Transaction
    @Query("SELECT * FROM varietyentities WHERE varietyId = :varietyId")
    fun getDetailWithVarietyById(varietyId: String): LiveData<VarietyWithDetail>

    @Query("SELECT * FROM varietyentities where favorited = 1")
    fun getFavoritedVariety(): DataSource.Factory<Int, VarietyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVarietises(varietises: List<VarietyEntity>)

    @Update
    fun updateVariety(variety: VarietyEntity)

}