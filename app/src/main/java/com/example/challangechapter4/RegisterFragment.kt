package com.example.challangechapter4

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.challangechapter4.databinding.FragmentRegisterBinding
import kotlinx.android.synthetic.main.fragment_register.*


class RegisterFragment : Fragment() {

    lateinit var binding : FragmentRegisterBinding
    lateinit var shared : SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_register, container, false)
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shared = requireContext().getSharedPreferences("datauser",Context.MODE_PRIVATE)

        binding.btnDaftar.setOnClickListener {


        var getEmail = binding.registEmail.text.toString()
        var getUser = binding.registUser.text.toString()
        var getPw = binding.registPw.text.toString()
        var getUpw = binding.registUlangPw.text.toString()

        var addDataUser = shared.edit()
        addDataUser.putString("email",getEmail)
        addDataUser.putString("user",getUser)
        addDataUser.putString("password",getPw)
        addDataUser.putString("ulangpassword",getUpw)
        addDataUser.apply()
//        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        if (getEmail == "" && getUser == "" || getPw == "" || getUpw == ""){
            Toast.makeText(context,"Isi Lengkap Form Registrasi Terlebih Dahulu", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }else if (getUser == ""){
            Toast.makeText(context,"Isi Lengkap Form Registrasi Terlebih Dahulu", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }else if (getPw == ""){
            Toast.makeText(context,"Isi Lengkap Form Registrasi Terlebih Dahulu", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }else if (getUpw == ""){
            Toast.makeText(context,"Isi Lengkap Form Registrasi Terlebih Dahulu", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        } else {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }



        Toast.makeText(context,"Terimakasih Anda Telah Registrasi", Toast.LENGTH_SHORT).show()

        }


    }
//    fun registrasi(){
//
//        var getEmail = binding.registEmail.text.toString()
//        var getUser = binding.registUser.text.toString()
//        var getPw = binding.registPw.text.toString()
//        var getUpw = binding.registUlangPw.text.toString()
//
//        var addDataUser = shared.edit()
//        addDataUser.putString("email",getEmail)
//        addDataUser.putString("user",getUser)
//        addDataUser.putString("password",getPw)
//        addDataUser.putString("ulangpassword",getUpw)
//        addDataUser.apply()
////        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
//        if (getEmail == "" && getUser == "" && getPw == "" && getUpw == ""){
//            return
//        }
//
//
//
//        Toast.makeText(context,"Terimakasih Anda Telah Registrasi", Toast.LENGTH_SHORT).show()
//    }

}