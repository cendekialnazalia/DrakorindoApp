package com.cendekia.drakorindoapp.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cendekia.drakorindoapp.data.source.local.entity.DramaEntity
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyEntity

@Database(
    entities = [DramaEntity::class, VarietyEntity::class],
    version = 1,
    exportSchema = false
)
abstract class FilmDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao

    companion object {

        @Volatile
        private var INSTANCE: FilmDatabase? = null

        fun getInstance(context: Context): FilmDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    FilmDatabase::class.java,
                    "Films.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }
}