package com.cendekia.drakorindoapp.ui.varietyshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.cendekia.drakorindoapp.data.DrakorindoRepository
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyEntity
import com.cendekia.drakorindoapp.vo.Resource

class VarietyShowViewModel(private val drakorindoRepository: DrakorindoRepository) : ViewModel() {
    fun getVarietyShows(): LiveData<Resource<PagedList<VarietyEntity>>> =
        drakorindoRepository.getAllVarietises()
}