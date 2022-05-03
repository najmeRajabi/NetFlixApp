package com.example.netflixapp


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.PorterDuff
import android.os.Bundle
import android.provider.MediaStore
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
    }

    private fun initViews() {
        val adapter = VideoAdapter(arrayListOf()){
            video ->
            checkRegistered()
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
                if (!checkAccount()){
                    showDefaultDialog()
                }else {

//                    Toast.makeText(activity, "fave", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment)
                }
                true
            }
            R.id.comingSoon_item_menu -> {
//                Toast.makeText(activity,"came", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_homeFragment_to_comingSoonFragment)
                true
            }
            R.id.profile_item_menu -> {
//                Toast.makeText(activity,"profile", Toast.LENGTH_SHORT).show()
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
    fun checkRegistered(): Boolean{
        return if (!checkAccount()){
//            Toast.makeText(requireContext(),"not registered !!",Toast.LENGTH_SHORT).show()
                showDefaultDialog()
            false
        }else
            true
    }

    private fun showDefaultDialog() {
        val alertDialog = AlertDialog.Builder(requireContext())

        alertDialog.apply {
            setTitle("not registered !!")
            setMessage("you're not registered yet. please first register")
            setPositiveButton("register") { _, _ ->
                findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
            }
            setNegativeButton("no thanks") { _, _ ->
                // dismiss
            }

        }.create().show()

    }
}