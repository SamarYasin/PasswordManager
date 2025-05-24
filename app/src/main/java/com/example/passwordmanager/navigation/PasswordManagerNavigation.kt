package com.example.passwordmanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.view.addEntry.RouteAddEntryScreen
import com.example.view.forgetPassword.RouteForgotPasswordScreen
import com.example.view.home.RouteHomeScreen
import com.example.view.signin.RouteSignInScreen
import com.example.view.signup.RouteSignUpScreen

@Composable
fun PasswordManagerNavigation(navController: NavHostController) {
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
        composable(Routes.ADD_ENTRY.route) {
            RouteAddEntryScreen(
                onAddEntry = {
                    // Handle add entry action
                }
            )
        }
    }
}