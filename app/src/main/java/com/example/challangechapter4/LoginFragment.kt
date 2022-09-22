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
import com.example.challangechapter4.databinding.FragmentLoginBinding
import com.example.challangechapter4.databinding.FragmentRegisterBinding


class LoginFragment : Fragment() {

    lateinit var binding : FragmentLoginBinding
    lateinit var shared : SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_login, container, false)
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shared = requireContext().getSharedPreferences("datauser", Context.MODE_PRIVATE)

        binding.txtRegis.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }


        binding.btnLogin.setOnClickListener {

            var getDataEmail = shared.getString("email","")
            var getDataPw = shared.getString("password","")

            var email = binding.inputEmail.text.toString()
            var pw = binding.inputPw.text.toString()

            if (email.isEmpty() || pw.isEmpty()){
                Toast.makeText(context,"ISI PASSWORD DAN USERNAME ANDA", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }else if (email == getDataEmail.toString() && pw == getDataPw.toString()){
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                Toast.makeText(context,"Anda Berhasil Login", Toast.LENGTH_SHORT).show()

            }else if (email != getDataEmail.toString() || pw != getDataPw.toString()){
                Toast.makeText(context,"USERNAME DAN PASSWORD ANDA SALAH", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
    }


}