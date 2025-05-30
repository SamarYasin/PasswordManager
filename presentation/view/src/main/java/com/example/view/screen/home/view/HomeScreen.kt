package com.example.view.screen.home.view

import androidx.compose.foundation.layout.Column
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
    onCopyPassword: (String) -> Unit = {},
    onAddEntry : () -> Unit = {},
    onLogout: () -> Unit = {}
) {

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
        onCopyPassword = onCopyPassword
    )

}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    items: List<CredentialResponseEntity> = emptyList(),
    onEditEntry: (CredentialResponseEntity) -> Unit = {},
    onCopyPassword: (String) -> Unit = {},
    onAddEntry : () -> Unit = {},
    onLogout: () -> Unit = {}
) {

    BaseScreen(modifier = modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

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

            FloatingActionButton(
                modifier = modifier
                    .wrapContentSize()
                    .align(Alignment.End),
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