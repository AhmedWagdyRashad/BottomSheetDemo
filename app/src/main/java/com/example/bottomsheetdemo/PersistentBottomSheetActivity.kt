package com.example.bottomsheetdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_persistent_bottom_sheet.*

class PersistentBottomSheetActivity : AppCompatActivity() {

    private val mBottomSheetBehavior by lazy {
        BottomSheetBehavior.from(bottom_sheet)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persistent_bottom_sheet)

        button_expand.setOnClickListener {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
        }
        button_collapse.setOnClickListener {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
        }

        mBottomSheetBehavior.setBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        text_view_state.text = "Collapsed"
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        text_view_state.text = "Dragging..."
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        text_view_state.text = "Expanded"
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        text_view_state.text = "Hidden"
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                        text_view_state.text = "Settling..."
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                text_view_state.text = "Sliding..."
            }
        })
    }


}