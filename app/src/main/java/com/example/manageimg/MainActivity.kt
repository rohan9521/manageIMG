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
import android.text.TextUtils
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.manageimg.ui.main.ShowImagesAdapter
import com.example.manageimg.ui.main.StorageUtil
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileInputStream

class MainActivity : AppCompatActivity() {
    private var imageList = mutableListOf<File>()
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
//        val viewPager: ViewPager = findViewById(R.id.view_pager)
//        viewPager.adapter = sectionsPagerAdapter
//        val tabs: TabLayout = findViewById(R.id.tabs)
//        tabs.setupWithViewPager(viewPager)

//      val  name = "images (7)" + "." +"jpeg"
//        var fileInputStream: Uri? = null
//        var  bitmap:Bitmap? = null
//        try{
//            fileInputStream = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
//            val orderBy = MediaStore.Images.Media.DATE_TAKEN
//            var projection  = arrayOf(MediaStore.Images.ImageColumns.DATA,MediaStore.Images.Media.BUCKET_DISPLAY_NAME )
////            bitmap = BitmapFactory.decodeStream(fileInputStream);
//            val cursor = applicationContext.contentResolver.query(fileInputStream,projection,null,null,orderBy+"DESC")
//            val column_Data = cursor!!.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)
////            val env  = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
////                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
////            } else {
////                TODO("VERSION.SDK_INT < R")
////            }
//            val file = File(Environment.DIRECTORY_DOWNLOADS,"images (7).jpeg")
//
//                val bitmap = BitmapFactory.decodeFile(file.absolutePath)
//                imageView.setImageBitmap(bitmap)
//
//            Log.d("fileError55",file.absolutePath)
////            while(cursor.moveToNext()){
////                textView.append(cursor.getString(column_Data))
////            }
//
////            imageView.setImageBitmap(bitmap)
////            fileInputStream.close();
//        } catch(e:Exception ) {
//            Log.d("imgUNIQUE",e.toString())
//        }
//        val env  = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES
//            )
//        } else {
//            TODO("VERSION.SDK_INT < R")
//        }
//        val file = File(Environment.getExternalStorageDirectory(),"images (7).jpeg")
//        Log.d("imgOne",file.absolutePath)
//        try {
//
//            val bitmap = BitmapFactory.decodeFile(file.absolutePath)
//            imageView.setImageBitmap(bitmap)
//        }catch (e:Exception){
//            Log.d("imgOne",e.toString())
//        }
//        val list = file.listFiles()
////        for(file in list){
////            Log.d("ImgTwo",file.absolutePath)
////        }
////        val listNew = mutableListOf<String>()
////        val selection = Bundle()
////            selection.putString("selection",MediaStore.Images.Media.IS_DOWNLOAD+"!=0")
//        val uri: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
////        val cursor2 = applicationContext.contentResolver!!.query(uri,null ,selection.getString("selection"),null,"DESC")
////        if(cursor2!=null){
//////            for(i in cursor2.getString(0))
//////                Log.d("enterFile3",i.toString())
////
////                Log.d("enterFile1",listNew.size.toString())
////                do{
////                    listNew.add(cursor2!!.getString(cursor2!!.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)))
////                    Log.d("enterFileImage",cursor2!!.getString(cursor2!!.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)))
////                }while (cursor2!!.moveToNext())
////
////        }
////        cursor2!!.close()
////        Log.d("enterFile",listNew.size.toString())
//
//        val directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
//       val lst =  getImages(directory)
//        if (lst != null) {
//            for(i in lst)
//                Log.d("imageList",i.toString())
//        }
//        for(i in imageList)
//            Log.d("imageListMutable",i.toString())
//        val cursor: Cursor?
//        var column_index_data: Int
//        var column_index_folder_name: Int
//        val listOfAllImages = ArrayList<String>()
//        var absolutePathOfImage: String? = null
//
//        val projection = arrayOf(MediaStore.Images.ImageColumns.DISPLAY_NAME, MediaStore.Images.Media._ID)
//        cursor = applicationContext.contentResolver!!.query(uri, projection, null, null, null)
//        cursor.use { cursor ->
//            column_index_folder_name = cursor!!
//            .getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)
//            Log.d("fileError22",cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)).toString())
//            column_index_data = cursor!!.getColumnIndexOrThrow(MediaStore.MediaColumns.DISPLAY_NAME)
//            while (cursor!!.moveToNext()) {
//                Log.d("fileError22",cursor.toString())
//                //  absolutePathOfImage = cursor!!.getString(column_index_data)
//                //listOfAllImages.add(absolutePathOfImage)
//            }
//        }
//
//
//
//
//        for(file in listOfAllImages){
//            Log.d("fileError2",file)
//
//        }
//        Log.d("fileError2",listOfAllImages.size.toString())
//
//
//
////                Log.d("fileError",file.listFiles().toString())
//        // Solution of empty raw emulated storage for android version >= marshmallow
//        // because the EXTERNAL_STORAGE become something like: "/Storage/A5F9-15F4",
//        // so we can't access it directly
////        val files = StorageUtil.getExternalFilesDirs(applicationContext, "image")
////        for (file in files) {
////            if (file != null) {
////                val applicationSpecificAbsolutePath = file.path
////                val rootPath = applicationSpecificAbsolutePath.substring(
////                    0,
////                    applicationSpecificAbsolutePath.indexOf("Android/data")
////                )
////               textView.append(file.toString())
////            }
////        }
//////    } else
//////    {
//////        if (TextUtils.isEmpty(StorageUtil.EXTERNAL_STORAGE)) {
//////            availableDirectoriesSet.addAll(StorageUtil.getAvailablePhysicalPaths())
//////        } else {
//////            // Device has physical external storage; use plain paths.
//////            availableDirectoriesSet.add(StorageUtil.EXTERNAL_STORAGE)
//////        }
////
////        val storage = StorageUtil.getStorageDirectories(this)
//////        for (i in storage){
//////            textView.append(i)
//////        }
//////        textView.text = storage.toString()
////       val fab: FloatingActionButton = findViewById(R.id.fab)
//
//        fab.setOnClickListener {
//            val intent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
//            startActivityForResult(intent,2)
////            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                    .setAction("Action", null).show()
//        }
        var cols = listOf<String>(MediaStore.Images.Media.DATA).toTypedArray()
        val selection = MediaStore.Images.Media.IS_DOWNLOAD + "!=0"
        var rs = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,cols,selection,null,null)
        val list  = mutableListOf<String>()
        if(rs?.moveToNext()!!) {
//            Log.d("firstElement", rs.count.toString())
            //val bitmap = BitmapFactory.decodeFile(rs.getString(0))
        Log.d("new",rs.count.toString())
            while (rs.moveToNext()){


                    Log.d("firstElement", rs.getString(0))
                    list.add(rs.getString(0))
                    val bitmap = BitmapFactory.decodeFile(rs.getString(0))



            }

        }
        val adapter = ShowImagesAdapter()
        adapter.list = list

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this,2)
//        rs.moveToNext()
//        if(rs?.moveToNext()!!) {
//            Log.d("firstElement", rs.count.toString())
//            val bitmap = BitmapFactory.decodeFile(rs.getString(0))
//            imageView.setImageBitmap(bitmap)
//        }
        Log.d("firstElement", "hi there")
    }

    fun getImages(file: File): Array<File>? {
        val imgList:ArrayList<File> = arrayListOf<File>()
        val list = file.listFiles()
        if(list!=null) {
            for (fileNew in list) {
                if (fileNew.isDirectory() && !file.isHidden) {
                    getImages(fileNew)
                } else {
                if(fileNew.name.endsWith(".jpeg")){
                    imageList.add(fileNew)
                    }
                }
            }
        }
        return list
    }
}