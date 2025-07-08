package com.example.view.screen.editEntry.view

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
import com.example.component.NameTextField
import com.example.component.PasswordTextField
import com.example.component.PhoneNumberTextField
import com.example.style.primaryColor
import com.example.view.EditEntryResult
import com.example.view.EditEntryValidationResult
import com.example.view.dialog.AlertDialogMessage
import com.example.view.screen.editEntry.model.EditEntryScreenModel
import com.example.view.screen.editEntry.viewmodel.EditEntryViewModel
import kotlin.coroutines.EmptyCoroutineContext

@Composable
fun RouteEditEntryScreen(
    modifier: Modifier = Modifier,
    editEntryViewModel: EditEntryViewModel = hiltViewModel(),
    onMoveNext: () -> Unit = {}
) {

    val validationResult by editEntryViewModel.validationResult.collectAsState(
        initial = EditEntryValidationResult.Idle,
        context = EmptyCoroutineContext
    )

    val editEntryResult by editEntryViewModel.editEntryResult.collectAsState(
        initial = EditEntryResult.Idle,
        context = EmptyCoroutineContext
    )

    EditEntryScreen(
        modifier = modifier,
        onNextBtnClick = { model: EditEntryScreenModel ->
            Log.d("Edit Entry Screen", "RouteEditEntryScreen: model: $model")
            editEntryViewModel.validateEditEntryForm(model)
        }
    )

    when (validationResult) {
        is EditEntryValidationResult.Idle -> {
            // Do nothing on idle state
        }

        is EditEntryValidationResult.Loading -> {

        }

        is EditEntryValidationResult.Error -> {
            AlertDialogMessage(
                modifier = modifier
                    .wrapContentSize(),
                onDismissRequest = {
                    Log.d("Edit Entry Screen", "RouteEditEntryScreen: Error Dialog Dismissed")
                    editEntryViewModel.clearValidationError()
                },
                onConfirmation = {
                    Log.d("Edit Entry Screen", "RouteEditEntryScreen: Error Dialog Confirmed")
                    editEntryViewModel.clearValidationError()
                },
                dialogTitle = "Error",
                dialogText = "An error occurred"
            )
        }

        is EditEntryValidationResult.Success -> {
            Log.d("Edit Entry Screen", "RouteEditEntryScreen: Validation Success")
            editEntryViewModel.updateEntry()
        }
    }

    when (editEntryResult) {
        is EditEntryResult.Idle -> {
            // Do nothing on idle state
        }

        is EditEntryResult.Loading -> {

        }

        is EditEntryResult.Error -> {
            AlertDialogMessage(
                modifier = modifier
                    .wrapContentSize(),
                onDismissRequest = {
                    Log.d("Edit Entry Screen", "RouteEditEntryScreen: Error Dialog Dismissed")
                    editEntryViewModel.clearEditEntryError()
                },
                onConfirmation = {
                    Log.d("Edit Entry Screen", "RouteEditEntryScreen: Error Dialog Confirmed")
                    editEntryViewModel.clearEditEntryError()
                },
                dialogTitle = "Error",
                dialogText = "An error occurred"
            )
        }

        is EditEntryResult.Success -> {
            Log.d("Edit Entry Screen", "RouteEditEntryScreen: Edit Entry Success")
            editEntryViewModel.clearEditEntryError()
            onMoveNext.invoke()
        }
    }

}

@Composable
fun EditEntryScreen(
    modifier: Modifier = Modifier,
    onNextBtnClick: (EditEntryScreenModel) -> Unit = {}
) {

    var title by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    BaseScreen(
        modifier = modifier
            .fillMaxSize()
            .background(primaryColor)
    ) {

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
                text = "Update Entry",
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
                text = "Title",
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
                hint = "Enter title",
                onValueChange = {
                    title = it
                }
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
                    .height(20.dp)
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
                    .height(20.dp)
            )

            AppViewNameText(
                text = "Mobile Number",
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
                text = "Next",
                onClick = {
                    // Validate and submit the form
                    onNextBtnClick.invoke(
                        EditEntryScreenModel(
                            title = title,
                            email = email,
                            password = password,
                            phoneNumber = phoneNumber
                        )
                    )
                }
            )

        }

    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true, apiLevel = 34)
fun PreviewEditEntryScreen(modifier: Modifier = Modifier) {
    EditEntryScreen(
        modifier = modifier.fillMaxSize(),
        onNextBtnClick = {}
    )
}