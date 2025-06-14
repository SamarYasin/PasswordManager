package com.example.view.screen.signin.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.component.AppHelperText
import com.example.component.AppScreenTitleText
import com.example.component.AppViewNameText
import com.example.component.BaseScreen
import com.example.component.EmailTextField
import com.example.component.FullWidthButton
import com.example.component.PasswordTextField
import com.example.style.primaryColor
import com.example.view.SignInResult
import com.example.view.SignInValidationResult
import com.example.view.dialog.AlertDialogMessage
import com.example.view.screen.signin.model.SignInScreenModel
import com.example.view.screen.signin.viewmodel.SignInViewModel
import kotlin.coroutines.EmptyCoroutineContext

@Composable
fun RouteSignInScreen(
    modifier: Modifier = Modifier,
    signInViewModel: SignInViewModel = hiltViewModel(),
    onSignInResult: () -> Unit = {},
    onNavigateToSignUp: () -> Unit = {},
    onForgotPassword: () -> Unit = {}
) {

    val validationResult by signInViewModel.validationResult.collectAsState(
        initial = SignInValidationResult.Idle,
        context = EmptyCoroutineContext
    )

    val signInResult by signInViewModel.signInResult.collectAsState(
        initial = SignInResult.Idle,
        context = EmptyCoroutineContext
    )

    SignInScreen(
        modifier = modifier,
        onNavigateToSignUp = onNavigateToSignUp,
        onForgotPassword = onForgotPassword,
        onNextBtnClick = { signInScreenModel: SignInScreenModel ->
            Log.d("SignInScreen", "onNextBtnClick: model: $signInScreenModel")
            signInViewModel.validateSignInForm(
                signInScreenModel
            )
        }
    )

    when (validationResult) {
        is SignInValidationResult.Idle -> {
            // Do nothing on idle state
        }

        is SignInValidationResult.Loading -> {
            // Show loading state if needed
        }

        is SignInValidationResult.Error -> {
            AlertDialogMessage(
                modifier = Modifier
                    .wrapContentSize(),
                onDismissRequest = {
                    Log.d("SignInScreen", "Validation error dismissed")
                    signInViewModel.clearValidationError()
                },
                onConfirmation = {
                    Log.d("SignInScreen", "Validation error confirmed")
                    signInViewModel.clearValidationError()
                },
                dialogTitle = "Error",
                dialogText = "An error occurred"
            )
        }

        is SignInValidationResult.Success -> {
            // Handle success state
            Log.d("SignInScreen", "Validation successful, proceeding to sign in")
            signInViewModel.signIn()
        }
    }

    when (signInResult) {
        is SignInResult.Idle -> {
            // Do nothing on idle state
        }

        is SignInResult.Loading -> {
            // Show loading state if needed
        }

        is SignInResult.Error -> {
            AlertDialogMessage(
                modifier = Modifier
                    .wrapContentSize(),
                onDismissRequest = {
                    Log.d("SignInScreen", "Sign in error dismissed")
                    signInViewModel.clearSignInError()
                },
                onConfirmation = {
                    Log.d("SignInScreen", "Sign in error confirmed")
                    signInViewModel.clearSignInError()
                },
                dialogTitle = "Error",
                dialogText = "An error occurred"
            )
        }

        is SignInResult.Success -> {
            Log.d("SignInScreen", "Sign in successful, navigating to next screen")
            // Handle success state
            onSignInResult.invoke()
        }
    }

}

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    onNavigateToSignUp: () -> Unit = {},
    onNextBtnClick: (SignInScreenModel) -> Unit = {},
    onForgotPassword: () -> Unit = {}
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    BaseScreen(modifier = modifier
        .fillMaxSize()
        .background(color = primaryColor)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.1F)
            )

            AppScreenTitleText(
                text = "Sign In",
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
            )

            AppViewNameText(
                text = "Lets get you signed in",
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
            )

            AppViewNameText(
                text = "Email",
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 12.dp)
                    .align(Alignment.Start)
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )

            EmailTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp),
                onValueChange = {
                    email = it
                }
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(12.dp)
            )

            AppViewNameText(
                text = "Password",
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 12.dp)
                    .align(Alignment.Start)
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )

            PasswordTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp),
                onValueChange = {
                    password = it
                }
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(12.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    modifier = Modifier
                        .wrapContentSize()
                ) {

                    AppHelperText(
                        text = "Dont have an account?",
                        modifier = Modifier
                            .wrapContentSize()
                    )

                    AppHelperText(
                        text = "  Sign Up",
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                onNavigateToSignUp.invoke()
                            }
                    )

                }

                AppHelperText(
                    text = "Forgot Password?",
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            onForgotPassword.invoke()
                        }
                )

            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.1F)
            )

            FullWidthButton(
                modifier = Modifier,
                text = "Sign In",
                onClick = {
                    onNextBtnClick.invoke(
                        SignInScreenModel(
                            email = email,
                            password = password
                        )
                    )
                    Log.d("SignInScreen", "Next button clicked with email: $email and password: $password")
                    email = ""
                    password = ""
                }
            )

        }
    }
}

@Preview(showBackground = true, showSystemUi = true, apiLevel = 34)
@Composable
fun PreviewSignInScreen(modifier: Modifier = Modifier) {
    SignInScreen(
        modifier = modifier
            .fillMaxSize(),
        onNavigateToSignUp = {
            // Handle navigation to sign up
        },
        onForgotPassword = {
            // Handle forgot password
        },
        onNextBtnClick = {
            // Handle next button click
        }
    )
}