package com.example.manageimg.ui.main

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.manageimg.R

class ShowImagesAdapter:RecyclerView.Adapter<ShowImagesViewHolder>() {
    var list = mutableListOf<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowImagesViewHolder {
        val layoutInflator  = LayoutInflater.from(parent.context)
        val view  = layoutInflator.inflate(R.layout.show_images_view,parent,false)
        val showImagesViewHolder =  ShowImagesViewHolder(view)
        return  showImagesViewHolder
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ShowImagesViewHolder, position: Int) {
        val bitmap = BitmapFactory.decodeFile(list[position])
            holder.imageView.setImageBitmap(bitmap)
    }
}
class ShowImagesViewHolder(view:View):RecyclerView.ViewHolder(view){
    val imageView = view.findViewById<ImageView>(R.id.imageView2)
}