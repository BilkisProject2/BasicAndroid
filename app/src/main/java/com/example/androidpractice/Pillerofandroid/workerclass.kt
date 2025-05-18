package com.example.androidpractice.Pillerofandroid

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters


class workerclass(context:Context,params:WorkerParameters): Worker(context,params) {
    override fun doWork(): Result {
        Thread.sleep(2000)
        Log.d("TAG", "doWork: TASK COMPLETED")
        return Result.success()
    }
}