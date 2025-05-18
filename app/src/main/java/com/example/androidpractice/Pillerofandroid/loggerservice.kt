package com.example.androidpractice.Pillerofandroid

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.androidpractice.MainActivity
import com.example.androidpractice.R
import kotlin.concurrent.thread

class loggerservice:Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    //1
    // this call one time only
    override fun onCreate() {
        Log.d("TAG", "onCreate: ")
        super.onCreate()

    }

    override fun onDestroy() {
        Log.d("TAG", "onDestroy: ")
        super.onDestroy()
    }

    //2 this multile time
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("TAG", "onStartCommand: ")
        thread(start = true){
            Log.d("TAG", "onStartCommand:2 ")
            Thread.sleep(1000)
        }
        startloggerforgrounservoce()
        return super.onStartCommand(intent, flags, startId)
    }

    fun startloggerforgrounservoce(){
        cretaenotificationchannel()
        val n= createnotification()
        startForeground(111,n)
    }

    fun createnotification():Notification{
        val notification = NotificationCompat.Builder(this,"ID")
            .setContentText("FORGROUNDSERVICE")
            .setContentTitle("BILKIS")
            .setContentIntent(getpentedndingintet())
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setOngoing(true)
            .build()
        return  notification
    }

    fun getpentedndingintet():PendingIntent{
        val intent = Intent(this, com.example.androidpractice.Pillerofandroid.Service::class.java)
        return PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_IMMUTABLE)
    }

    fun cretaenotificationchannel():NotificationChannel{
        val channel = NotificationChannel("ID","BILKIS",NotificationManager.IMPORTANCE_DEFAULT)
        val notificationMnager= ContextCompat.getSystemService(this,NotificationManager::class.java)
        notificationMnager!!.createNotificationChannel(channel)
        return channel
    }
}