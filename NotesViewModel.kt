package com.example.Note

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class NotesViewModel: ViewModel() {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    fun notes() = App.getInstance().getDataBase().noteDataBaseDao.getAll()


    fun saveNote(note: Note) {
        uiScope.launch {
            insert(note)
        }
    }


    private suspend fun insert(note: Note) {
        withContext(Dispatchers.IO) {
            App.getInstance().getDataBase().noteDataBaseDao.insert(note)
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}