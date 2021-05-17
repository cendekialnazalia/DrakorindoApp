package com.cendekia.drakorindoapp.utils

import android.content.Context
import com.cendekia.drakorindoapp.data.source.remote.response.DramaResponse
import com.cendekia.drakorindoapp.data.source.remote.response.VarietyResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadDramas(): List<DramaResponse> {
        val list = ArrayList<DramaResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("DramaResponses.json").toString())
            val listArray = responseObject.getJSONArray("drama")
            for (i in 0 until listArray.length()) {
                val drama = listArray.getJSONObject(i)

                val drakorindoId = drama.getString("drakorindoId")
                val title = drama.getString("title")
                val typeDuration = drama.getString("typeDuration")
                val overview = drama.getString("overview")
                val creator = drama.getString("creator")
                val imagePath = drama.getString("imagePath")
                val linkTrailer = drama.getString("linkTrailer")

                val dramaResponse = DramaResponse(
                    drakorindoId,
                    title,
                    typeDuration,
                    overview,
                    creator,
                    imagePath,
                    linkTrailer
                )
                list.add(dramaResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadVarieties(): List<VarietyResponse> {
        val list = ArrayList<VarietyResponse>()
        try {
            val responseObject =
                JSONObject(parsingFileToString("DataVarietyShowResponses.json").toString())
            val listArray = responseObject.getJSONArray("variety")
            for (i in 0 until listArray.length()) {
                val variety = listArray.getJSONObject(i)

                val drakorindoId = variety.getString("drakorindoId")
                val title = variety.getString("title")
                val typeDuration = variety.getString("typeDuration")
                val overview = variety.getString("overview")
                val creator = variety.getString("creator")
                val imagePath = variety.getString("imagePath")
                val linkTrailer = variety.getString("linkTrailer")

                val varietyResponse = VarietyResponse(
                    drakorindoId,
                    title,
                    typeDuration,
                    overview,
                    creator,
                    imagePath,
                    linkTrailer
                )
                list.add(varietyResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }
}