package com.example.manageimg.IMGDatabase

import androidx.lifecycle.LiveData

class FileLocationRepository(val fileLocationDao: FileLocationDao) {
    suspend fun getAllImageLocation():LiveData<List<String>>{
        return  fileLocationDao.getAllImageLocation()
    }
}