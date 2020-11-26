package com.example.retrofitandrecyclerview

import com.google.gson.annotations.SerializedName

data class ImageResponse(@SerializedName ("hits") val hits:List<Hits>,
                         @SerializedName("total") val total:Int,
                         @SerializedName("totalHits") val totalHits:Int) {

}

