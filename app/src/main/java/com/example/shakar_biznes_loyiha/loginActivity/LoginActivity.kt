package com.example.shakar_biznes_loyiha.loginActivity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.shakar_biznes_loyiha.FirstScreen
import com.example.shakar_biznes_loyiha.HomeActivity
import com.example.shakar_biznes_loyiha.databinding.ActivityLoginBinding
import com.example.shakar_biznes_loyiha.data.network.NetworkApi
import com.example.shakar_biznes_loyiha.data.network.RemoteDataSource
import com.example.shakar_biznes_loyiha.data.network.Resources
import com.example.shakar_biznes_loyiha.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private var isNetworkAvailable = true
    private var isPressed: Boolean = false
    private var binding: ActivityLoginBinding? = null

    val loginViewModel: LoginViewModel by viewModels()
    var sharedPreference: SharedPreferences? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        loginViewModel.loginResponse.observe(this, Observer {
            when (it) {
                is NetworkResult.Success -> {
                    it.data!!.data.let {
                        saveToken(it.token, it.firstname)
                    }
                    startActivity(Intent(this, FirstScreen::class.java))
                    finish()
                    Toast.makeText(this, "Login Success ${it.data.data.token}", Toast.LENGTH_SHORT)
                        .show()
                }
                is NetworkResult.Error -> {
                    Toast.makeText(this, "Login Failure", Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding!!.btnLogin.setOnClickListener {
            if (isNetworkAvailable) {
                binding!!.progressBar.visibility = View.VISIBLE
                val username: String = binding!!.editTextUserName.text.toString()
                val password: String = binding!!.editTextPassword.text.toString()
                loginViewModel.login(username, password)
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

    fun saveToken(token: String, nameOfUser: String) {
        sharedPreference = getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreference!!.edit()
        editor.putString("token", token)
        editor.putString("nameOfUser", nameOfUser)
        editor.apply()
    }
}