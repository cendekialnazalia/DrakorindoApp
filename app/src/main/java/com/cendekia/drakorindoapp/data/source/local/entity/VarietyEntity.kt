package com.cendekia.drakorindoapp.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "varietyentities")
data class VarietyEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "varietyId")
    var drakorindoId: String,

    @ColumnInfo(name = "tittle")
    var title: String,

    @ColumnInfo(name = "typeDuration")
    var typeDuration: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "creator")
    var creator: String,

    @ColumnInfo(name = "favorited")
    var favorited: Boolean = false,

    @ColumnInfo(name = "imagePath")
    var imagePath: String,

    @ColumnInfo(name = "linkTrailer")
    var linkTrailer: String
)