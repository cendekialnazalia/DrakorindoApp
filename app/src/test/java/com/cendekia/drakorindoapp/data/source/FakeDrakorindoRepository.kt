package com.cendekia.drakorindoapp.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.cendekia.drakorindoapp.data.DrakorindoDataSource
import com.cendekia.drakorindoapp.data.NetworkBoundResource
import com.cendekia.drakorindoapp.data.source.local.LocalDataSource
import com.cendekia.drakorindoapp.data.source.local.entity.DramaEntity
import com.cendekia.drakorindoapp.data.source.local.entity.DramaWithDetail
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyEntity
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyWithDetail
import com.cendekia.drakorindoapp.data.source.remote.ApiResponse
import com.cendekia.drakorindoapp.data.source.remote.RemoteDataSource
import com.cendekia.drakorindoapp.data.source.remote.response.DramaResponse
import com.cendekia.drakorindoapp.data.source.remote.response.VarietyResponse
import com.cendekia.drakorindoapp.utils.AppExecutors
import com.cendekia.drakorindoapp.vo.Resource

class FakeDrakorindoRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : DrakorindoDataSource {

    override fun getAllDramases(): LiveData<Resource<PagedList<DramaEntity>>> {
        return object :
            NetworkBoundResource<PagedList<DramaEntity>, List<DramaResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<DramaEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllDramases(), config).build()
            }

            override fun shouldFetch(data: PagedList<DramaEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<DramaResponse>>> =
                remoteDataSource.getAllDramases()

            public override fun saveCallResult(dramaResponses: List<DramaResponse>) {
                val dramaList = ArrayList<DramaEntity>()
                for (response in dramaResponses) {
                    val drama = DramaEntity(
                        response.drakorindoId,
                        response.title,
                        response.typeDuration,
                        response.overview,
                        response.creator,
                        false,
                        response.imagePath,
                        response.linkTrailer
                    )
                    dramaList.add(drama)
                }

                localDataSource.insertDramases(dramaList)
            }
        }.asLiveData()
    }

    override fun getDramaWithDetail(drakorindoId: String): LiveData<Resource<DramaWithDetail>> {
        return object : NetworkBoundResource<DramaWithDetail, List<DramaResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<DramaWithDetail> =
                localDataSource.getDramaWithDetail(drakorindoId)

            override fun shouldFetch(dramaWithDetail: DramaWithDetail?): Boolean =
                dramaWithDetail?.mModules == null || dramaWithDetail.mModules.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<DramaResponse>>> =
                remoteDataSource.getAllDramases()

            override fun saveCallResult(moduleResponses: List<DramaResponse>) {
                val moduleList = ArrayList<DramaEntity>()
                for (response in moduleResponses) {
                    val drama = DramaEntity(
                        response.drakorindoId,
                        response.title,
                        response.typeDuration,
                        response.overview,
                        response.creator,
                        false,
                        response.imagePath,
                        response.linkTrailer
                    )
                    moduleList.add(drama)
                }
                localDataSource.insertDramases(moduleList)
            }
        }.asLiveData()
    }

    override fun getFavoritedDramases(): LiveData<PagedList<DramaEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoritedDramases(), config).build()
    }

    override fun setDramaFavorite(drama: DramaEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setDramaFavorite(drama, state) }


    override fun getAllVarietises(): LiveData<Resource<PagedList<VarietyEntity>>> {
        return object :
            NetworkBoundResource<PagedList<VarietyEntity>, List<VarietyResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<VarietyEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllVarietises(), config).build()
            }

            override fun shouldFetch(data: PagedList<VarietyEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<VarietyResponse>>> =
                remoteDataSource.getAllVarietises()

            public override fun saveCallResult(varietyResponses: List<VarietyResponse>) {
                val varietyList = ArrayList<VarietyEntity>()
                for (response in varietyResponses) {
                    val variety = VarietyEntity(
                        response.drakorindoId,
                        response.title,
                        response.typeDuration,
                        response.overview,
                        response.creator,
                        false,
                        response.imagePath,
                        response.linkTrailer
                    )
                    varietyList.add(variety)
                }

                localDataSource.insertVarietises(varietyList)
            }
        }.asLiveData()
    }

    override fun getVarietyWithDetail(drakorindoId: String): LiveData<Resource<VarietyWithDetail>> {
        return object :
            NetworkBoundResource<VarietyWithDetail, List<VarietyResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<VarietyWithDetail> =
                localDataSource.getVarietyWithDetail(drakorindoId)

            override fun shouldFetch(varietyWithDetail: VarietyWithDetail?): Boolean =
                varietyWithDetail?.mModules == null || varietyWithDetail.mModules.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<VarietyResponse>>> =
                remoteDataSource.getAllVarietises()

            override fun saveCallResult(moduleResponses: List<VarietyResponse>) {
                val moduleList = ArrayList<VarietyEntity>()
                for (response in moduleResponses) {
                    val variety = VarietyEntity(
                        response.drakorindoId,
                        response.title,
                        response.typeDuration,
                        response.overview,
                        response.creator,
                        false,
                        response.imagePath,
                        response.linkTrailer
                    )
                    moduleList.add(variety)
                }
                localDataSource.insertVarietises(moduleList)
            }
        }.asLiveData()
    }

    override fun getFavoritedVarietises(): LiveData<PagedList<VarietyEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoritedVarietises(), config).build()
    }

    override fun setVarietyFavorite(variety: VarietyEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setVarietyFavorite(variety, state) }

}