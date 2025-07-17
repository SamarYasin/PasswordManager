package com.example.view.screen.home.view

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.component.BaseScreen
import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.entity.CredentialResponseEntity
import com.example.style.primaryColor
import com.example.view.DeleteEntryResult
import com.example.view.screen.home.viewmodel.DeleteViewModel
import com.example.view.screen.home.viewmodel.HomeViewModel
import kotlin.coroutines.EmptyCoroutineContext

@Composable
fun RouteHomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    deleteViewModel: DeleteViewModel = hiltViewModel(),
    onEditEntry: (CredentialResponseEntity) -> Unit = {},
    onAddEntry: () -> Unit = {},
    onLogout: () -> Unit = {}
) {

    val context = LocalContext.current
    val credentials by homeViewModel.credentials.collectAsState(
        initial = emptyList(),
        context = EmptyCoroutineContext
    )

    val deleteEntryResult by deleteViewModel.deleteEntryResult.collectAsState(
        initial = DeleteEntryResult.Idle,
        context = EmptyCoroutineContext
    )

    LaunchedEffect(Unit) {
        homeViewModel.getCredentials()
    }

    HomeScreen(
        modifier = modifier,
        items = credentials,
        onEditEntry = onEditEntry,
        onLogout = onLogout,
        onAddEntry = onAddEntry,
        onCopyPassword = { password: String ->
            Log.d("HomeScreen", "Copying password: $password")
            Toast.makeText(context, "Password copied to clipboard", Toast.LENGTH_SHORT).show()
        },
        onDeleteEntry = { credential: CredentialRequestEntity ->
            Log.d("HomeScreen", "Deleting entry: $credential")
            deleteViewModel.deleteEntry(credential)
        }
    )

    when (deleteEntryResult) {
        is DeleteEntryResult.Success -> {
            Log.d("HomeScreen", "Entry deleted successfully")
            Toast.makeText(context, "Entry deleted successfully", Toast.LENGTH_SHORT).show()
            homeViewModel.getCredentials()
        }

        is DeleteEntryResult.Error -> {
            Toast.makeText(
                context,
                "Failed to delete entry: ${(deleteEntryResult as DeleteEntryResult.Error).message}",
                Toast.LENGTH_SHORT
            ).show()
            Log.e("HomeScreen", "Error deleting entry: ${(deleteEntryResult as DeleteEntryResult.Error).message}")
        }

        is DeleteEntryResult.Idle -> {
            // Do nothing
        }

        is DeleteEntryResult.Loading -> {
            // Show loading indicator if needed
        }
    }

}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    items: List<CredentialResponseEntity> = emptyList(),
    onEditEntry: (CredentialResponseEntity) -> Unit = {},
    onCopyPassword: (String) -> Unit = {},
    onAddEntry: () -> Unit = {},
    onDeleteEntry: (CredentialRequestEntity) -> Unit = {},
    onLogout: () -> Unit = {}
) {

    BaseScreen(modifier = modifier
        .fillMaxSize()
        .background(primaryColor)) {

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(items.size) { index ->
                    val item = items[index]
                    EntryItem(
                        modifier = Modifier.padding(bottom = 8.dp),
                        item = item,
                        onEditEntry = {
                            onEditEntry(item)
                        },
                        onDeleteEntry = {
                            onDeleteEntry.invoke(
                                CredentialRequestEntity(
                                    entryName = item.entryName,
                                    email = item.email,
                                    password = item.password,
                                    mobileNumber = item.mobileNumber
                                )
                            )
                        },
                        onCopyPassword = {
                            onCopyPassword(item.password)
                        }
                    )
                }
            }

            FloatingActionButton(
                modifier = modifier
                    .wrapContentSize()
                    .align(Alignment.BottomEnd)
                    .padding(end = 16.dp, bottom = 16.dp),
                onClick = {
                    onAddEntry.invoke()
                },
                shape = FloatingActionButtonDefaults.smallShape,
                containerColor = FloatingActionButtonDefaults.containerColor,
                contentColor = FloatingActionButtonDefaults.containerColor,
                elevation = FloatingActionButtonDefaults.elevation(8.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.Black )
            }

        }

    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true, apiLevel = 34)
fun PreviewHomeScreen(modifier: Modifier = Modifier) {
    HomeScreen(
        modifier = modifier.fillMaxSize(),
        items = listOf(),
        onEditEntry = {
            // Handle edit entry action
        },
        onCopyPassword = {
            // Handle copy password action
        },
        onLogout = {
            // Handle logout action
        }
    )
}