package com.cendekia.drakorindoapp.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cendekia.drakorindoapp.data.source.remote.response.DramaResponse
import com.cendekia.drakorindoapp.data.source.remote.response.VarietyResponse
import com.cendekia.drakorindoapp.utils.EspressoIdlingResource
import com.cendekia.drakorindoapp.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {
    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllDramases(): LiveData<ApiResponse<List<DramaResponse>>> {
        EspressoIdlingResource.increment()
        val resultDrama = MutableLiveData<ApiResponse<List<DramaResponse>>>()
        handler.postDelayed({
            resultDrama.value = ApiResponse.success(jsonHelper.loadDramas())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultDrama
    }

    fun getAllVarietises(): LiveData<ApiResponse<List<VarietyResponse>>> {
        EspressoIdlingResource.increment()
        val resultVariety = MutableLiveData<ApiResponse<List<VarietyResponse>>>()
        handler.postDelayed({
            resultVariety.value = ApiResponse.success(jsonHelper.loadVarieties())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultVariety
    }
}