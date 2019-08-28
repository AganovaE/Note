package com.example.Note

import android.app.Application
import androidx.room.Room

class App : Application() {

    companion object {
        private lateinit var instance: App

        fun getInstance() = instance
    }

    private lateinit var dataBase: NoteDataBase


    override fun onCreate() {
        super.onCreate()
        instance = this
        dataBase = Room.databaseBuilder(this, NoteDataBase::class.java, "database")
            .fallbackToDestructiveMigration().build()
    }

    fun getDataBase() = dataBase
}