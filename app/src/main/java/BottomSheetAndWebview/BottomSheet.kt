package BottomSheetAndWebview

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivityBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheet : AppCompatActivity() {
    lateinit var binding:ActivityBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBottomSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.BottomSheet.setOnClickListener {
            var b = BottomSheetDialog(this)
            var v = layoutInflater.inflate(R.layout.bottomsheet, null)
            b.setContentView(v)
            b.show()
        }

    }
}