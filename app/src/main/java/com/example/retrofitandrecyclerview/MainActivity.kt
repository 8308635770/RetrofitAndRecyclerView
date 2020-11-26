package com.example.retrofitandrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() ,RecyclerViewAdapter.OnItemClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar:ProgressBar=findViewById(R.id.progress_bar)

        val recyclerView=findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager=LinearLayoutManager(this)

        val viewModel:MainActivityViewModel=ViewModelProviders.of(this).get(MainActivityViewModel::class.java);

        viewModel.getImageLiveData().observe(this,{

            progressBar.visibility=View.GONE
            val hits=it.hits
            val adapter=RecyclerViewAdapter(hits,this)
            recyclerView.adapter=adapter
//            adapter.setOnitemClickListener(this)

        })




//        val call=RetrofitInstance.getRetrofit().create(Api::class.java)
//
//        call.getImages("19249476-a3a5bcf0c3157d2146aedc2df").enqueue(object : Callback<ImageResponse>{
//
//            override fun onResponse(call: Call<ImageResponse>, response: Response<ImageResponse>) {
//
//                progressBar.visibility=View.GONE
//                val result=response.body()
//                val images= result!!.hits
////                Log.i("images",images.toString())
//                val adapter=RecyclerViewAdapter(images)
//                recyclerView.adapter=adapter;
//
//
//            }
//
//            override fun onFailure(call: Call<ImageResponse>, t: Throwable) {
//            }
//
//        })
    }

    override fun imageDetailsActivy(image: Hits) {
//        Toast.makeText(this,image.user.toString(),Toast.LENGTH_SHORT).show()
        val intent=Intent(this,MainActivity2::class.java)
        intent.putExtra("IMAGE",image)
        startActivity(intent)
    }
}