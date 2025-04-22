package com.example.androidpractice.ModuleofTabAndBottomAndDrwable

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivityTablayoutBinding
import com.google.android.material.tabs.TabLayoutMediator

class Tablayout : AppCompatActivity() {
    lateinit var binding: ActivityTablayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTablayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager2.adapter= TablayoutAdapter(this.supportFragmentManager,lifecycle)
        TabLayoutMediator(binding.tabLayout,binding.viewPager2)
        {tab,position->

            when(position){
                0->tab.text="Home"
                1-> tab.text="Music List"
                2->tab.text="Profile"
            }

        }.attach()


    }
}