package com.example.Note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_dialog.*

class NoteDialogFragment(val viewModel: NotesViewModel) : DialogFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dialog, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            buttonReturn.setOnClickListener {
                editText.text.clear()
                dismiss()
            }

            buttonOk.setOnClickListener {
                val note = Note(note = editText.text.toString())
                viewModel.saveNote(note)
                editText.text.clear()
                dismiss()
            }
    }

}