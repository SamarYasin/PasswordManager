package com.example.view.screen.editEntry.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.UpdateCredentialUseCase
import com.example.view.EditEntryResult
import com.example.view.EditEntryValidationResult
import com.example.view.screen.editEntry.model.EditEntryScreenModel
import com.example.view.validation.CustomValidationClass
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class EditEntryViewModel @Inject constructor(
    private val updateCredentialUseCase: UpdateCredentialUseCase,
    private val customValidationClass: CustomValidationClass
) : ViewModel() {

    private val _editEntryScreenModel = MutableStateFlow(EditEntryScreenModel())

    private val _validationResult =
        MutableStateFlow<EditEntryValidationResult>(EditEntryValidationResult.Idle)
    val validationResult: Flow<EditEntryValidationResult> get() = _validationResult

    private val _editEntryResult =
        MutableStateFlow<EditEntryResult>(EditEntryResult.Idle)
    val editEntryResult: Flow<EditEntryResult> get() = _editEntryResult

    fun validateEditEntryForm(editEntryScreenModel: EditEntryScreenModel) {
        _editEntryScreenModel.value = editEntryScreenModel
        val isValid = customValidationClass.isNameValid(editEntryScreenModel.title) &&
                customValidationClass.isNameValid(editEntryScreenModel.name) &&
                customValidationClass.isEmailValid(editEntryScreenModel.email) &&
                customValidationClass.isPasswordValid(editEntryScreenModel.password) &&
                customValidationClass.isPhoneNumberValid(editEntryScreenModel.phoneNumber)

        if (isValid) {
            _validationResult.value = EditEntryValidationResult.Success("Validation successful")
        } else {
            _validationResult.value = EditEntryValidationResult.Error("Validation failed")
        }

    }

    // TODO: Fix it to handle actual sign-up logic
    fun updateEntry() {
        if (_validationResult.value is EditEntryValidationResult.Success) {
            // Simulate adding an entry
            _editEntryResult.value = EditEntryResult.Success("Entry added successfully")
        } else {
            _editEntryResult.value = EditEntryResult.Error("Cannot add entry, validation failed")
        }
    }

    fun clearValidationError() {
        _validationResult.value = EditEntryValidationResult.Idle
    }

    fun clearEditEntryError() {
        _editEntryResult.value = EditEntryResult.Idle
    }

}