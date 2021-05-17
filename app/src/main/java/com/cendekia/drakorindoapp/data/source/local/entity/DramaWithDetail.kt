package com.cendekia.drakorindoapp.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class DramaWithDetail(
    @Embedded
    var mDrama: DramaEntity,

    @Relation(parentColumn = "dramaId", entityColumn = "dramaId")
    var mModules: List<DramaEntity>
)