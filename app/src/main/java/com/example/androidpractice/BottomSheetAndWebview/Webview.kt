package com.example.androidpractice.BottomSheetAndWebview

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractice.databinding.ActivityWebviewBinding

class Webview : AppCompatActivity() {
    lateinit var binding:ActivityWebviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    binding= ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.webView.apply {
            loadUrl("https://github.com/BilkisProject2")
//            settings.javaScriptEnabled=true
//            // help to page finish and overloading
//            webViewClient= WebViewClient()
//            settings.setSupportZoom(true)
        }
    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//        if (binding.webView.canGoBack()){
//           binding.webView.goBack()
//       }else{
//           finish()
//        }
//    }
}