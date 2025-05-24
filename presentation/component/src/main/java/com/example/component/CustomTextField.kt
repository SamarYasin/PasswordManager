package com.example.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NameTextField(
    modifier: Modifier = Modifier,
    initialValue: String = "",
    hint: String = "Enter Name",
    onValueChange: (String) -> Unit = {}
) {
    BasicTextField(
        modifier = modifier,
        value = initialValue,
        onValueChange = onValueChange,
        minLines = 1,
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            autoCorrectEnabled = false,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                // Handle the done action
            }
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier.fillMaxWidth().border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(12.dp)
                )
            ){
                AppHintText(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 12.dp),
                    text = hint
                )
                innerTextField()
            }
        }
    )
}

@Composable
fun EmailTextField(
    modifier: Modifier = Modifier,
    initialValue: String = "",
    hint: String = "Enter Email",
    onValueChange: (String) -> Unit = {}
) {
    BasicTextField(
        modifier = modifier,
        value = initialValue,
        onValueChange = onValueChange,
        minLines = 1,
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            autoCorrectEnabled = false,
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                // Handle the done action
            }
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier.fillMaxWidth().border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(12.dp)
                )
            ){
                AppHintText(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 12.dp),
                    text = hint
                )
                innerTextField()
            }
        }
    )
}

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    initialValue: String = "",
    hint: String = "Enter Password",
    onValueChange: (String) -> Unit = {}
) {
    BasicTextField(
        modifier = modifier,
        value = initialValue,
        onValueChange = onValueChange,
        minLines = 1,
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            autoCorrectEnabled = false,
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                // Handle the done action
            }
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier.fillMaxWidth().border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(12.dp)
                )
            ){
                AppHintText(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 12.dp),
                    text = hint
                )
                innerTextField()
            }
        }
    )
}

@Composable
fun PhoneNumberTextField(
    modifier: Modifier = Modifier,
    initialValue: String = "",
    hint: String = "Enter Number",
    onValueChange: (String) -> Unit = {}
) {
    BasicTextField(
        modifier = modifier,
        value = initialValue,
        onValueChange = onValueChange,
        minLines = 1,
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            autoCorrectEnabled = false,
            keyboardType = KeyboardType.Phone,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                // Handle the done action
            }
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier.fillMaxWidth().border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(12.dp)
                )
            ){
                AppHintText(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 12.dp),
                    text = hint
                )
                innerTextField()
            }
        }
    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true, apiLevel = 34)
fun PreviewTextFields(
    modifier: Modifier = Modifier
) {
    Column {
        NameTextField(
            modifier = modifier.fillMaxWidth()
        )
        EmailTextField(
            modifier = modifier.fillMaxWidth()
        )
        PasswordTextField(
            modifier = modifier.fillMaxWidth()
        )
    }
}
