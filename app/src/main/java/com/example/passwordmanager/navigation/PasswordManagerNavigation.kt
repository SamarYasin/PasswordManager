package com.example.passwordmanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.passwordmanager.screens.RouteForgotPasswordScreen
import com.example.passwordmanager.screens.RouteHomeScreen
import com.example.passwordmanager.screens.RouteSignInScreen
import com.example.passwordmanager.screens.RouteSignUpScreen
import com.example.passwordmanager.viewModel.PasswordManagerViewModel

@Composable
fun PasswordManagerNavigation(navController: NavHostController, viewModel: PasswordManagerViewModel) {
    NavHost(navController = navController, startDestination = Routes.SIGN_IN.route) {
        composable(Routes.SIGN_UP.route) {
            RouteSignUpScreen (
                onSignUpResult = {
                    navController.navigate(Routes.SIGN_IN.route)
                },
                onNavigateToSignIn = {
                    navController.navigate(Routes.SIGN_IN.route)
                }
            )
        }
        composable(Routes.SIGN_IN.route) {
            RouteSignInScreen (
                onSignInResult = {
                    navController.navigate(Routes.HOME.route)
                },
                onNavigateToSignUp = {
                    navController.navigate(Routes.SIGN_UP.route)
                },
                onForgotPassword = {
                    navController.navigate(Routes.FORGOT_PASSWORD.route)
                }
            )
        }
        composable(Routes.FORGOT_PASSWORD.route) {
            RouteForgotPasswordScreen(
                onNavigateToSignIn = {
                    navController.navigate(Routes.SIGN_IN.route)
                }
            )
        }
        composable(Routes.HOME.route) {
            RouteHomeScreen(
                viewModel = viewModel,
                onEditEntry = {
                    // Handle edit entry action
                },
                onCopyPassword = {
                    // Handle copy password action
                },
                onLogout = {
                    // Handle logout action
                    navController.navigate(Routes.SIGN_IN.route) {
                        popUpTo(Routes.HOME.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}