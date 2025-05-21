package com.example.passwordmanager.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.passwordmanager.components.BaseScreen
import com.example.passwordmanager.db.CredentialEntity
import com.example.passwordmanager.mapper.map
import com.example.passwordmanager.model.EntryModel
import com.example.passwordmanager.viewModel.PasswordManagerViewModel

@Composable
fun RouteHomeScreen(
    modifier: Modifier = Modifier,
    viewModel: PasswordManagerViewModel,
    onEditEntry: (EntryModel) -> Unit = {},
    onCopyPassword: (String) -> Unit = {},
    onLogout: () -> Unit = {}
) {

    var credentials by remember { mutableStateOf(emptyList<CredentialEntity>()) }
    var credentialList by remember { mutableStateOf(emptyList<EntryModel>()) }

    LaunchedEffect(Unit) {
        credentials = viewModel.getCredentials()
        credentials.forEach { item: CredentialEntity ->
            credentialList = credentialList + item.map()
        }
    }

    HomeScreen(
        modifier = modifier,
        items = credentialList,
        onEditEntry = onEditEntry,
        onLogout = onLogout,
        onCopyPassword = onCopyPassword
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    items: List<EntryModel> = emptyList(),
    onEditEntry: (EntryModel) -> Unit = {},
    onCopyPassword: (String) -> Unit = {},
    onLogout: () -> Unit = {}
) {
    BaseScreen(modifier = modifier) {
        LazyColumn(modifier = Modifier.padding(16.dp)) {
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