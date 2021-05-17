package com.cendekia.drakorindoapp.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.cendekia.drakorindoapp.data.source.local.entity.DramaEntity
import com.cendekia.drakorindoapp.data.source.local.entity.DramaWithDetail
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyEntity
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyWithDetail
import com.cendekia.drakorindoapp.vo.Resource

interface DrakorindoDataSource {
    fun getAllDramases(): LiveData<Resource<PagedList<DramaEntity>>>

    fun getDramaWithDetail(drakorindoId: String): LiveData<Resource<DramaWithDetail>>

    fun getFavoritedDramases(): LiveData<PagedList<DramaEntity>>

    fun setDramaFavorite(drama: DramaEntity, state: Boolean)

    fun getAllVarietises(): LiveData<Resource<PagedList<VarietyEntity>>>

    fun getVarietyWithDetail(drakorindoId: String): LiveData<Resource<VarietyWithDetail>>

    fun getFavoritedVarietises(): LiveData<PagedList<VarietyEntity>>

    fun setVarietyFavorite(variety: VarietyEntity, state: Boolean)
}