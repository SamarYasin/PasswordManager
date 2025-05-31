package com.example.view.screen.forgetPassword.view

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
import com.example.view.ForgetPasswordResult
import com.example.view.ForgetPasswordValidationResult
import com.example.view.ResultHandler
import com.example.view.SignInResult
import com.example.view.SignUpValidationResult
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
            forgetPasswordViewModel.validateForgetPasswordForm(
                forgotPasswordScreenModel
            )
        }
    )

    // TODO: Fix the logic behind showing Dialog, Right now not showing dialog when validation fails
    ResultHandler(
        result = validationResult,
        onSuccess = {
            forgetPasswordViewModel.resetPassword()
        },
        onError = { model: ForgetPasswordValidationResult ->
            AlertDialogMessage(
                modifier = modifier
                    .wrapContentSize(),
                onDismissRequest = {
                    forgetPasswordViewModel.clearValidationError()
                },
                onConfirmation = {
                    forgetPasswordViewModel.clearValidationError()
                },
                dialogTitle = "Error",
                dialogText = "An error occurred"
            )
        },
        onLoading = {
            // TODO: Attach Loader here
        },
        onIdle = {
            // TODO: Do nothing on idle state
        }
    )

    // TODO: Fix the logic behind showing Dialog, Right now not showing dialog when validation fails
    ResultHandler(
        result = forgotPasswordResult,
        onSuccess = {
            onNavigateToSignIn.invoke()
        },
        onError = { model: ForgetPasswordResult ->
            AlertDialogMessage(
                modifier = modifier
                    .wrapContentSize(),
                onDismissRequest = {
                    forgetPasswordViewModel.clearForgotPasswordError()
                },
                onConfirmation = {
                    forgetPasswordViewModel.clearForgotPasswordError()
                },
                dialogTitle = "Error",
                dialogText = "An error occurred"
            )
        },
        onLoading = {
            // TODO: Attach Loader here
        },
        onIdle = {
            // TODO: Do nothing on idle state
        }
    )

}

@Composable
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    onNextBtnClick: (ForgotPasswordScreenModel) -> Unit = {}
) {

    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    BaseScreen(modifier = modifier.fillMaxSize()) {
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
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp),
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