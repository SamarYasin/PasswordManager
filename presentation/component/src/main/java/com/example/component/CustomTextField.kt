package com.example.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NameTextField(
    modifier: Modifier = Modifier,
    hint: String = "Enter Name",
    onValueChange: (String) -> Unit = {}
) {
    var name by remember { mutableStateOf("") }
    BasicTextField(
        modifier = modifier,
        value = name,
        onValueChange = {
            name = it
            onValueChange(it)
        },
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
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                if (name.isEmpty()) {
                    AppHintText(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 12.dp),
                        text = hint
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 12.dp)
                    ) {
                        innerTextField()
                    }
                }
            }
        }
    )
}

@Composable
fun EmailTextField(
    modifier: Modifier = Modifier,
    hint: String = "Enter Email",
    onValueChange: (String) -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    BasicTextField(
        modifier = modifier,
        value = email,
        onValueChange = {
            email = it
            onValueChange(it)
        },
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
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                if (email.isEmpty()) {
                    AppHintText(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 12.dp),
                        text = hint
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 12.dp)
                    ) {
                        innerTextField()
                    }
                }
            }
        }
    )
}

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    hint: String = "Enter Password",
    onValueChange: (String) -> Unit = {}
) {

    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    BasicTextField(
        modifier = modifier,
        value = password,
        onValueChange = {
            password = it
            onValueChange(it)
        },
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
        visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                if (password.isEmpty()) {
                    AppHintText(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 12.dp),
                        text = hint
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 12.dp)
                    ) {
                        innerTextField()
                    }
                }

                ClickableIcons(
                    modifier = Modifier
                        .size(36.dp)
                        .align(Alignment.CenterEnd)
                        .padding(end = 12.dp),
                    imageVector = if (passwordVisible) R.drawable.ic_show else R.drawable.ic_hide,
                    onClick = {
                        passwordVisible = !passwordVisible
                    }
                )

            }
        }
    )
}

@Composable
fun PhoneNumberTextField(
    modifier: Modifier = Modifier,
    hint: String = "Enter Number",
    onValueChange: (String) -> Unit = {}
) {
    var phoneNumber by remember { mutableStateOf("") }
    BasicTextField(
        modifier = modifier,
        value = phoneNumber,
        onValueChange = {
            phoneNumber = it
            onValueChange(it)
        },
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
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                if (phoneNumber.isEmpty()) {
                    AppHintText(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 12.dp),
                        text = hint
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 12.dp)
                    ) {
                        innerTextField()
                    }
                }
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
