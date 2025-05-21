package com.example.passwordmanager

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/*
 * Custom Application class for initializing libraries and configurations.
 *
 * This class is used to set up Timber for logging in debug mode.
 */

@HiltAndroidApp
class PasswordManagerApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            // Initialize Timber only in debug mode
            if (Timber.treeCount == 0) {
                Timber.plant(Timber.DebugTree())
            }
        } else {
            // Release mode, you can plant a tree for production logging if needed
            // Timber.plant(ReleaseTree())
        }
    }
}