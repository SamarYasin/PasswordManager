package com.example.view.screen.signin.view

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
import com.example.view.ResultHandler
import com.example.view.SignInResult
import com.example.view.SignUpValidationResult
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
        initial = SignUpValidationResult.Idle,
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
            signInViewModel.validateSignInForm(
                signInScreenModel
            )
        }
    )

    ResultHandler(
        result = validationResult,
        onSuccess = {
            signInViewModel.signIn()
        },
        onError = {
            AlertDialogMessage(
                modifier = modifier
                    .wrapContentSize(),
                onDismissRequest = {

                },
                onConfirmation = {

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

    ResultHandler(
        result = signInResult,
        onSuccess = {
            onSignInResult.invoke()
        },
        onError = {
            AlertDialogMessage(
                modifier = modifier
                    .wrapContentSize(),
                onDismissRequest = {

                },
                onConfirmation = {

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
fun SignInScreen(
    modifier: Modifier = Modifier,
    onNavigateToSignUp: () -> Unit = {},
    onNextBtnClick: (SignInScreenModel) -> Unit = {},
    onForgotPassword: () -> Unit = {}
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp),
                text = "Sign In",
                onClick = {
                    onNextBtnClick.invoke(
                        SignInScreenModel(
                            email = email,
                            password = password
                        )
                    )
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