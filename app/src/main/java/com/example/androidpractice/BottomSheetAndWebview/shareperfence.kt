package com.example.androidpractice.BottomSheetAndWebview

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivityShareperfenceBinding

class shareperfence : AppCompatActivity() {
    lateinit var binding:ActivityShareperfenceBinding
    lateinit var sp :SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityShareperfenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp = getSharedPreferences("Datastore",Context.MODE_PRIVATE)
        binding.button4.setOnClickListener {
            val editext = binding.editTextText5.text.toString()
            sp.edit().apply{
                putString("note",editext)
                apply()
            }

            Toast.makeText(this,"data add",Toast.LENGTH_LONG).show()
            binding.editTextText5.text.clear()
        }


        binding.button5.setOnClickListener {
            val storenote = sp.getString("note","")
            binding.textView6.text= "$storenote"
        }

    }
}