package com.cendekia.drakorindoapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.cendekia.drakorindoapp.data.source.local.entity.DramaEntity
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyEntity
import com.cendekia.drakorindoapp.data.DrakorindoRepository
import com.cendekia.drakorindoapp.data.source.local.entity.DramaWithDetail
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyWithDetail
import com.cendekia.drakorindoapp.vo.Resource

class DetailViewModel(private val drakorindoRepository: DrakorindoRepository) : ViewModel() {
    val dramaId = MutableLiveData<String>()
    val varietyId = MutableLiveData<String>()

    fun setSelectedDrama(dramaId: String) {
        this.dramaId.value = dramaId
    }

    fun setSelectedVariety(varietyId: String) {
        this.varietyId.value = varietyId
    }

    var dramaModule: LiveData<Resource<DramaWithDetail>> = Transformations.switchMap(dramaId) { mDramaId ->
        drakorindoRepository.getDramaWithDetail(mDramaId)
    }

    var varietyModule: LiveData<Resource<VarietyWithDetail>> = Transformations.switchMap(varietyId) { mVarietyId ->
        drakorindoRepository.getVarietyWithDetail(mVarietyId)
    }


    fun setDramaFavorite() {
        val moduleResource = dramaModule.value
        if (moduleResource != null) {
            val dramaWithDetail = moduleResource.data
            if (dramaWithDetail != null) {
                val dramaEntity = dramaWithDetail.mDrama
                val newState = !dramaEntity.favorited
                drakorindoRepository.setDramaFavorite(dramaEntity, newState)
            }
        }
    }

    fun setVarietyFavorite() {
        val moduleResource = varietyModule.value
        if (moduleResource != null) {
            val varietyWithDetail = moduleResource.data
            if (varietyWithDetail != null) {
                val varietyEntity = varietyWithDetail.mVariety
                val newState = !varietyEntity.favorited
                drakorindoRepository.setVarietyFavorite(varietyEntity, newState)
            }
        }
    }
}