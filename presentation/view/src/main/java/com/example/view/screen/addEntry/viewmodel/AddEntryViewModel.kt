package com.example.view.screen.addEntry.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.usecase.AddCredentialUseCase
import com.example.view.AddEntryResult
import com.example.view.AddEntryValidationResult
import com.example.view.screen.addEntry.model.AddEntryScreenModel
import com.example.view.validation.CustomValidationClass
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEntryViewModel @Inject constructor(
    private val addCredentialUseCase: AddCredentialUseCase,
    private val customValidationClass: CustomValidationClass
) : ViewModel() {

    private val _addEntryScreenModel = MutableStateFlow(AddEntryScreenModel())

    private val _validationResult =
        MutableStateFlow<AddEntryValidationResult>(AddEntryValidationResult.Idle)
    val validationResult: Flow<AddEntryValidationResult> get() = _validationResult

    private val _addEntryResult =
        MutableStateFlow<AddEntryResult>(AddEntryResult.Idle)
    val addEntryResult: Flow<AddEntryResult> get() = _addEntryResult

    fun validateAddEntryForm(addEntryScreenModel: AddEntryScreenModel) {
        _addEntryScreenModel.value = addEntryScreenModel
        val isValid = customValidationClass.isNameValid(addEntryScreenModel.title) &&
                customValidationClass.isNameValid(addEntryScreenModel.name) &&
                customValidationClass.isEmailValid(addEntryScreenModel.email) &&
                customValidationClass.isPasswordValid(addEntryScreenModel.password) &&
                customValidationClass.isPhoneNumberValid(addEntryScreenModel.phoneNumber)

        if (isValid) {
            _validationResult.value = AddEntryValidationResult.Success("Validation successful")
        } else {
            _validationResult.value = AddEntryValidationResult.Error("Validation failed")
        }

    }

    fun addEntry() {
        viewModelScope.launch {
            addCredentialUseCase.addCredential(
                CredentialRequestEntity(
                    entryName = _addEntryScreenModel.value.title,
                    name = _addEntryScreenModel.value.name,
                    email = _addEntryScreenModel.value.email,
                    password = _addEntryScreenModel.value.password,
                    mobileNumber = _addEntryScreenModel.value.phoneNumber
                )
            )
        }.invokeOnCompletion { throwable ->
            if (throwable == null) {
                _addEntryResult.value = AddEntryResult.Success("Entry added successfully")
            } else {
                _addEntryResult.value = AddEntryResult.Error("Failed to add entry: ${throwable.message}")
            }
        }
    }

    fun clearValidationError() {
        _validationResult.value = AddEntryValidationResult.Idle
    }

    fun clearAddEntryError() {
        _addEntryResult.value = AddEntryResult.Idle
    }

}