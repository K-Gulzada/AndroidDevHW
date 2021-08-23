package com.example.androiddevhw_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.*
import com.github.barteksc.pdfviewer.PDFView
import java.io.File

class RegisterActivity : AppCompatActivity() {
    val cities = arrayOf<String>("Almaty","Astana","Shymkent","Taraz", "Semey", "Kostanay", "Aktobe")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setViews()
    }

    fun setViews(){
        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.city_choose_autocomplete)
        val adapter = ArrayAdapter<String> (this, R.layout.support_simple_spinner_dropdown_item, cities)
        autoCompleteTextView.setAdapter(adapter)

        val multiAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.city_choose_multiautocomplete)
        multiAutoCompleteTextView.setAdapter(adapter)
        multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

       /* val citiesArray = resources.getStringArray(R.array.spinner)*/
        val spinner = findViewById<Spinner>(R.id.city_choose_spinner)
        val spinnerAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cities)
        spinner.adapter = spinnerAdapter
    }
}