package com.example.retrofitandrecyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

     var  repository:Repository;
     var images=MutableLiveData<ImageResponse>()

    init {
        repository= Repository().getInstance()!!
    }


    fun getImageLiveData():MutableLiveData<ImageResponse>{
       images= repository.getImages()
        return images
    }
}