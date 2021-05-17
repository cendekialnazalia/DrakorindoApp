package com.cendekia.drakorindoapp.ui.favorite.drama

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.cendekia.drakorindoapp.data.DrakorindoRepository
import com.cendekia.drakorindoapp.data.source.local.entity.DramaEntity

class FavoriteDramaViewModel(private val drakorindoRepository: DrakorindoRepository) : ViewModel() {

    fun getDramaFavorites(): LiveData<PagedList<DramaEntity>> {
        return drakorindoRepository.getFavoritedDramases()
    }

    fun setFavorite(dramaEntity: DramaEntity) {
        val newState = !dramaEntity.favorited
        drakorindoRepository.setDramaFavorite(dramaEntity, newState)
    }
}