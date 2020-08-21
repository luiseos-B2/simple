package com.example.simple.presentation.activity

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.beagle.android.view.BeagleActivity
import br.com.zup.beagle.android.view.ScreenRequest
import com.example.simple.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timeSplash()
    }

    private fun timeSplash(){
        Handler().postDelayed({
            startActivity(BeagleActivity.newIntent(this, ScreenRequest("/onboarding")))
        }, 1000)
    }
}