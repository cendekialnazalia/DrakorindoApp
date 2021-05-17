package com.cendekia.drakorindoapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.cendekia.drakorindoapp.R

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var appName: ImageView
    private lateinit var splashImg: ImageView
    private lateinit var tagLine: ImageView
    private lateinit var lottieAnimationView: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 5300)

        appName = findViewById(R.id.app_name)
        splashImg = findViewById(R.id.img)
        tagLine = findViewById(R.id.app_tagline)
        lottieAnimationView = findViewById(R.id.lottie)

        splashImg.animate().translationY((-3000).toFloat()).setDuration(1000).setStartDelay(4000)
        appName.animate().translationY((2000).toFloat()).setDuration(1000).setStartDelay(4000)
        lottieAnimationView.animate().translationY((2000).toFloat()).setDuration(1000)
            .setStartDelay(4000)
        tagLine.animate().translationY((1700).toFloat()).setDuration(1000).setStartDelay(4000)
    }
}