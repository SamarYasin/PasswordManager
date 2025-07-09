package com.example.view.screen.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.usecase.DeleteCredentialUseCase
import com.example.view.DeleteEntryResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeleteEntryViewModel @Inject constructor(
    private val deleteCredentialUseCase: DeleteCredentialUseCase
) : ViewModel() {

    private val _deleteEntryResult =
        MutableStateFlow<DeleteEntryResult>(DeleteEntryResult.Idle)
    val deleteEntryResult: Flow<DeleteEntryResult> get() = _deleteEntryResult

    fun deleteEntry(credentialId: CredentialRequestEntity) {
        viewModelScope.launch {
            deleteCredentialUseCase.deleteCredential(credentialId)
            _deleteEntryResult.value = DeleteEntryResult.Success("Entry deleted successfully")
        }
    }

}