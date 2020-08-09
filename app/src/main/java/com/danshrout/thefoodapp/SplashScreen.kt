package com.danshrout.thefoodapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity
=======
import android.support.v7.app.AppCompatActivity
>>>>>>> 37bab9ec2ab18d3511da658a32eab85a8692b364

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            val i = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(i)

            finish()
        }, 3000)
    }
}
