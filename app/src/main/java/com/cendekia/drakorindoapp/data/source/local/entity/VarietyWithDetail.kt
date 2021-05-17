package com.cendekia.drakorindoapp.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class VarietyWithDetail(
    @Embedded
    var mVariety: VarietyEntity,

    @Relation(parentColumn = "varietyId", entityColumn = "varietyId")
    var mModules: List<VarietyEntity>
)