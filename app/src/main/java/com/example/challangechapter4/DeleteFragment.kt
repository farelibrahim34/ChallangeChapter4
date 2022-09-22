package com.example.challangechapter4

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.challangechapter4.R
import com.example.challangechapter4.ViewModel.NoteViewModel
import com.example.challangechapter4.databinding.FragmentAddBinding
import com.example.challangechapter4.databinding.FragmentDeleteBinding
import com.example.challangechapter4.room.NoteDatabase


class DeleteFragment : Fragment() {
    lateinit var binding : FragmentDeleteBinding
    lateinit var shared : SharedPreferences
    var dbNote : NoteDatabase? = null
    val viewModel : NoteViewModel by viewModels()
    val notes by navArgs<EditFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_delete, container, false)
        binding = FragmentDeleteBinding.inflate(inflater,container,false)

        binding.btnHapusData.setOnClickListener {
            viewModel.deleteNote(notes.data.id!!)
            Navigation.findNavController(it!!).navigate(R.id.action_deleteFragment_to_homeFragment)
            Toast.makeText(context,"Berhasil Delete Note", Toast.LENGTH_SHORT).show()
        }
        binding.btnBatal.setOnClickListener {
            Toast.makeText(context,"Batal Delete Note", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(it!!).navigate(R.id.action_deleteFragment_to_homeFragment)
        }


        return binding.root
    }

}