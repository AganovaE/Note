package com.example.Note

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDataBase: RoomDatabase() {
    abstract val noteDataBaseDao: NoteDataBaseDao
}
