package com.example.challangechapter4.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.challangechapter4.Repository.NoteRepository
import com.example.challangechapter4.room.DataNote
import com.example.challangechapter4.room.NoteDatabase

class NoteViewModel(application : Application) : AndroidViewModel(application) {

    val repository : NoteRepository

    init {
        val dao = NoteDatabase.getInstance(application)!!.noteDao()
        repository = NoteRepository(dao)
    }

    fun addNote(note : DataNote){
        repository.insertNote(note)
    }
    fun getNote():LiveData<List<DataNote>> = repository.getAllNote()

    fun deleteNote(id : Int){
        repository.deleteNote(id)
    }
    fun updateNote(note : DataNote){
        repository.updateNote(note)
    }
}