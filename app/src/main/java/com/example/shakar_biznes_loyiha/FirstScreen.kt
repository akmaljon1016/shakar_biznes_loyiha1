package com.example.shakar_biznes_loyiha

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.shakar_biznes_loyiha.utils.UserPreferences
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FirstScreen : AppCompatActivity(R.layout.activity_main) {
    var isUserLogged: Boolean = true

    private val userPreferences by lazy { UserPreferences(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        userPreferences.isUserLOgged.asLiveData().observe(
//            this,
//            Observer {
//                if (it == null || it == false) {
//                    isUserLogged = false
//                }
//                if (it == true) {
//                    isUserLogged = true
//                }
//            },
//        )

        CoroutineScope(Dispatchers.Main).launch {
            val animation =
                AnimationUtils.loadAnimation(applicationContext, R.anim.splash_animation)
            splashTextView.startAnimation(animation)
            delay(0)
            if (isUserLogged) {
                startActivity(Intent(this@FirstScreen, HomeActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this@FirstScreen, LoginActivity::class.java))
                finish()
            }
        }
    }
}