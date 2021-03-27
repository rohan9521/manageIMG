package com.example.manageimg

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.findNavController
import com.example.manageimg.databinding.ShowImagesViewBinding
import com.example.manageimg.ui.Fragments.ShowImagesListFragment
import com.example.manageimg.ui.Fragments.ShowImagesListFragmentDirections
import com.example.manageimg.ui.main.ClickListener


class MainActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}