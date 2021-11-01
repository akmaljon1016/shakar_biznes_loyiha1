package com.example.shakar_biznes_loyiha

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.shakar_biznes_loyiha.databinding.ActivityHomeBinding
import com.example.shakar_biznes_loyiha.utils.Constans
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private var isPressed: Boolean = false
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding
    lateinit var sharedPreferences: SharedPreferences
    var nameOfUser = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE)
        nameOfUser = sharedPreferences.getString("nameOfUser", "null").toString()
        Toast.makeText(this, Constans.token, Toast.LENGTH_SHORT).show()
        setSupportActionBar(binding.appBarHome.toolbar)
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val header = navView.getHeaderView(0)
        val txtNameOfUser = header.findViewById<TextView>(R.id.nameOfUser)
        txtNameOfUser.text=nameOfUser.toString()
        navView.itemIconTintList = null
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_bosh_sahifa,
                R.id.nav_kunlik_hisobotlar,
                R.id.nav_klientlar,
                R.id.nav_kassa,
                R.id.nav_sklad,
                R.id.nav_olingan_yuklar,
                R.id.nav_sotilgan_yuklar,
                R.id.nav_dollor_kursi,
                R.id.nav_foydalanuvchilar
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (isPressed) {
            val intent = Intent().apply {
                action = Intent.ACTION_MAIN
                addCategory(Intent.CATEGORY_HOME)
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            try {
                startActivity(intent)
            } catch (e: Exception) {
            }
        } else {
            Toast.makeText(this, "Please click back again to exit", Toast.LENGTH_SHORT).show()
            isPressed = true
        }
        Handler().postDelayed(object : Runnable {
            override fun run() {
                isPressed = false
            }
        }, 2000)
    }
}