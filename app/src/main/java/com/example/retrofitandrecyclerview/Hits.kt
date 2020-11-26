package com.example.retrofitandrecyclerview

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Hits(@SerializedName("webformatURL") val webformatURL:String,
                @SerializedName("user") val user:String,
                @SerializedName("likes") val likes:Int):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(webformatURL)
        parcel.writeString(user)
        parcel.writeInt(likes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hits> {
        override fun createFromParcel(parcel: Parcel): Hits {
            return Hits(parcel)
        }

        override fun newArray(size: Int): Array<Hits?> {
            return arrayOfNulls(size)
        }
    }

}