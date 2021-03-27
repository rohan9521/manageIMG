package com.example.manageimg.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.manageimg.R
import com.example.manageimg.databinding.FragmentShowImageBinding
import com.example.manageimg.databinding.ShowImagesViewBinding

class ShowImageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentShowImageBinding.inflate(inflater,container,false)
        val arg = arguments?.let { ShowImageFragmentArgs.fromBundle(it) }
        val imageLocation = arg?.imageLocation
        Glide.with(binding.showImage.context).load(imageLocation).into(binding.showImage)
        return binding.root
    }

}