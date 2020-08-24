package com.example.simple.presentation.activity

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.beagle.android.view.BeagleActivity
import br.com.zup.beagle.android.view.ScreenRequest
import com.example.simple.R
import com.example.simple.constants.ONBOARDING_PATH

const val ONE_SECOND_MILLIS = 1000L

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timeSplash()
    }

    private fun timeSplash() {
        Handler().postDelayed({
            startActivity(BeagleActivity.newIntent(this, ScreenRequest(ONBOARDING_PATH)))
        }, ONE_SECOND_MILLIS)
    }
}