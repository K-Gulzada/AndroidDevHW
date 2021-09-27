package com.example.androiddevhw_2.hw_8_coroutine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiddevhw_2.databinding.ActivityCoroutineBinding
import com.example.androiddevhw_2.hw_7_rx.RecyclerAdapter
import com.example.androiddevhw_2.hw_7_rx.model.User
import com.example.androiddevhw_2.hw_8_coroutine.retrofit.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import java.sql.DriverManager.println
import java.util.*
import kotlinx.coroutines.flow.collect


class CoroutineActivity : AppCompatActivity() {
    private lateinit var job: Job
    private val adapter: RecyclerAdapter = RecyclerAdapter()

    private lateinit var binding: ActivityCoroutineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineBinding.inflate(layoutInflater)
        binding.userRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.userRecyclerView.adapter = adapter
        setContentView(binding.root)

        binding.createUser.setOnClickListener{
            val intent = Intent(this, CoroutineRegisterActivity::class.java)
            startActivity(intent)
        }

        loadUsers()

    }

    // Flow<Users>

     private fun loadUsers() {
         val client = RetrofitClient()

         job = CoroutineScope(Dispatchers.Main).launch {
             try {
                 client.getUsers()
                     .onStart {
                         binding.progressBar.visibility = View.VISIBLE
                     }
                     .catch { exception ->
                         Toast.makeText(
                             this@CoroutineActivity,
                             exception.message,
                             Toast.LENGTH_SHORT
                         ).show()
                     }
                     .onCompletion { binding.progressBar.visibility = View.GONE }
                     .collect {
                         println("#ACADEMY STEP 1 ${Looper.myLooper() == Looper.getMainLooper()}")
                         adapter.setData(it.data)
                     }

             } catch (e: Exception) {
                 e.printStackTrace()
             }
         }
     }
}