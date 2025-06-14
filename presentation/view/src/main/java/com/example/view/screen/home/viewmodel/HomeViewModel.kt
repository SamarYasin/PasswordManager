package com.example.view.screen.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.CredentialResponseEntity
import com.example.domain.usecase.GetCredentialsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCredentialsUseCase: GetCredentialsUseCase
) : ViewModel(){

    private val _credentials = MutableStateFlow<List<CredentialResponseEntity>>(emptyList())
    val credentials: Flow<List<CredentialResponseEntity>> get() = _credentials

    fun getCredentials() {
        viewModelScope.launch {
            _credentials.value = getCredentialsUseCase.getCredentials()
        }
    }

}