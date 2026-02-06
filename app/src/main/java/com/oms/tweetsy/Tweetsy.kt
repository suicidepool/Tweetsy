package com.oms.tweetsy

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Tweetsy : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}