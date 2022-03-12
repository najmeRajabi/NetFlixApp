package com.example.netflixapp

import android.content.Context
import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.viewbinding.ViewBinding
import com.example.netflixapp.databinding.FragmentFavoriteBinding
import com.example.netflixapp.databinding.FragmentHomeBinding



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

        val boxList = arrayListOf(binding.listVideoFav1,binding.listVideoFav2,
        binding.listVideoFav3 , binding.listVideoFav4,binding.listVideoFav5,
        binding.listVideoFav6 ,binding.listVideoFav7,binding.listVideoFav8,
        binding.listVideoFav9 ,binding.listVideoFav10,binding.listVideoFav11,
        binding.listVideoFav12
        )

        when {
            !checkAccount() -> {
                Toast.makeText(activity,"you're not registered!", Toast.LENGTH_SHORT).show()
            }
            favorites.isNullOrEmpty() -> {
                binding.emptyImv.visibility = View.VISIBLE
            }
            else -> {

                for (i in 0 until favorites.size) {
                    boxList[i].txvVideoImage.text = favorites[i].name
                    boxList[i].videoImage.setImageResource(favorites[1].image)
                    if (favorites[i].isFave) {
                        boxList[i].imvFav.setImageResource(R.drawable.ic_baseline_favorite_red)
                    }

                }
            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    fun checkAccount():Boolean{
        val sharedPreferences = activity?.getSharedPreferences("profileInfo" , Context.MODE_PRIVATE)
        return !sharedPreferences?.getString(NAME,"").isNullOrBlank()
    }


}