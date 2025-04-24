package CameraAndGalleryPart

import android.os.Bundle
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

        val loadimage = registerForActivityResult(ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                binding.imageView11.setImageURI(it)
            })

        binding.Gallerybtn.setOnClickListener (View.OnClickListener {
            loadimage.launch("image/*")
        })

    }
}