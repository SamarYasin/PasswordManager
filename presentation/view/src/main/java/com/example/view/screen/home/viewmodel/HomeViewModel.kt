package com.example.view.screen.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetCredentialsUseCase
import com.example.view.AccessDataBaseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCredentialsUseCase: GetCredentialsUseCase
) : ViewModel() {

    private val _credentials =
        MutableStateFlow<AccessDataBaseResult>(AccessDataBaseResult.Idle)
    val credentials: Flow<AccessDataBaseResult> get() = _credentials

    fun getCredentials() {
        _credentials.value = AccessDataBaseResult.Loading
        viewModelScope.launch {
            try {
                val value = getCredentialsUseCase.getCredentials()
                _credentials.value = AccessDataBaseResult.Success(value)
            } catch (e: Exception) {
                _credentials.value = AccessDataBaseResult.Error(e.message ?: "Unknown error")
            }
        }
    }

}