package com.example.simple.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.beagle.android.view.BeagleActivity
import br.com.zup.beagle.android.view.ScreenRequest
import com.example.simple.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(BeagleActivity.newIntent(this,ScreenRequest("/onboarding")))
        finish()
    }
}