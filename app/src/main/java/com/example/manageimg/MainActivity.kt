package com.example.manageimg

import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import android.text.TextUtils
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.manageimg.ui.main.PageViewModel
import com.example.manageimg.ui.main.PageViewModelFactory
import com.example.manageimg.ui.main.ShowImagesAdapter
import com.example.manageimg.ui.main.StorageUtil
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.io.File
import java.io.FileInputStream

class MainActivity : AppCompatActivity() {
    private var imageList = mutableListOf<File>()
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModelFactory = PageViewModelFactory(applicationContext)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(PageViewModel::class.java)
        val adapter = ShowImagesAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        viewModel._fileList.observe(this, Observer { list ->
            run {
                adapter.list = list
                Log.d("newList",list.size.toString())
                adapter.notifyDataSetChanged()
            }
        })


    }
}