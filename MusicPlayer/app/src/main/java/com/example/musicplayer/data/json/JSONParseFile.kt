package com.example.musicplayer.data.json

import android.content.Context
import com.example.musicplayer.data.entities.Song
import org.json.JSONObject
import java.io.InputStream
import java.lang.Exception

class JSONParseFile(private val context: Context) {

    fun getListSongs(): List<Song> {
        val jsonString = loadJson()
            ?: return emptyList() // получаем данные для JSON, если null возвращаем пустой лист
        val json = JSONObject(jsonString) // Создаем JSON объект

        val availabilityArray = json.getJSONArray("data") // получаем JSON массив 

        val sonsPlayList: MutableList<Song> = ArrayList()

        // Извлекаем данные из JSON массива и на их основе создаем Song и помещаем их в ArrayList
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
            // создаем поток для чтения, файл может отсуствовать
            input = context.assets.open("json_data.json")

            val size = input.available()

            // создаем буффер размером считанного файла
            val buffer = ByteArray(size)

            // считывем данные и записываем их в буффер
            input.read(buffer)

            // преобразовываем буффер в String
            jsonString = String(buffer)
            return jsonString
        } catch (ex: Exception) {
            ex.printStackTrace()
        } finally {
            // Закрываем поток для чтения
            input?.close()
        }

        return null
    }
}
