package com.example.passwordmanager.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.passwordmanager.navigation.PasswordManagerNavigation
import com.example.passwordmanager.theme.PasswordManagerTheme
import com.example.passwordmanager.viewModel.PasswordManagerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: PasswordManagerViewModel by viewModels()

        enableEdgeToEdge()
        setContent {
            PasswordManagerTheme {
                val navController = rememberNavController()
                PasswordManagerNavigation(navController, viewModel)
            }
        }

    }
}