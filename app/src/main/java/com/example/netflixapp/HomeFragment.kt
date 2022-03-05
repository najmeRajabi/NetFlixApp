package com.example.netflixapp

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.*
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.netflixapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        val boxList = arrayListOf(binding.listVideo1,binding.listVideo2,
        binding.listVideo3,binding.listVideo4,binding.listVideo5,binding.listVideo6,
            binding.listVideo7,binding.listVideo8,binding.listVideo9,
            binding.listVideo10,binding.listVideo11,binding.listVideo12,
            binding.listVideo13,binding.listVideo14,binding.listVideo15,
            binding.listVideo16,binding.listVideo17, binding.listVideo18,
            binding.listVideo19,binding.listVideo20,binding.listVideo21)

        binding.listVideo1.txvVideoImage.text = Videos.videos[0].name
        binding.listVideo1.videoImage.setImageResource(Videos.videos[0].image)

        for (i in 0 until boxList.size){
            boxList[i].txvVideoImage.text = Videos.videos[i].name
            boxList[i].videoImage.setImageResource(Videos.videos[i].image)
            if (Videos.videos[i].isFave){
                boxList[i].imvFav.setColorFilter(R.color.red,PorterDuff.Mode.LIGHTEN)
//                boxList[i].imvFav.setImageResource(R.drawable.ic_baseline_favorite_24)
            }
        }


        return binding.root
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
            R.id.home_item_menu -> {
                Toast.makeText(activity,"home", Toast.LENGTH_SHORT).show()
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
}