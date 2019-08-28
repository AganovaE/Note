package com.example.Note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)

        val adapter = NotesAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val dialog = NoteDialogFragment(viewModel)

        floatActionBut.setOnClickListener {
            dialog.show(supportFragmentManager, "MyDialog")
        }

        viewModel.notes().observe(this, Observer {
            adapter.updateItems(it)
        })

    }



}
