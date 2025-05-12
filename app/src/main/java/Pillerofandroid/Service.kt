package Pillerofandroid

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.Manifest
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivityServiceBinding

class Service : AppCompatActivity() {
    lateinit var binding: ActivityServiceBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),200)
        }

        binding.startservice.setOnClickListener {
            //for bg
//            startService(Intent(this,loggerservice::class.java))
            //for forground
            startForegroundService(Intent(this,loggerservice::class.java))
        }

        binding.endservice.setOnClickListener {
            //for bg and forground
            stopService(Intent(this,loggerservice::class.java))
        }

    }
}