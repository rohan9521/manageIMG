package com.example.manageimg.ui.main

import android.os.Build
import android.os.Environment
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.io.File
import java.nio.file.Files

class PageViewModel : ViewModel() {

//    private val _index = MutableLiveData<Int>()
//    val text: LiveData<String> = Transformations.map(_index) {
//        "Hello world from section: $it"
//    }
//
//    fun setIndex(index: Int) {
//        _index.value = index
//    }
//
//    @RequiresApi(Build.VERSION_CODES.R)
//    fun fetchImages(directory:File):MutableList<File>{
//        var images = mutableListOf<File>()
//        var files= directory.listFiles()
//        for(i in files!!.indices){
//            if(files[i].isDirectory) {
//                images.addAll(fetchImages(files[i]))
//            }else{
//                if(files[i].name.endsWith(".JPG")){
//                    images.add(files[i])
//                }
//            }
//        }
//        return images
//
//    }
}