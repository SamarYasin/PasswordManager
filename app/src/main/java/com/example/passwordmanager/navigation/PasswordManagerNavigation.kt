package com.example.passwordmanager.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.view.screen.addEntry.view.RouteAddEntryScreen
import com.example.view.screen.editEntry.view.RouteEditEntryScreen
import com.example.view.screen.forgetPassword.view.RouteForgotPasswordScreen
import com.example.view.screen.home.view.RouteHomeScreen
import com.example.view.screen.signin.view.RouteSignInScreen
import com.example.view.screen.signup.view.RouteSignUpScreen

@Composable
fun PasswordManagerNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.SIGN_IN.route) {
        composable(Routes.SIGN_UP.route) {
            RouteSignUpScreen(
                onSignUpResult = {
                    navController.navigate(Routes.SIGN_IN.route)
                },
                onNavigateToSignIn = {
                    navController.navigate(Routes.SIGN_IN.route)
                }
            )
        }
        composable(Routes.SIGN_IN.route) {
            RouteSignInScreen(
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
                    navController.navigate(Routes.EDIT_ENTRY.route)
                },
                onAddEntry = {
                    navController.navigate(Routes.ADD_ENTRY.route)
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
                onMoveNext = {
                    navController.popBackStack()
                }
            )
        }
        composable(Routes.EDIT_ENTRY.route) {
            RouteEditEntryScreen(
                onMoveNext = {
                    navController.popBackStack()
                }
            )
        }
    }
}