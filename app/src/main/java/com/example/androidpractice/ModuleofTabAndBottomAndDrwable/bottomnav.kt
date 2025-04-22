package com.example.androidpractice.ModuleofTabAndBottomAndDrwable

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.androidpractice.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class bottomnav : AppCompatActivity() {
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottomnav)
        var f = supportFragmentManager.findFragmentById(R.id.fragment) as NavHost
        navController=f.navController
        var b =findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        setupWithNavController(b,navController)
    }
}