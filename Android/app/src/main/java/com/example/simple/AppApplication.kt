package com.example.simple

import android.app.Application
import com.example.simple.beagle.BeagleSetup

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        BeagleSetup().init(this)
    }
}