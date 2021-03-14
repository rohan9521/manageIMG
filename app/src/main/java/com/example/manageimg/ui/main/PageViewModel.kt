package com.example.manageimg.ui.main

import android.content.Context
import android.provider.MediaStore
import android.util.Log
import androidx.lifecycle.*
import com.example.manageimg.IMGDatabase.FileLocationEntity
import com.example.manageimg.IMGDatabase.FileLocationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PageViewModel(val applicationContext: Context,val fileLocationRepository:FileLocationRepository) : ViewModel() {
    var _fileList = MutableLiveData<MutableList<FileLocationEntity>>()
    lateinit var fileList:LiveData<List<FileLocationEntity>>
    var cols = listOf<String>(MediaStore.Images.Media.DATA,MediaStore.Images.Media.DATE_MODIFIED).toTypedArray()
    val orderBy = MediaStore.Images.Media.DATE_MODIFIED
    var rs = applicationContext.contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,cols,null,null,orderBy)

    init {
        fetchFileLocation()
    viewModelScope.launch(Dispatchers.Main) {
        getFileList()

    }

    }
    fun fetchFileLocation() = viewModelScope.launch(Dispatchers.IO) {
        fileList = fileLocationRepository.fileLocationDao.getAllImageLocation()
    }

  suspend fun getFileList() {


                if(rs?.moveToNext()!!) {
                    val fileLocationEntityOne = FileLocationEntity()
                    fileLocationEntityOne.location = rs!!.getString(0)
                    withContext(Dispatchers.IO){
                    fileLocationRepository.fileLocationDao.insertAllFileLocation(fileLocationEntityOne)
                    }
                    while (rs!!.moveToNext()){
                        val fileLocationEntity = FileLocationEntity()
                        fileLocationEntity.location = rs!!.getString(0)

                        withContext(Dispatchers.IO){
                            fileLocationRepository.fileLocationDao.insertAllFileLocation(fileLocationEntity)
                        }
            Log.d("list", _fileList.value?.size.toString())
                    }

                }



}
}