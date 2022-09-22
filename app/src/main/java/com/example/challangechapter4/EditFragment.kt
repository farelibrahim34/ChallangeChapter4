package com.example.challangechapter4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.challangechapter4.ViewModel.NoteViewModel
import com.example.challangechapter4.databinding.FragmentEditBinding
import com.example.challangechapter4.room.DataNote


class EditFragment : Fragment() {
    val notes by navArgs<EditFragmentArgs>()
    val viewModel : NoteViewModel by viewModels()
    lateinit var binding : FragmentEditBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditBinding.inflate(layoutInflater,container,false)
//        return inflater.inflate(R.layout.fragment_edit, container, false)

        binding.inputJudulEdit.setText(notes.data.title)
        binding.inputIsiEdit.setText(notes.data.content)

        binding.btnInputEdit.setOnClickListener {
            updateNote(it)
        }


        return binding.root
    }

    private fun updateNote(it: View?) {
        var judul = binding.inputJudulEdit.text.toString()
        var isi = binding.inputIsiEdit.text.toString()

//            var data = dbNote!!.noteDao().insertNote(DataNote(0,judul,isi))


        val data = DataNote(notes.data.id, title = judul, content = isi)
        viewModel.updateNote(data)


        Toast.makeText(context, "Update Berhasil", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_editFragment_to_homeFragment)

    }

}