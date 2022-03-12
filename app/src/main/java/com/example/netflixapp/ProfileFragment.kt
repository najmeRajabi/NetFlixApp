package com.example.netflixapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Display
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.netflixapp.databinding.FragmentProfileBinding


const val NAME :String = "name"
const val USERNAME :String = "username"
const val EMAIL :String = "email"
const val PHONE :String = "phone"

class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container , false)

        val sharedPreferences =activity?.getSharedPreferences("profileInfo" , Context.MODE_PRIVATE)

        if (sharedPreferences?.getString(NAME,null).isNullOrBlank() ){
            binding.llShowProfile.visibility =View.GONE
            binding.llSetAccount.visibility =View.VISIBLE
        }else{
            setVisibility()
            setTextInTextView()
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerBtn.setOnClickListener {
            if (checkInfo()){
                saveInfo()
                setVisibility()
                setTextInTextView()
            }
        }
    }

    private fun setTextInTextView() {
        val sharedPreferences = activity?.getSharedPreferences("profileInfo" , Context.MODE_PRIVATE)
        binding.nameTxv.text = sharedPreferences?.getString(NAME,"name")
        binding.emailTxv.text = sharedPreferences?.getString(EMAIL,"email")
        val username = sharedPreferences?.getString(USERNAME,"")
        val phone = sharedPreferences?.getString(PHONE,"")
        if (!username.isNullOrBlank()){
            binding.usernameTxv.visibility =View.VISIBLE
            binding.usernameTxv.text = username
        }else{
            binding.usernameTxv.visibility =View.GONE
        }
        if (!phone.isNullOrBlank()){
            binding.phoneTxv.visibility =View.VISIBLE
            binding.phoneTxv.text = phone
        }else{
            binding.phoneTxv.visibility =View.GONE
        }
    }

    private fun setVisibility() {
        binding.llShowProfile.visibility =View.VISIBLE
        binding.llSetAccount.visibility =View.GONE
    }

    private fun saveInfo() {
        val username = binding.usernameEdt.text
        val phone = binding.phoneEdt.text
        val sharedPreferences = activity?.getSharedPreferences("profileInfo" , Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.putString(NAME ,binding.nameEdt.text.toString())
        editor?.putString(EMAIL ,binding.emailEdt.text.toString())
        if (!username.isNullOrBlank()){
            editor?.putString(USERNAME ,username.toString())
        }
        if (!phone.isNullOrBlank()){
            editor?.putString(PHONE ,phone.toString())
        }
        editor?.apply()
    }

    private fun checkInfo():Boolean {
        var result = false
        when {
            binding.nameEdt.text.isNullOrBlank() -> {
                binding.nameEdt.error = "enter fullName"
            }
            binding.emailEdt.text.isNullOrBlank() -> {
                binding.emailEdt.error = "enter your email"
            }
            else -> result = true
        }

        return result
    }

}