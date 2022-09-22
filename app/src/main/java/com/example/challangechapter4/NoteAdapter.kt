package com.example.challangechapter4

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.challangechapter4.databinding.ItemNoteBinding
import com.example.challangechapter4.room.DataNote
import com.example.challangechapter4.room.NoteDatabase

class NoteAdapter(val requireContext: Context,val listNote: List<DataNote>): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    var DBNote: NoteDatabase? = null

    class ViewHolder(var binding : ItemNoteBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listNote[position]

        holder.binding.txtJudul.text = listNote[position].title
        holder.binding.txtIsi.text = listNote[position].content
        holder.binding.btnEdit.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToEditFragment(data)
            Navigation.findNavController(it).navigate(action)

        }

        holder.binding.btnDelete.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDeleteFragment(data)
            Navigation.findNavController(it).navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return listNote.size
    }
}