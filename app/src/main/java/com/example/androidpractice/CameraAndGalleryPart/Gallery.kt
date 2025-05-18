package com.example.androidpractice.CameraAndGalleryPart

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivityGalleryBinding

class Gallery : AppCompatActivity() {
    lateinit var binding:ActivityGalleryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val resultcontract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode==Activity.RESULT_OK){
                val bitmap = it.data?.extras?.get("data") as Bitmap
                binding.imageView11.setImageBitmap(bitmap)
            }



        }
        val loadimage = registerForActivityResult(ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                binding.imageView11.setImageURI(it)
            })
        binding.Gallerybtn.setOnClickListener (View.OnClickListener {
            loadimage.launch("image/*")
        })
        binding.button7.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            resultcontract.launch(intent)
        }
    }
}