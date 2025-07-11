package com.example.view.screen.forgetPassword.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import com.example.component.AppScreenTitleText
import com.example.component.AppViewNameText
import com.example.component.BaseScreen
import com.example.component.EmailTextField
import com.example.component.FullWidthButton
import com.example.component.PhoneNumberTextField
import com.example.style.primaryColor
import com.example.view.ForgetPasswordResult
import com.example.view.ForgetPasswordValidationResult
import com.example.view.dialog.AlertDialogMessage
import com.example.view.screen.forgetPassword.model.ForgotPasswordScreenModel
import com.example.view.screen.forgetPassword.viewmodel.ForgetPasswordViewModel
import kotlin.coroutines.EmptyCoroutineContext

@Composable
fun RouteForgotPasswordScreen(
    modifier: Modifier = Modifier,
    forgetPasswordViewModel: ForgetPasswordViewModel = hiltViewModel(),
    onNavigateToSignIn: () -> Unit = {}
) {

    val validationResult by forgetPasswordViewModel.validationResult.collectAsState(
        initial = ForgetPasswordValidationResult.Idle,
        context = EmptyCoroutineContext
    )

    val forgotPasswordResult by forgetPasswordViewModel.forgotPasswordResult.collectAsState(
        initial = ForgetPasswordResult.Idle,
        context = EmptyCoroutineContext
    )

    ForgotPasswordScreen(
        modifier = modifier,
        onNextBtnClick = { forgotPasswordScreenModel: ForgotPasswordScreenModel ->
            Log.d("ForgotPasswordScreen", "onNextBtnClick: model: $forgotPasswordScreenModel")
            forgetPasswordViewModel.validateForgetPasswordForm(
                forgotPasswordScreenModel
            )
        }
    )

    when (validationResult) {
        is ForgetPasswordValidationResult.Idle -> {
            // Do nothing on idle state
        }

        is ForgetPasswordValidationResult.Error -> {
            AlertDialogMessage(
                modifier = modifier
                    .wrapContentSize(),
                onDismissRequest = {
                    Log.d("ForgotPasswordScreen", "onDismissRequest: clearing validation error")
                },
                onConfirmation = {
                    Log.d("ForgotPasswordScreen", "onConfirmation: clearing validation error")
                },
                dialogTitle = "Error",
                dialogText = (validationResult as ForgetPasswordValidationResult.Error).message
            )
        }

        is ForgetPasswordValidationResult.Success -> {
            Log.d("ForgotPasswordScreen", "Validation successful, proceeding to reset password")
            forgetPasswordViewModel.resetPassword()
        }

        is ForgetPasswordValidationResult.Loading -> {

        }
    }

    when (forgotPasswordResult) {
        is ForgetPasswordResult.Idle -> {
            // Do nothing on idle state
        }

        is ForgetPasswordResult.Error -> {
            AlertDialogMessage(
                modifier = modifier
                    .wrapContentSize(),
                onDismissRequest = {
                    Log.d("ForgotPasswordScreen", "onDismissRequest: clearing forgot password error")
                },
                onConfirmation = {
                    Log.d("ForgotPasswordScreen", "onConfirmation: clearing forgot password error")
                },
                dialogTitle = "Error",
                dialogText = (forgotPasswordResult as ForgetPasswordResult.Error).message
            )
        }

        is ForgetPasswordResult.Success -> {
            Log.d("ForgotPasswordScreen", "Password reset successful, navigating to sign in")
            onNavigateToSignIn.invoke()
        }

        is ForgetPasswordResult.Loading -> {
            // Show loading state, e.g., display a progress indicator
        }
    }

}

@Composable
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    onNextBtnClick: (ForgotPasswordScreenModel) -> Unit = {}
) {

    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    BaseScreen(modifier = modifier.fillMaxSize().background(primaryColor)) {
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
                text = "Forgot Password",
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
                text = "Don't worry, we will send you a link to reset your password",
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
                text = "Phone Number",
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

            PhoneNumberTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp),
                onValueChange = {
                    phoneNumber = it
                }
            )

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
                        ForgotPasswordScreenModel(
                            email = email,
                            phoneNumber = phoneNumber
                        )
                    )

                }
            )

        }
    }

}

@Preview(showBackground = true, showSystemUi = true, apiLevel = 34)
@Composable
fun PreviewForgotPasswordScreen(modifier: Modifier = Modifier) {
    ForgotPasswordScreen(
        modifier = modifier
            .fillMaxSize(),
        onNextBtnClick = {
            // Handle next button click
        }
    )
}