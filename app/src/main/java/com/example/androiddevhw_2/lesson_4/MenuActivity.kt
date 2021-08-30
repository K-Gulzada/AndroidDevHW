package com.example.androiddevhw_2.lesson_4

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.example.androiddevhw_2.R
import java.text.SimpleDateFormat
import java.util.*

class MenuActivity : AppCompatActivity() {

    private lateinit var notificationBuilder: NotificationBuilder
    val calendar = Calendar.getInstance()

    val dateListener: DatePickerDialog.OnDateSetListener =
            DatePickerDialog.OnDateSetListener { datePicker, year: Int, month: Int, dayOfMonth: Int ->
                println("ACADEMY: year=$year month=$month day=$dayOfMonth")
            }

    val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour: Int, minute: Int ->
        println("ACADEMY: hour=$hour minute=$minute")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuSetting -> {
                showMessage("setting")
                true
            }
            R.id.menu_profile -> {
                DatePickerDialog(
                        this,
                        dateListener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
                //showMessage("Profile")
                true
            }
            R.id.menu_time_picker -> {
                TimePickerDialog(
                        this,
                        timeSetListener,
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        true
                ).show()

                true
            }
            R.id.menu_file_create -> {
                notificationBuilder.showNotification("Create", "Something")
                true
            }

            R.id.menu_file_open -> {
                val dialog = CustomDialog(this)
                dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                dialog.show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }


    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
