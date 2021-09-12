package com.example.androiddevhw_2.hw_6_broadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class TestBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        StringBuilder().apply{
            append("#STEP Action: ${intent?.action}\n")
            append("#STEP Data: ${intent?.data}\n")
            append("#STEP Extras: ${intent?.extras}\n")
            toString().also { data -> println(data) }
                      .also { data-> Toast.makeText(context, data, Toast.LENGTH_SHORT).show() }
        }
    }

}