package com.example.androidpractice

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.normalalertdilogeshow.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Message Show")
                setMessage("Message show for practices")
                setPositiveButton("YES"){
                        _,_->
                    Toast.makeText(this@MainActivity,"OK GOOD BRO:-)",Toast.LENGTH_LONG).show()
                }
                setNegativeButton("NO"){
                        _,_->
                    Toast.makeText(this@MainActivity,"CANCEL HI CACEL HAI ",Toast.LENGTH_LONG).show()
                }
                show()
            }
        }





    }
}