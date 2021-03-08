package com.example.manageimg.ui.main

import android.app.Application
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.nio.file.Files

class PageViewModel(val applicationContext: Context) : ViewModel() {
    var _fileList = MutableLiveData<MutableList<String>>()

    var cols = listOf<String>(MediaStore.Images.Media.DATA).toTypedArray()

    var rs = applicationContext.contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,cols,null,null,null)

    init {
    viewModelScope.launch(Dispatchers.Main) {
        getFileList()
    }

    }
  suspend fun getFileList() {
      _fileList.value = mutableListOf<String>()

                if(rs?.moveToNext()!!) {
                    _fileList.value?.add(rs!!.getString(0))
                    while (rs!!.moveToNext()){
                        _fileList.value?.add(rs!!.getString(0))
            Log.d("list", _fileList.value?.size.toString())
                    }

                }



}
}