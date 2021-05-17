package com.cendekia.drakorindoapp.ui.favorite.variety

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.cendekia.drakorindoapp.data.DrakorindoRepository
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyEntity

class FavoriteVarietyViewModel(private val drakorindoRepository: DrakorindoRepository) :
    ViewModel() {
    fun getVarietyFavorites(): LiveData<PagedList<VarietyEntity>> {
        return drakorindoRepository.getFavoritedVarietises()
    }

    fun setFavorite(varietyEntity: VarietyEntity) {
        val newState = !varietyEntity.favorited
        drakorindoRepository.setVarietyFavorite(varietyEntity, newState)
    }
}