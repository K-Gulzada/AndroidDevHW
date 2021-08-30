package com.example.androiddevhw_2.lessons_1_2_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.androiddevhw_2.R

class RegisterActivity : AppCompatActivity() {

    val cities = arrayOf<String>("Almaty","Astana","Shymkent","Taraz", "Semey", "Kostanay", "Aktobe")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        verifyValidRegister()
        setViews()
    }

    fun verifyValidRegister(){
        val loginText = findViewById<EditText>(R.id.login_text)
        val passwordText = findViewById<EditText>(R.id.password_text)
        val confirmPasswordText = findViewById<EditText>(R.id.confirm_password_text)

        val btn = findViewById<Button>(R.id.register_btn)
        btn.setOnClickListener {
            if (loginText.text.toString().isEmpty()) {
                ShowMessage("Login can be empty")
            }

            if (passwordText.length()<6 || passwordText.length()>15) {
                ShowMessage("Password Lenth should be more than 6 and less than 15")
            }

            if(passwordText!=confirmPasswordText){
                ShowMessage("Password and confirmPassword don't match")
            }
        }

    }

    fun setViews(){
        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.city_choose_autocomplete)
        val adapter = ArrayAdapter<String> (this,
            R.layout.support_simple_spinner_dropdown_item, cities)
        autoCompleteTextView.setAdapter(adapter)

        val multiAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.city_choose_multiautocomplete)
        multiAutoCompleteTextView.setAdapter(adapter)
        multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

        /* val citiesArray = resources.getStringArray(R.array.spinner)*/
        val spinner = findViewById<Spinner>(R.id.city_choose_spinner)
        val spinnerAdapter = ArrayAdapter(this,
            R.layout.support_simple_spinner_dropdown_item, cities)
        spinner.adapter = spinnerAdapter
    }

    private fun ShowMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}