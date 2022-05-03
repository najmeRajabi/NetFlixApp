package com.example.netflixapp


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.PorterDuff
import android.os.Bundle
import android.provider.MediaStore
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
//        val boxList = arrayListOf(binding.listVideo1,binding.listVideo2,
//            binding.listVideo3,binding.listVideo4,binding.listVideo5,binding.listVideo6,
//            binding.listVideo7,binding.listVideo8,binding.listVideo9,
//            binding.listVideo10,binding.listVideo11,binding.listVideo12)
//
//        for (index in 0 until boxList.size){
//            boxList[index].imvFav.setOnClickListener {
//                if (checkAccount()) {
//                    setFavorite(index, boxList[index].imvFav)
//                }else{
//                    Toast.makeText(activity,"you're not registered!",Toast.LENGTH_SHORT).show()
//                }
//                }
//        }
    }

    private fun initViews() {
        val adapter = VideoAdapter(arrayListOf()){
            video ->
            checkAccount()
        }
        adapter.submitList(Videos.videos)
        binding.recyclerHome.apply {
            this.adapter = adapter
        layoutManager = GridLayoutManager(requireContext(),3)}
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

    fun checkAccount():Boolean{
        val sharedPreferences = activity?.getSharedPreferences("profileInfo" , Context.MODE_PRIVATE)
        return !sharedPreferences?.getString(NAME,"").isNullOrBlank()
    }
}