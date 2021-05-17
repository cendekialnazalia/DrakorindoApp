package com.cendekia.drakorindoapp.ui.drama

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.cendekia.drakorindoapp.data.DrakorindoRepository
import com.cendekia.drakorindoapp.data.source.local.entity.DramaEntity
import com.cendekia.drakorindoapp.vo.Resource

class DramaViewModel(private val drakorindoRepository: DrakorindoRepository) : ViewModel() {
    fun getDramas(): LiveData<Resource<PagedList<DramaEntity>>> =
        drakorindoRepository.getAllDramases()
}