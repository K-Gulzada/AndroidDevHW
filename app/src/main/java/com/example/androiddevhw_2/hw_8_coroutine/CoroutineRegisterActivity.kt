package com.example.androiddevhw_2.hw_8_coroutine

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddevhw_2.R
import com.example.androiddevhw_2.databinding.ActivityCoroutineRegisterBinding
import com.example.androiddevhw_2.hw_7_rx.RecyclerAdapter
import com.example.androiddevhw_2.hw_7_rx.model.Gender
import com.example.androiddevhw_2.hw_7_rx.model.User
import com.example.androiddevhw_2.hw_8_coroutine.retrofit.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CoroutineRegisterActivity : AppCompatActivity() {

    private lateinit var job: Job
    private val adapter: RecyclerAdapter = RecyclerAdapter()

    private lateinit var binding: ActivityCoroutineRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.userGender.adapter = ArrayAdapter
            .createFromResource(
                this@CoroutineRegisterActivity, R.array.spinner,
                android.R.layout.simple_spinner_item
            )

        binding.registerUser.setOnClickListener {

            addNewUser()
        }
    }

    private fun addNewUser() {
        val client = RetrofitClient()

        job = CoroutineScope(Dispatchers.Main).launch {
            try {
                val email = binding.email.text.toString()
                val name = binding.userName.text.toString()
                val id = binding.userId.text.toString()
                val gender = Gender.valueOf(binding.userGender.selectedItem.toString())

                val user = User(id.toInt(), name, email, gender)

                client.createUsers(user)

                val intent = Intent(this@CoroutineRegisterActivity, CoroutineActivity::class.java)
                startActivity(intent)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}