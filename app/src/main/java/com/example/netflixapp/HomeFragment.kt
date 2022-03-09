package com.example.netflixapp


import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.netflixapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {



//    var boxList = arrayListOf<>()

    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        val boxList = arrayListOf(binding.listVideo1,binding.listVideo2,
        binding.listVideo3,binding.listVideo4,binding.listVideo5,binding.listVideo6,
            binding.listVideo7,binding.listVideo8,binding.listVideo9,
            binding.listVideo10,binding.listVideo11,binding.listVideo12)




        for (i in 0 until boxList.size){
            boxList[i].txvVideoImage.text = Videos.videos[i].name
//            boxList[i].videoImage.setImageResource(Videos.videos[i].image)
            boxList[i].videoImage.setImageResource(R.drawable.f9 )
            if (Videos.videos[i].isFave){
                boxList[i].imvFav.setImageResource(R.drawable.ic_baseline_favorite_red)
            }else{
                boxList[i].imvFav.setImageResource(R.drawable.ic_baseline_favorite_24)
            }
        }




        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val boxList = arrayListOf(binding.listVideo1,binding.listVideo2,
            binding.listVideo3,binding.listVideo4,binding.listVideo5,binding.listVideo6,
            binding.listVideo7,binding.listVideo8,binding.listVideo9,
            binding.listVideo10,binding.listVideo11,binding.listVideo12)

        for (index in 0 until boxList.size){
            boxList[index].imvFav.setOnClickListener { setFavorite(index , boxList[index].imvFav)}
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_bar, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.favorite_item_menu -> {

                Toast.makeText(activity,"fave", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment)
                true
            }
            R.id.comingSoon_item_menu -> {
                Toast.makeText(activity,"came", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_homeFragment_to_comingSoonFragment)
                true
            }
            R.id.profile_item_menu -> {
                Toast.makeText(activity,"profile", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setFavorite(id:Int ,favImage:ImageView){
        if (Videos.videos[id].isFave){
            favImage.setImageResource(R.drawable.ic_baseline_favorite_24)
            Videos.videos[id].isFave = false
        }else{
            favImage.setImageResource(R.drawable.ic_baseline_favorite_red)
            Videos.videos[id].isFave = true
        }
    }
}