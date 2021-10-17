package com.example.musicplayer.data.json.model

import com.example.musicplayer.data.entities.Song
import com.google.gson.annotations.SerializedName

class ListSongsModel {
    @SerializedName("data")
    var data: ArrayList<Song> = ArrayList()
}