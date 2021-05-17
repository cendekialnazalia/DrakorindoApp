package com.cendekia.drakorindoapp.di

import android.content.Context
import com.cendekia.drakorindoapp.data.DrakorindoRepository
import com.cendekia.drakorindoapp.data.source.local.LocalDataSource
import com.cendekia.drakorindoapp.data.source.local.room.FilmDatabase
import com.cendekia.drakorindoapp.data.source.remote.RemoteDataSource
import com.cendekia.drakorindoapp.utils.AppExecutors
import com.cendekia.drakorindoapp.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): DrakorindoRepository {

        val database = FilmDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.filmDao())
        val appExecutors = AppExecutors()

        return DrakorindoRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

}