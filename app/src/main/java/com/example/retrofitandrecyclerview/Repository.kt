package com.example.retrofitandrecyclerview

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private var repository: Repository? = null
    private var api:Api


    fun getInstance(): Repository? {
        if (repository == null) {
            repository = Repository()
        }
        return repository
    }

    init {
        api=RetrofitInstance.getRetrofit().create(Api::class.java)
    }

    fun getImages():MutableLiveData<ImageResponse>{
        val images=MutableLiveData<ImageResponse>()

        val call=api.getImages("19249476-a3a5bcf0c3157d2146aedc2df")

        call.enqueue(object :Callback<ImageResponse>{
            override fun onResponse(call: Call<ImageResponse>, response: Response<ImageResponse>) {
                images.value=response.body()
            }

            override fun onFailure(call: Call<ImageResponse>, t: Throwable) {
                images.value=null
            }

        })

        return images

    }

}