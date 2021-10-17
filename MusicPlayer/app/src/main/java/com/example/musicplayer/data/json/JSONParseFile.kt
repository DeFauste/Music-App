package com.example.musicplayer.data.json

import android.content.Context
import android.util.Log
import com.example.musicplayer.data.entities.Song
import org.json.JSONObject
import java.io.InputStream
import java.lang.Exception

class JSONParseFile(private val context: Context) {

    fun getListSongs(): List<Song> {
        val jsonString = loadJson()
        val json = JSONObject(jsonString)
        val availabilityArray = json.getJSONArray("data")
        Log.d("SIZE_DATA", "Size: ${availabilityArray.length()}")
        val sonsPlayList: MutableList<Song> = ArrayList()
        for (n in 0 until availabilityArray.length()) {
            val user = availabilityArray.getJSONObject(n)
            val medialid = user.getString("medialid")
            val title = user.getString("title")
            val subtitle = user.getString("subtitle")
            val songUrl = user.getString("songUrl")
            val imageUrl = user.getString("imageUrl")
            sonsPlayList.add(Song(medialid, title, subtitle, songUrl, imageUrl))
        }
        return sonsPlayList
    }

    private fun loadJson(): String? {
        var input: InputStream? = null
        var jsonString: String

        try {
            // Create InputStream
            input = context.assets.open("json_data.json")

            val size = input.available()

            // Create a buffer with the size
            val buffer = ByteArray(size)

            // Read data from InputStream into the Buffer
            input.read(buffer)

            // Create a json String
            jsonString = String(buffer)
            return jsonString
        } catch (ex: Exception) {
            ex.printStackTrace()
        } finally {
            // Must close the stream
            input?.close()
        }

        return null
    }
}
