package com.example.netflixapp

import android.app.Notification
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.ActionMode
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
            boxList[i].imvVideo.setImageResource(R.drawable.film2021)
            boxList[i].txvVideoImage.text = Videos.comingSoonVideos[i].name
            boxList[i].imvFav.setImageResource(R.drawable.ic_baseline_share_24)
            explainList[i].text = Videos.comingSoonVideos[i].description
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val  boxList= arrayListOf(binding.listVideoCom1,
            binding.listVideoCom2 , binding.listVideoCom3)


        for (i in 0 until  boxList.size){
            boxList[i].imvFav.setOnClickListener {
                if (checkAccount()) {
                    shareDescription(Videos.comingSoonVideos[i].description.toString())
                }else{
                    Toast.makeText(activity,"you're not registered!", Toast.LENGTH_SHORT).show()
                }
                 }
        }
    }

    private fun shareDescription(message :String){
        val intent = Intent().apply {
            action=Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,message)
            type="text/plain"
        }

        val shareIntent = Intent.createChooser(intent,null)
        startActivity(shareIntent)
    }

    fun checkAccount():Boolean{
        val sharedPreferences = activity?.getSharedPreferences("profileInfo" , Context.MODE_PRIVATE)
        return !sharedPreferences?.getString(NAME,"").isNullOrBlank()
    }


}