package com.example.netflixapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.netflixapp.databinding.FragmentFavoriteBinding


class FavoriteFragment : Fragment() {


    var favorites = arrayListOf<Video>()
    private lateinit var binding: FragmentFavoriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        for (v in Videos.videos){
            if (v.isFave){
                favorites.add(v)
            }
        }


        when {
            favorites.isNullOrEmpty() -> {
                binding.emptyImv.visibility = View.VISIBLE
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

    }

    private fun initViews() {
        val adapter = VideoAdapter(arrayListOf()){
            video ->
            true
        }
        adapter.submitList(favorites)
        binding.recyclerFavorite.apply {
            this.adapter = adapter
            layoutManager = GridLayoutManager(requireContext(),4)
        }
    }



}