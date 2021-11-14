package com.example.musicplayer.data.entities

// для хранение наших песен
data class Song(
    val medialid: String = "",
    val title: String = "",
    val subtitle: String = "",
    val songUrl: String = "",
    val imageUrl: String = ""
)
