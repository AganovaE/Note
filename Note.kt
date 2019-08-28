package com.example.Note

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    var Id: Long = 0,

    @ColumnInfo(name = "note")
    var note: String
)