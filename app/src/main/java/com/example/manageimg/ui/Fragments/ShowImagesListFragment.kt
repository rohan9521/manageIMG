package com.example.manageimg.ui.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.manageimg.IMGDatabase.FileLocationRepository
import com.example.manageimg.IMGDatabase.RoomFileLocationDataBase
import com.example.manageimg.databinding.FragmentShowImagesListBinding
import com.example.manageimg.ui.main.ClickListener
import com.example.manageimg.ui.main.PageViewModel
import com.example.manageimg.ui.main.PageViewModelFactory
import com.example.manageimg.ui.main.ShowImagesAdapter

class ShowImagesListFragment :ClickListener, Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding  =FragmentShowImagesListBinding.inflate(inflater,container,false)
        Log.d("yesIts","visible")
        val fileLocationDataBase = RoomFileLocationDataBase.getDatabase(context = requireContext().applicationContext)
        val fileLocationDao  = fileLocationDataBase.getdDao()
        val repository = FileLocationRepository(fileLocationDao)
        val viewModelFactory = PageViewModelFactory(requireContext().applicationContext,repository)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(PageViewModel::class.java)

        val adapter = ShowImagesAdapter(this)
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext().applicationContext, 2)

        viewModel.fileList.observe(viewLifecycleOwner, Observer { list ->
            run {
                adapter.submitList(list)
                Log.d("newList",list.size.toString())
                adapter.notifyDataSetChanged()
            }
        })
        return binding.root
    }

        override fun onClick(imageLocation:String) {
            val action =ShowImagesListFragmentDirections.actionShowImagesListFragmentToShowImageFragment(imageLocation)
            findNavController().navigate(action)

    }


}