package com.example.netflixapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.netflixapp.databinding.FragmentComingSoonBinding


class ComingSoonFragment : Fragment() {


    lateinit var binding: FragmentComingSoonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComingSoonBinding.inflate(layoutInflater, container, false)

        val  boxList= arrayListOf(binding.listVideoCom1,
        binding.listVideoCom2 , binding.listVideoCom3)
        val explainList = arrayListOf(binding.description1Txv,
        binding.description2Txv , binding.description3Txv)

        for ( i in 0 until Videos.comingSoonVideos.size){
            boxList[i].videoImage.setImageResource(R.drawable.film2021)
            boxList[i].txvVideoImage.text = Videos.comingSoonVideos[i].name
            boxList[i].imvFav.setImageResource(R.drawable.ic_baseline_share_24)
            explainList[i].text = Videos.comingSoonVideos[i].description
        }
        // Inflate the layout for this fragment
        return binding.root
    }


}