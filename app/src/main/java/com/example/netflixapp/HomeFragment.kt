package com.example.netflixapp

import android.os.Bundle
import android.view.*
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
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