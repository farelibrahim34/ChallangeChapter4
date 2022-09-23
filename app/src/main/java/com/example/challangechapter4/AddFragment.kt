package com.example.challangechapter4

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.challangechapter4.ViewModel.NoteViewModel
import com.example.challangechapter4.databinding.FragmentAddBinding
import com.example.challangechapter4.room.DataNote
import com.example.challangechapter4.room.NoteDatabase


class AddFragment : Fragment() {
    lateinit var binding : FragmentAddBinding
    lateinit var shared : SharedPreferences
    var dbNote : NoteDatabase? = null
    val viewModel : NoteViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_add, container, false)
        binding = FragmentAddBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        dbNote = NoteDatabase.getInstance(requireContext())

        binding.btnInput.setOnClickListener {
            addNote(it)

        }

    }
    fun addNote(it : View?){


            var judul = binding.inputJudul.text.toString()
            var isi = binding.inputIsi.text.toString()

//            var data = dbNote!!.noteDao().insertNote(DataNote(0,judul,isi))


        val data = DataNote(null, title = judul, content = isi)
        viewModel.addNote(data)

//        val data = DataNote(null, title = judul, content = isi)
//        if (data.content.isEmpty() && data.title.isEmpty()){
//            Toast.makeText(context, "Note Kosong", Toast.LENGTH_SHORT).show()
//        }else{
//            viewModel.addNote(data)
//        }


        Toast.makeText(context, "Berhasil", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_addFragment_to_homeFragment)
    }

}