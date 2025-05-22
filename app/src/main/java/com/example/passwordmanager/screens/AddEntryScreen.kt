package com.example.passwordmanager.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.passwordmanager.components.AppScreenTitleText
import com.example.passwordmanager.components.AppViewNameText
import com.example.passwordmanager.components.BaseScreen
import com.example.passwordmanager.components.EmailTextField
import com.example.passwordmanager.components.NameTextField
import com.example.passwordmanager.components.PasswordTextField
import com.example.passwordmanager.components.PhoneNumberTextField
import com.example.passwordmanager.model.EntryModel

@Composable
fun RouteAddEntryScreen(
    modifier: Modifier = Modifier,
    onAddEntry: (EntryModel) -> Unit = {}
) {
    AddEntryScreen(
        modifier = modifier,
        onAddEntry = onAddEntry
    )
}

@Composable
fun AddEntryScreen(
    modifier: Modifier = Modifier,
    onAddEntry: (EntryModel) -> Unit = {}
) {

    BaseScreen(
        modifier = modifier
            .fillMaxSize()
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
                text = "New Entry",
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
                    // Handle email input
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
                    // Handle email input
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
                    // Handle email input
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
                    // Handle email input
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
                    // Handle email input
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
        onAddEntry = {
            // Handle add entry action
        }
    )
}