package com.cendekia.drakorindoapp.data.source.remote.response

import android.os.Parcelable

@kotlinx.android.parcel.Parcelize
data class VarietyResponse(
    var drakorindoId: String,
    var title: String,
    var typeDuration: String,
    var overview: String,
    var creator: String,
    var imagePath: String,
    var linkTrailer: String
) : Parcelable