package com.example.androiddevhw_2.lesson_4

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.widget.AppCompatButton
import com.example.androiddevhw_2.R

class CustomDialog(context: Context): Dialog(context), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.custom_dialog)
    }

     override fun onClick(v: View) {

         when(v.id) {
             R.id.dialog_confirm_button -> dismiss()
             else -> {

             }
         }
         dismiss()
     }
}