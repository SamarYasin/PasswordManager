package com.example.passwordmanager

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.passwordmanager.navigation.PasswordManagerNavigation
import com.example.style.PasswordManagerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the activity to be secure, preventing screenshots and screen sharing
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )

        setContent {
            PasswordManagerTheme {
                val navController = rememberNavController()
                PasswordManagerNavigation(navController)
            }
        }

    }
}