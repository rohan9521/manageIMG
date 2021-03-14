package com.example.manageimg.ui.main

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.manageimg.IMGDatabase.FileLocationEntity
import com.example.manageimg.R
import androidx.recyclerview.widget.ListAdapter
class ShowImagesAdapter: ListAdapter<FileLocationEntity, ShowImagesViewHolder>(DiffUtilCall()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowImagesViewHolder {
        val layoutInflator  = LayoutInflater.from(parent.context)
        val view  = layoutInflator.inflate(R.layout.show_images_view,parent,false)
        val showImagesViewHolder =  ShowImagesViewHolder(view)
        return  showImagesViewHolder
    }



    override fun onBindViewHolder(holder: ShowImagesViewHolder, position: Int) {
       // val bitmap = BitmapFactory.decodeFile(list[position].location)
        Glide.with(holder.imageView.context).load(getItem(position).location).into(holder.imageView)
     //       holder.imageView.setImageBitmap(bitmap)
    }
}
class ShowImagesViewHolder(view:View):RecyclerView.ViewHolder(view){
    val imageView = view.findViewById<ImageView>(R.id.imageView2)
}

class DiffUtilCall: DiffUtil.ItemCallback<FileLocationEntity>() {
    override fun areItemsTheSame(
        oldItem: FileLocationEntity,
        newItem: FileLocationEntity
    ): Boolean {
        return oldItem.location == newItem.location
    }

    override fun areContentsTheSame(
        oldItem: FileLocationEntity,
        newItem: FileLocationEntity
    ): Boolean {
        return oldItem.location == newItem.location
    }

}