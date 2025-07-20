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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.component.BaseScreen
import com.example.component.FullWidthButton
import com.example.domain.entity.CredentialResponseEntity
import com.example.style.primaryColor
import com.example.view.AccessDataBaseResult
import com.example.view.screen.home.viewmodel.DeleteViewModel
import com.example.view.screen.home.viewmodel.HomeViewModel
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
        initial = AccessDataBaseResult.Idle,
        context = EmptyCoroutineContext
    )

    var credentialsList by remember { mutableStateOf(emptyList<CredentialResponseEntity>()) }

    when (credentials) {
        is AccessDataBaseResult.Idle -> {
            // Do nothing on idle state
        }

        is AccessDataBaseResult.Loading -> {
            // TODO: Attach Loader here
        }

        is AccessDataBaseResult.Success -> {
            Log.d("SignUpScreen", "Validation Success: Proceeding to sign up")
            credentialsList = (credentials as AccessDataBaseResult.Success).list
        }

        is AccessDataBaseResult.Error -> {
            Log.d("SignUpScreen", "Sign Up Error: result : ${(credentials as AccessDataBaseResult.Error).message}")
        }
    }

    LaunchedEffect(credentials) {
        val file: File? = getCredentialsFile(context, (credentials as AccessDataBaseResult.Success).list)
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

fun getCredentialsFile(context: Context, credentials: List<CredentialResponseEntity>): File? {
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