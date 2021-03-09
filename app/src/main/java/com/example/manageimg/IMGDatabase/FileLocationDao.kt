package com.example.manageimg.IMGDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FileLocationDao {

    @Query("select * from FileLocationTable")
    fun getAllImageLocation():LiveData<List<String>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAllFileLocation(vararg fileLocation:FileLocationEntity)


}