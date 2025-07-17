package com.example.passwordmanager.navigation

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.view.screen.addEntry.view.RouteAddEntryScreen
import com.example.view.screen.editEntry.view.RouteEditEntryScreen
import com.example.view.screen.forgetPassword.view.RouteForgotPasswordScreen
import com.example.view.screen.home.view.RouteHomeScreen
import com.example.view.screen.setting.view.RouteSettingScreen
import com.example.view.screen.signin.view.RouteSignInScreen
import com.example.view.screen.signup.view.RouteSignUpScreen

@Composable
fun PasswordManagerNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.SIGN_IN.route) {
        composable(Routes.SIGN_UP.route) {
            RouteSignUpScreen(
                onSignUpResult = {
                    Log.d(TAG, "PasswordManagerNavigation: Navigating to Sign In Screen")
                    navController.navigate(Routes.SIGN_IN.route)
                },
                onNavigateToSignIn = {
                    Log.d(TAG, "PasswordManagerNavigation: Navigating to Sign In Screen")
                    navController.navigate(Routes.SIGN_IN.route)
                }
            )
        }
        composable(Routes.SIGN_IN.route) {
            RouteSignInScreen(
                onSignInResult = {
                    Log.d(TAG, "PasswordManagerNavigation: Navigating to Home Screen")
                    navController.navigate(Routes.HOME.route)
                },
                onNavigateToSignUp = {
                    Log.d(TAG, "PasswordManagerNavigation: Navigating to Sign Up Screen")
                    navController.navigate(Routes.SIGN_UP.route)
                },
                onForgotPassword = {
                    Log.d(TAG, "PasswordManagerNavigation: Navigating to Forgot Password Screen")
                    navController.navigate(Routes.FORGOT_PASSWORD.route)
                }
            )
        }
        composable(Routes.FORGOT_PASSWORD.route) {
            RouteForgotPasswordScreen(
                onNavigateToSignIn = {
                    Log.d(TAG, "PasswordManagerNavigation: Navigating to Sign In Screen")
                    navController.navigate(Routes.SIGN_IN.route)
                }
            )
        }
        composable(Routes.HOME.route) {
            RouteHomeScreen(
                onEditEntry = {
                    Log.d(TAG, "PasswordManagerNavigation: Navigating to Edit Entry Screen")
                    navController.navigate(Routes.EDIT_ENTRY.route)
                },
                onAddEntry = {
                    Log.d(TAG, "PasswordManagerNavigation: Navigating to Add Entry Screen")
                    navController.navigate(Routes.ADD_ENTRY.route)
                },
                onLogout = {
                    Log.d(TAG, "PasswordManagerNavigation: Navigating to Sign In Screen")
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
                onMoveNext = {
                    Log.d(TAG, "PasswordManagerNavigation: Navigating back to Home Screen")
                    navController.popBackStack()
                }
            )
        }
        composable(Routes.EDIT_ENTRY.route) {
            RouteEditEntryScreen(
                onMoveNext = {
                    Log.d(TAG, "PasswordManagerNavigation: Navigating back to Home Screen")
                    navController.popBackStack()
                }
            )
        }
        composable(Routes.SETTINGS.route) {
            RouteSettingScreen(

            )
        }
    }
}