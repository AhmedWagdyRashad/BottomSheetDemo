package com.example.bottomsheetdemo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.lang.ClassCastException

class ExampleBottomSheetDialog: BottomSheetDialogFragment() {

private lateinit var mListener: BottomSheetListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.bottom_sheet_layout, container, false)
        val button1 = v.findViewById<Button>(R.id.button1)
        val button2 = v.findViewById<Button>(R.id.button2)

        button1.setOnClickListener {
            mListener.onButtonClicked("Button 1 clicked")
            dismiss()
        }
        button2.setOnClickListener {
            mListener.onButtonClicked("Button 2 clicked")
            dismiss()
        }

        return v
    }


    interface BottomSheetListener{
        fun onButtonClicked(text:String)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mListener = context as (BottomSheetListener)
        }catch (e:ClassCastException){
            throw ClassCastException("$context must implement bottom sheet")
        }
    }
}