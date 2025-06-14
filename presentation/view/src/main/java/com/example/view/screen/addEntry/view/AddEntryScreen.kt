package com.example.view.screen.addEntry.view

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
import com.example.view.AddEntryResult
import com.example.view.AddEntryValidationResult
import com.example.view.dialog.AlertDialogMessage
import com.example.view.screen.addEntry.model.AddEntryScreenModel
import com.example.view.screen.addEntry.viewmodel.AddEntryViewModel
import kotlin.coroutines.EmptyCoroutineContext

@Composable
fun RouteAddEntryScreen(
    modifier: Modifier = Modifier,
    addEntryViewModel: AddEntryViewModel = hiltViewModel(),
    onMoveNext: () -> Unit = {}
) {

    val validationResult by addEntryViewModel.validationResult.collectAsState(
        initial = AddEntryValidationResult.Idle,
        context = EmptyCoroutineContext
    )

    val addEntryResult by addEntryViewModel.addEntryResult.collectAsState(
        initial = AddEntryResult.Idle,
        context = EmptyCoroutineContext
    )

    AddEntryScreen(
        modifier = modifier,
        onNextBtnClick = { model: AddEntryScreenModel ->
            Log.d("Add Entry Screen", "RouteAddEntryScreen: model: $model")
            addEntryViewModel.validateAddEntryForm(model)
        }
    )

    when(validationResult){
        is AddEntryValidationResult.Idle -> {
            // Do nothing on idle state
        }
        is AddEntryValidationResult.Loading -> {

        }
        is AddEntryValidationResult.Error -> {
            AlertDialogMessage(
                modifier = modifier
                    .wrapContentSize(),
                onDismissRequest = {
                    addEntryViewModel.clearValidationError()
                },
                onConfirmation = {
                    addEntryViewModel.clearValidationError()
                },
                dialogTitle = "Error",
                dialogText = "An error occurred"
            )
        }
        is AddEntryValidationResult.Success -> {
            Log.d("Add Entry Screen", "RouteAddEntryScreen: Adding entry")
            addEntryViewModel.addEntry()
        }
    }

    when(addEntryResult) {
        is AddEntryResult.Idle -> {
            // Do nothing on idle state
        }

        is AddEntryResult.Loading -> {

        }

        is AddEntryResult.Error -> {
            AlertDialogMessage(
                modifier = modifier
                    .wrapContentSize(),
                onDismissRequest = {
                    Log.d("Add Entry Screen", "RouteAddEntryScreen: Error dialog dismissed")
                    addEntryViewModel.clearAddEntryError()
                },
                onConfirmation = {
                    Log.d("Add Entry Screen", "RouteAddEntryScreen: Error dialog confirmed")
                    addEntryViewModel.clearAddEntryError()
                },
                dialogTitle = "Error",
                dialogText = "An error occurred"
            )
        }

        is AddEntryResult.Success -> {
            Log.d("Add Entry Screen", "RouteAddEntryScreen: Entry added successfully")
            addEntryViewModel.clearAddEntryError()
            onMoveNext.invoke()
        }
    }

}

@Composable
fun AddEntryScreen(
    modifier: Modifier = Modifier,
    onNextBtnClick: (AddEntryScreenModel) -> Unit = {}
) {

    var title by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
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
                text = "Add Entry",
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
                    // Validate and invoke the next button click with the collected data
                    onNextBtnClick.invoke(
                        AddEntryScreenModel(
                            title = title,
                            name = name,
                            email = email,
                            password = password,
                            phoneNumber = phoneNumber
                        )
                    )

                    Log.d("Add Entry Screen", "AddEntryScreen: onNextBtnClick invoked with model: $title, $name, $email, $password, $phoneNumber")
                    // Reset fields after submission
                    title = ""
                    name = ""
                    email = ""
                    password = ""
                    phoneNumber = ""
                }
            )

        }

    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true, apiLevel = 34)
fun PreviewAddEntryScreen(
    modifier: Modifier = Modifier
) {
    AddEntryScreen(
        modifier = modifier
            .fillMaxSize(),
        onNextBtnClick = {
            // Handle next button click
        }
    )
}