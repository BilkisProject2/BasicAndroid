package com.example.androidpractice.RecModuleofcurd

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivityDetailedBinding

class detailed : AppCompatActivity() {
    lateinit var binding: ActivityDetailedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailedBinding.inflate(layoutInflater)
//        enableEdgeToEdge()
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val bundle:Bundle?=intent.extras
        val n = bundle!!.getString("name")
        val s = bundle!!.getString("surname")
        val i = bundle!!.getInt("img")
        binding.namedata.text=n
        binding.surnamedata.text=s
        binding.imageView.setImageResource(i)
    }
}