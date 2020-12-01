package com.example.retrofitandrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(val images:List<Hits>, val listener:OnItemClickListener): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

     var mlistener=listener;



    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var imageView: ImageView = itemView.findViewById(R.id.image_view);
        val text1: TextView = itemView.findViewById(R.id.text_view_creator);
        val text2: TextView = itemView.findViewById(R.id.text_view_likes);


        

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_view,
            parent, false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {



        holder.text1.setText(images.get(position).user)
        holder.text2.setText(images.get(position).likes.toString())

        Picasso.get().load(images.get(position).webformatURL).fit().centerInside().into(holder.imageView)


        holder.itemView.setOnClickListener(View.OnClickListener {
            mlistener.imageDetailsActivy(images.get(position))
        })

    }

    override fun getItemCount(): Int {
       return images.size
    }


    interface OnItemClickListener{

        fun imageDetailsActivy( image: Hits)

    }

}