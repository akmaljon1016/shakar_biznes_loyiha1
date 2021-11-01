package com.example.shakar_biznes_loyiha

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.lifecycleScope
import com.example.shakar_biznes_loyiha.loginActivity.LoginActivity
import com.example.shakar_biznes_loyiha.utils.Constans
import com.example.shakar_biznes_loyiha.utils.NetworkListener
import com.example.shakar_biznes_loyiha.utils.UserPreferences
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FirstScreen : AppCompatActivity(R.layout.activity_main) {

    lateinit var sharedPreferences: SharedPreferences
    var token: String = ""
    private lateinit var networkListener: NetworkListener

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE)
        token = sharedPreferences.getString("token", "null").toString()
        Constans.token = token

//        lifecycleScope.launch {
//            networkListener = NetworkListener()
//            networkListener.checkNetworkAvailability(this@FirstScreen)
//                .collect {
//                    if (it){
//                        if (token != "null") {
//                            startActivity(Intent(this@FirstScreen, HomeActivity::class.java))
//                            finish()
//                        } else {
//                            startActivity(Intent(this@FirstScreen, LoginActivity::class.java))
//                            finish()
//                        }
//                    }
//                    else{
//                        Toast.makeText(this@FirstScreen, "No Internet Connection", Toast.LENGTH_SHORT).show()
//                    }
//                }
//        }

            if (token != "null") {
                startActivity(Intent(this@FirstScreen, HomeActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this@FirstScreen, LoginActivity::class.java))
                finish()
            }

//
//        CoroutineScope(Dispatchers.Main).launch {
//            val animation =
//                AnimationUtils.loadAnimation(applicationContext, R.anim.splash_animation)
//            splashTextView.startAnimation(animation)
//            delay(2000)
//            if (isUserLogged) {
//                startActivity(Intent(this@FirstScreen, HomeActivity::class.java))
//                finish()
//            } else {
//                startActivity(Intent(this@FirstScreen, LoginActivity::class.java))
//                finish()
//            }
//        }
    }
}