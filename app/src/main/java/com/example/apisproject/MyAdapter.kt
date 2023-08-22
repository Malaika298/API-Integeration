package com.example.apisproject

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter (val context: Activity, val productArrayList: List<Product>) :

RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.eachrow, parent, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = productArrayList[position]

        holder.productTite.text = currentItem.title

        holder.productDescription.text = currentItem.description

        holder.productPrice.text = currentItem.price.toString()
//        Show url images
//        Picasso

        Picasso.get().load(currentItem.thumbnail).into(holder.productImage);
    }


    class MyViewHolder (itemView :View): RecyclerView.ViewHolder(itemView) {

        var productTite :TextView
        var productImage: ShapeableImageView
        var productDescription:TextView
        var productPrice:TextView

        init {

            productTite = itemView.findViewById(R.id.tVProductName)
            productImage = itemView.findViewById(R.id.productImage)
            productDescription = itemView.findViewById(R.id.tVDescription)
            productPrice = itemView.findViewById(R.id.tVPrice)

        }
    }
}