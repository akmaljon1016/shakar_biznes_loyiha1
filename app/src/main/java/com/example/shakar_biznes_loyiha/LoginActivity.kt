package com.example.shakar_biznes_loyiha

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.shakar_biznes_loyiha.databinding.ActivityLoginBinding
import com.example.shakar_biznes_loyiha.utils.NetworkListener
import com.example.shakar_biznes_loyiha.utils.UserPreferences
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private var isNetworkAvailable = false
    private var isPressed: Boolean = false
    private var _binding: ActivityLoginBinding? = null
    private val networkListener by lazy { NetworkListener() }
    private val binding get() = _binding
    val userPreferences by lazy { UserPreferences(this) }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)

        binding!!.btnLogin.setOnClickListener {
            if (isNetworkAvailable) {

                lifecycleScope.launch {
                    userPreferences.saveIsUserLoggedOrNot(true)
                }
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Network not available", Toast.LENGTH_SHORT).show()
            }
        }
        setContentView(binding?.root)
        lifecycleScope.launch {
           // checkNetwork()
        }
    }

//    @RequiresApi(Build.VERSION_CODES.N)
//    private suspend fun checkNetwork() {
//        networkListener.checkNetworkAvailability(applicationContext).collect {
//            isNetworkAvailable = it
//        }
//    }

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