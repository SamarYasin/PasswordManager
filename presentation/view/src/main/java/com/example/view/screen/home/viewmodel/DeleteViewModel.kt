package com.example.view.screen.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.usecase.DeleteAllCredentialsUseCase
import com.example.domain.usecase.DeleteCredentialUseCase
import com.example.view.DeleteDataBaseResult
import com.example.view.DeleteEntryResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeleteViewModel @Inject constructor(
    private val deleteCredentialUseCase: DeleteCredentialUseCase,
    private val deleteAllCredentialsUseCase: DeleteAllCredentialsUseCase
) : ViewModel() {

    private val _deleteEntryResult =
        MutableStateFlow<DeleteEntryResult>(DeleteEntryResult.Idle)
    val deleteEntryResult: Flow<DeleteEntryResult> get() = _deleteEntryResult

    private val _deleteDataBaseResult =
        MutableStateFlow<DeleteDataBaseResult>(DeleteDataBaseResult.Idle)
    val deleteDataBaseResult: Flow<DeleteDataBaseResult> get() = _deleteDataBaseResult

    fun deleteEntry(credentialId: CredentialRequestEntity) {
        _deleteEntryResult.value = DeleteEntryResult.Loading
        viewModelScope.launch {
            deleteCredentialUseCase.deleteCredential(credentialId)
            _deleteEntryResult.value = DeleteEntryResult.Success("Entry deleted successfully")
        }
    }

    fun deleteDatabase() {
        _deleteDataBaseResult.value = DeleteDataBaseResult.Loading
        viewModelScope.launch {
            deleteAllCredentialsUseCase.deleteAllCredential()
            _deleteDataBaseResult.value = DeleteDataBaseResult.Success("All entries deleted successfully")
        }
    }

}