package com.example.view.screen.home.view

import android.widget.Toast
import androidx.compose.animation.core.animateDpAsState
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
import androidx.compose.ui.platform.ClipEntry
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.component.BaseScreen
import com.example.domain.entity.CredentialResponseEntity
import com.example.view.screen.home.viewmodel.HomeViewModel
import kotlin.coroutines.EmptyCoroutineContext

@Composable
fun RouteHomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    onEditEntry: (CredentialResponseEntity) -> Unit = {},
    onAddEntry: () -> Unit = {},
    onLogout: () -> Unit = {}
) {

    val context = LocalContext.current
    val clipboardManager: ClipboardManager = LocalClipboardManager.current
    val credentials by homeViewModel.credentials.collectAsState(
        initial = emptyList(),
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
        onCopyPassword = { password : String ->
            // TODO: Fix it to handle actual copy to clipboard logic
             // This is a placeholder for the actual password copy logic
             // You can use the ClipboardManager to copy the password to clipboard
//            clipboardManager.setText(ClipEntry(password))
             Toast.makeText(context, "Password copied to clipboard", Toast.LENGTH_SHORT).show()
        }
    )

}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    items: List<CredentialResponseEntity> = emptyList(),
    onEditEntry: (CredentialResponseEntity) -> Unit = {},
    onCopyPassword: (String) -> Unit = {},
    onAddEntry: () -> Unit = {},
    onLogout: () -> Unit = {}
) {

    BaseScreen(modifier = modifier.fillMaxSize()) {

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
                Icon(Icons.Default.Add, contentDescription = "Add")
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