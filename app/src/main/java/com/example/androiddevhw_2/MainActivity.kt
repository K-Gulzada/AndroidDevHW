package com.example.androiddevhw_2

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.io.File


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        redirectToPdfViewActivity()
    }

    fun redirectToPdfViewActivity() {
        val btn = findViewById<Button>(R.id.redirectToPdfView)
        btn.setOnClickListener {
            val intent = Intent(this, PdfViewActivity::class.java)
            startActivity(intent)
        }

        val btn2 = findViewById<Button>(R.id.redirectToRegistrationView)

        btn2.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        val btn3 = findViewById<Button>(R.id.to_recycler_view)

        btn3.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }


    }


}

/*
1. Создать репозиторий в GitHub и залить ваш проект
2 создать ветку в котором реализовать RecyclerView и ViewBinding
3. Создать pull request с этой ветки в мастер

Я создам домашнее задание, вам нужно будет в нем отправить мне ссылку на пулл реквест*/
