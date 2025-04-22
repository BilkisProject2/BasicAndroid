package com.example.androidpractice.ModuleofTabAndBottomAndDrwable

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.androidpractice.R
import com.google.android.material.navigation.NavigationView

class navigatiodrawableexaml : AppCompatActivity() {
    lateinit var toggle:ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigatiodrawableexaml)
       val drwablayout:DrawerLayout = findViewById(R.id.main)
        val navview :NavigationView= findViewById(R.id.nav)



        toggle= ActionBarDrawerToggle(this,drwablayout,R.string.open, R.string.close)
        drwablayout.addDrawerListener(toggle)
        toggle.syncState()
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navview.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.firsts -> Toast.makeText(applicationContext,"G1",Toast.LENGTH_LONG).show()
                R.id.seconds -> Toast.makeText(applicationContext,"G2",Toast.LENGTH_LONG).show()
                R.id.thirds -> Toast.makeText(applicationContext,"G3",Toast.LENGTH_LONG).show()
                else -> {Toast.makeText(applicationContext,"h4",Toast.LENGTH_LONG).show()}
            }
            true
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}