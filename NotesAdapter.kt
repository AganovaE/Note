package com.example.Note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter: RecyclerView.Adapter<NoteViewHolder>() {

    private val items = mutableListOf<Note>()


    fun updateItems(newItems: List<Note>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }


    fun addNote(note: Note) {
        items.add(note)
        notifyItemInserted(items.size - 1)
    }


    override fun getItemCount() = items.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return NoteViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bindData(items[position])
    }



}