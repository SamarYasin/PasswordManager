package com.example.view.screen.setting.view

import android.content.Context
import android.os.Environment
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.component.BaseScreen
import com.example.component.FullWidthButton
import com.example.style.primaryColor
import com.example.view.screen.home.viewmodel.DeleteViewModel
import com.example.view.screen.home.viewmodel.HomeViewModel
import com.example.view.screen.setting.model.CredentialModel
import com.google.gson.Gson
import java.io.File
import kotlin.coroutines.EmptyCoroutineContext

@Composable
fun RouteSettingScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    deleteViewModel: DeleteViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val credentials by homeViewModel.credentials.collectAsState(
        initial = emptyList(),
        context = EmptyCoroutineContext
    )

    LaunchedEffect(credentials) {
        val entriesList = credentials.map {
            CredentialModel(
                entryName = it.entryName,
                password = it.password,
                email = it.email,
                mobileNumber = it.mobileNumber,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt
            )
        }
        val file: File? = getCredentialsFile(context, entriesList)
        if (file != null) {
            Log.d("SettingScreen", "File created: ${file.absolutePath}")
        } else {
            Log.d("SettingScreen", "File not created")
        }
    }

    SettingScreen(
        modifier = modifier,
        onDownloadFile = {
            homeViewModel.getCredentials()
        },
        onDeleteAllPasswords = {
            deleteViewModel.deleteDatabase()
        },
        onShareFile = {
            homeViewModel.getCredentials()
        }
    )
}

fun getCredentialsFile(context: Context, credentials: List<CredentialModel>): File? {
    if (credentials.isEmpty()) {
        return null
    }
    val jsonString = Gson().toJson(credentials)
    val fileName = "credentials_backup.json"
    val file = File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), fileName)
    file.writeText(jsonString)
    return file
}

@Composable
fun SettingScreen(
    modifier: Modifier = Modifier,
    onDownloadFile: () -> Unit = {},
    onDeleteAllPasswords: () -> Unit = {},
    onShareFile: () -> Unit = {}
) {

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
                    .fillMaxHeight(0.2F)
            )

            FullWidthButton(
                modifier = Modifier,
                text = "Download File",
                onClick = {
                    onDownloadFile.invoke()
                }
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.05F)
            )

            FullWidthButton(
                modifier = Modifier,
                text = "Delete All Passwords",
                onClick = {
                    onDeleteAllPasswords.invoke()
                }
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.05F)
            )

            FullWidthButton(
                modifier = Modifier,
                text = "Share App Passwords File",
                onClick = {
                    onShareFile.invoke()
                }
            )

        }

    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true, apiLevel = 34)
fun PreviewSettingScreen(modifier: Modifier = Modifier) {
    SettingScreen(
        modifier = modifier.fillMaxSize(),
        onDeleteAllPasswords = {

        },
        onDownloadFile = {

        },
        onShareFile = {

        }
    )
}