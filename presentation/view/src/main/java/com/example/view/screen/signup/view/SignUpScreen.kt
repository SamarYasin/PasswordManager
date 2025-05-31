package com.example.view.screen.signup.view

import androidx.compose.foundation.clickable
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
import com.example.component.NameTextField
import com.example.component.PasswordTextField
import com.example.component.PhoneNumberTextField
import com.example.view.ResultHandler
import com.example.view.SignUpResult
import com.example.view.SignUpValidationResult
import com.example.view.dialog.AlertDialogMessage
import com.example.view.screen.signup.model.SignUpScreenModel
import com.example.view.screen.signup.viewmodel.SignUpViewModel
import kotlin.coroutines.EmptyCoroutineContext

@Composable
fun RouteSignUpScreen(
    modifier: Modifier = Modifier,
    signUpViewModel: SignUpViewModel = hiltViewModel(),
    onNavigateToSignIn: () -> Unit = {},
    onSignUpResult: () -> Unit = {}
) {

    val validationResult by signUpViewModel.validationResult.collectAsState(
        initial = SignUpValidationResult.Idle,
        context = EmptyCoroutineContext
    )

    val signUpResult by signUpViewModel.signUpResult.collectAsState(
        initial = SignUpResult.Idle,
        context = EmptyCoroutineContext
    )

    SignUpScreen(
        modifier = modifier,
        onNavigateToSignIn = onNavigateToSignIn,
        onNextBtnClick = { signUpScreenModel: SignUpScreenModel ->
            signUpViewModel.validateSignUpForm(
                signUpScreenModel
            )
        }
    )

    // TODO: Fix the logic behind showing Dialog, Right now not showing dialog when validation fails
    ResultHandler(
        result = validationResult,
        onSuccess = {
            signUpViewModel.signUp()
        },
        onError = { model : SignUpValidationResult ->
            AlertDialogMessage(
                modifier = modifier
                    .wrapContentSize(),
                onDismissRequest = {
                    signUpViewModel.clearValidationError()
                },
                onConfirmation = {
                    signUpViewModel.clearValidationError()
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
        result = signUpResult,
        onSuccess = {
            onSignUpResult.invoke()
        },
        onError = { model : SignUpResult ->
            AlertDialogMessage(
                modifier = modifier
                    .wrapContentSize(),
                onDismissRequest = {
                    signUpViewModel.clearSignUpError()
                },
                onConfirmation = {
                    signUpViewModel.clearSignUpError()
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
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onNavigateToSignIn: () -> Unit = {},
    onNextBtnClick: (SignUpScreenModel) -> Unit = {}
) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
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
                text = "Sign Up",
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
                text = "Create an account & keep your passwords safe",
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
                text = "Name",
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

            NameTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp),
                onValueChange = {
                    name = it
                }
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(12.dp)
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

            AppViewNameText(
                text = "Confirm Password",
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
                    confirmPassword = it
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
                    .height(12.dp)
            )

            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.End)
            ) {

                AppHelperText(
                    text = "Already have an account?",
                    modifier = Modifier
                        .wrapContentSize()
                )

                AppHelperText(
                    text = " Sign In",
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            onNavigateToSignIn.invoke()
                        }
                )

            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.1F)
            )

            FullWidthButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp),
                text = "Sign Up",
                onClick = {
                    onNextBtnClick.invoke(
                        SignUpScreenModel(
                            name = name,
                            email = email,
                            password = password,
                            confirmPassword = confirmPassword,
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
fun PreviewSignUpScreen(
    modifier: Modifier = Modifier
) {
    SignUpScreen(
        modifier = modifier.fillMaxSize(),
        onNavigateToSignIn = {
            // Handle navigation to sign in
        },
        onNextBtnClick = {

        }
    )
}