package com.example.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.example.style.Typography
import com.example.style.appButtonTextFontSize
import com.example.style.appHelperTextFontSize
import com.example.style.appHintTextFontSize
import com.example.style.appScreenTitleFontSize
import com.example.style.appViewNameFontSize
import com.example.style.onPrimaryColor
import com.example.style.onSecondaryColor

@Composable
fun AppScreenTitleText(
    modifier: Modifier = Modifier,
    text: String = "Password Manager",
    fontSize: TextUnit = appScreenTitleFontSize
) {
    Text(
        text = text,
        color = onPrimaryColor,
        fontSize = fontSize,
        modifier = modifier,
        style = Typography.bodyLarge
    )
}

@Composable
fun AppViewNameText(
    modifier: Modifier = Modifier,
    text: String = "Password Manager",
    fontSize: TextUnit = appViewNameFontSize
) {
    Text(
        text = text,
        color = onPrimaryColor,
        fontSize = fontSize,
        modifier = modifier,
        style = Typography.bodyMedium
    )
}

@Composable
fun AppHintText(
    modifier: Modifier = Modifier,
    text: String = "Password Manager",
    fontSize: TextUnit = appHintTextFontSize
) {
    Text(
        text = text,
        color = onSecondaryColor,
        fontSize = fontSize,
        modifier = modifier,
        style = Typography.bodyMedium
    )
}

@Composable
fun AppButtonText(
    modifier: Modifier = Modifier,
    text: String = "Password Manager",
    fontSize: TextUnit = appButtonTextFontSize
) {
    Text(
        text = text,
        color = onSecondaryColor,
        fontSize = fontSize,
        modifier = modifier,
        style = Typography.titleMedium
    )
}

@Composable
fun AppHelperText(
    modifier: Modifier = Modifier,
    text: String = "Password Manager",
    fontSize: TextUnit = appHelperTextFontSize
) {
    Text(
        text = text,
        color = onPrimaryColor,
        fontSize = fontSize,
        modifier = modifier,
        style = Typography.titleSmall
    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true, apiLevel = 34)
fun PreviewTexts(modifier: Modifier = Modifier){
    Column {
        AppScreenTitleText(
            modifier = modifier,
            text = "Password Manager",
            fontSize = appScreenTitleFontSize
        )
        AppViewNameText(
            modifier = modifier,
            text = "Password Manager",
            fontSize = appViewNameFontSize
        )
        AppHintText(
            modifier = modifier,
            text = "Password Manager",
            fontSize = appHintTextFontSize
        )
        AppButtonText(
            modifier = modifier,
            text = "Password Manager",
            fontSize = appButtonTextFontSize
        )
        AppHelperText(
            modifier = modifier,
            text = "Password Manager",
            fontSize = appHelperTextFontSize
        )
    }
}
