package com.example.bottomsheetdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class  MainActivity : AppCompatActivity() , ExampleBottomSheetDialog.BottomSheetListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_open_bottom_sheet.setOnClickListener {
            val bottomSheet = ExampleBottomSheetDialog()
            bottomSheet.show(supportFragmentManager,"exampleBottomSheet")
        }

        go_second_activity_btn.setOnClickListener {
            val intent  =  Intent(this, PersistentBottomSheetActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onButtonClicked(text: String) {
        text_view_button_clicked.text = text
    }
}