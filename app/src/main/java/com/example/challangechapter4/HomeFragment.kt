package com.example.challangechapter4

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challangechapter4.ViewModel.NoteViewModel
import com.example.challangechapter4.databinding.FragmentHomeBinding
import com.example.challangechapter4.room.NoteDatabase


class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    lateinit var shared : SharedPreferences
    var NoteDB : NoteDatabase? = null
    lateinit var adapterNote : NoteAdapter
    val viewModel : NoteViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        viewModel.getNote().observe(viewLifecycleOwner,{ listNote ->

            binding.rvNote.layoutManager = LinearLayoutManager(requireContext())
            binding.rvNote.adapter = NoteAdapter(requireContext(),listNote)

        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shared = requireContext().getSharedPreferences("datauser", Context.MODE_PRIVATE)






        var getUsername = shared.getString("user","")
        binding.txtUsername.text = "Welcome "+getUsername

        binding.txtLogout.setOnClickListener {
            val pref = shared.edit()
            pref.clear()
            pref.apply()
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
            Toast.makeText(context,"Anda Berhasil Logout", Toast.LENGTH_SHORT).show()
        }


        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        }
//        getAllNote()

    }

//    fun getAllNote(){
//        GlobalScope.launch {
//            var data = NoteDB?.noteDao()?.getDataNote()
//
//                adapterNote = NoteAdapter(data!!)
//                binding.rvNote.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
//                binding.rvNote.adapter = adapterNote
//
//
//        }
//
//    }



}