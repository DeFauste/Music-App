package com.example.musicplayer.data.remote

import android.content.Context
import com.example.musicplayer.data.entities.Song
import com.example.musicplayer.data.json.JSONParseFile

class MusicDatabase(private val context: Context) {
    suspend fun getAllSongs(): List<Song> {
        return try {
            JSONParseFile(context).getListSongs()
        } catch (e: Exception) {
            emptyList()
        }
    }
}
// class MusicDatabase(private val context: Context) {
//
//    private val firestore = FirebaseFirestore.getInstance()
//    private val songCollection = firestore.collection(SONG_COLLECTION)

//    suspend fun getAllSongs(): List<Song> {
//        return try {
//             songCollection.get().await().toObjects(Song::class.java)
//        } catch (e: Exception) {
//            emptyList()
//        }
//    }
// }
