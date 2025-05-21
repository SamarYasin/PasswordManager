package com.example.passwordmanager.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.passwordmanager.db.CredentialEntity
import com.example.passwordmanager.repo.CredentialsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PasswordManagerViewModel @Inject constructor(
    private val credentialsRepo: CredentialsRepo
) : ViewModel() {

    suspend fun getCredentials(): List<CredentialEntity> {
        return credentialsRepo.getAllCredentials()
    }

    fun addCredential(credentialEntity: CredentialEntity) {
        viewModelScope.launch {
            credentialsRepo.insertCredential(credentialEntity)
        }
    }

    fun updateCredential(credentialEntity: CredentialEntity) {
        viewModelScope.launch {
            credentialsRepo.updateCredential(credentialEntity)
        }
    }

    fun deleteCredential(credentialEntity: CredentialEntity) {
        viewModelScope.launch {
            credentialsRepo.deleteCredential(credentialEntity)
        }
    }

}