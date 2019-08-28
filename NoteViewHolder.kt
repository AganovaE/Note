package com.example.Note

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    var textView: TextView? = null

    var note: Note? = null

    init {
        textView = itemView.findViewById(R.id.textView)
    }

    fun bindData(note: Note) {
        this.note = note
        textView?.text = note.note
    }


}