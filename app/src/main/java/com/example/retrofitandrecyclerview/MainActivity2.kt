package com.example.retrofitandrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val i=intent
        val image=i.getParcelableExtra<Hits>("IMAGE")

        val imageView=findViewById<ImageView>(R.id.image_view_detail)
        val text1:TextView=findViewById(R.id.text_view_creator_detail)
        val text2:TextView=findViewById(R.id.text_view_like_detail)

        Picasso.get().load(image.webformatURL).fit().centerInside().into(imageView)
        text1.setText(image.user)
        text2.setText(image.likes.toString())
    }
}