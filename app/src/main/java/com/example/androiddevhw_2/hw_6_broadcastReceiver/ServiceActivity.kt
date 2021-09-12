package com.example.androiddevhw_2.hw_6_broadcastReceiver

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddevhw_2.R


class ServiceActivity : AppCompatActivity() {
    private val receiver = TestBroadcastReceiver()
    private val handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        findViewById<View>(R.id.intent_btn).setOnClickListener {
            startHandler()
        }

        findViewById<View>(R.id.stop_service).setOnClickListener {
            stopHandler()
        }
    }

    private fun startHandler() {
        val delay = 5000L
        handler.postDelayed(object : Runnable {
            override fun run() {
                val alarmIntent = Intent(applicationContext, TestBroadcastReceiver::class.java)
                sendBroadcast(alarmIntent)
                handler.postDelayed(this, delay)
            }
        }, delay)
    }

    private fun stopHandler() {
        handler.removeMessages(0)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}
