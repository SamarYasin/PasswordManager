package com.example.passwordmanager

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PasswordManagerApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize any global resources or configurations here if needed
        Log.d(TAG, "onCreate: App Started")
    }
}