package com.cendekia.drakorindoapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cendekia.drakorindoapp.data.DrakorindoRepository
import com.cendekia.drakorindoapp.di.Injection
import com.cendekia.drakorindoapp.ui.detail.DetailViewModel
import com.cendekia.drakorindoapp.ui.drama.DramaViewModel
import com.cendekia.drakorindoapp.ui.favorite.drama.FavoriteDramaViewModel
import com.cendekia.drakorindoapp.ui.favorite.variety.FavoriteVarietyViewModel
import com.cendekia.drakorindoapp.ui.varietyshow.VarietyShowViewModel

class ViewModelFactory private constructor(private val mDrakorindoRepository: DrakorindoRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(DramaViewModel::class.java) -> {
                return DramaViewModel(mDrakorindoRepository) as T
            }
            modelClass.isAssignableFrom(VarietyShowViewModel::class.java) -> {
                return VarietyShowViewModel(mDrakorindoRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                return DetailViewModel(mDrakorindoRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteDramaViewModel::class.java) -> {
                return FavoriteDramaViewModel(mDrakorindoRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteVarietyViewModel::class.java) -> {
                return FavoriteVarietyViewModel(mDrakorindoRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}