package com.example.androidpractice.Pillerofandroid

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.R

class Broadcastrecevicer : AppCompatActivity() {
    lateinit var mybroadcast : BroadcastRecevier
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_broadcastrecevicer)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }




    }

    override fun onStart() {
        super.onStart()
        val intentfilter = IntentFilter(Intent.ACTION_TIME_TICK)
        registerReceiver(mybroadcast,intentfilter)
        val intent = Intent(this, BroadcastRecevier::class.java)
        sendBroadcast(intent)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(mybroadcast)
    }
}