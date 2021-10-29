package com.example.affirmation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmation.model.Startup
import com.squareup.picasso.Picasso
import com.tim3333.angelinvest.R

class RecentAdapter(private val context: Context,private val dataset:List<Startup>):RecyclerView.Adapter<RecentAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view:View): RecyclerView.ViewHolder(view) {

        val tvName: TextView =view.findViewById(R.id.item_tes)
        val tvLocation: TextView =view.findViewById(R.id.item_location)
        val tvDescription: TextView =view.findViewById(R.id.item_description)
        val imageView: ImageView=view.findViewById(R.id.item_image)
        val imageViewProfile: ImageView=view.findViewById(R.id.item_image_profile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item,parent,false)
        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount()=dataset.size


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item =dataset[position]
        holder.tvName.text=item.name
        holder.tvLocation.text=item.location
        holder.tvDescription.text=item.description
        Picasso.with(context).load(item.backImgUrl).into(holder.imageView)
        Picasso.with(context).load(item.imgUrl).into(holder.imageViewProfile)
    }
}