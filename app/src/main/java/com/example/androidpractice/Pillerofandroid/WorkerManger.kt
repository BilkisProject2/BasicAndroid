package com.example.androidpractice.Pillerofandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.work.BackoffPolicy
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.androidpractice.R
import java.util.concurrent.TimeUnit

class WorkerManger : AppCompatActivity() {

    private val workmanger= WorkManager.getInstance(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker_manger2)
    dowork()
    }

    private fun dowork() {
        val equets = OneTimeWorkRequest.Builder(workerclass::class.java)
//        val equets = PeriodicWorkRequest.Builder(workerclass::class.java,15,TimeUnit.MINUTES)
            .setConstraints(Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())
            .setBackoffCriteria(    BackoffPolicy.LINEAR,10,TimeUnit.SECONDS)
            .build()
        workmanger.enqueue(equets)
        workmanger.beginWith(equets).then(equets).enqueue()
        workmanger.getWorkInfoByIdLiveData(equets.id).observe(this){
            if (it!=null){
                printStatus(it.state.name)
            }
        }
    }

    private fun printStatus(name: String) {
        Log.d("TAG",  name)
    }
}