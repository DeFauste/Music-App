package com.example.musicplayer.data.remote

import android.content.Context
import com.example.musicplayer.data.entities.Song
import com.example.musicplayer.data.json.JSONParseFile
import com.example.musicplayer.data.other.Constants.SONG_COLLECTION
import com.google.firebase.firestore.FirebaseFirestore
import org.json.JSONObject


class MusicDatabase (private val context: Context) {

    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        return try {
//            songCollection.get().await().toObjects(Song::class.java)
            JSONParseFile(context).getListSongs()
        } catch (e: Exception) {
            emptyList()
        }
    }
}
