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
        viewModelScope.launch {
            val nameValidation = customValidationClass.isNameValid(addEntryScreenModel.title)
            if (!nameValidation.validationIsSuccessful) {
                _validationResult.value =
                    AddEntryValidationResult.Error(nameValidation.validationMessage)
                return@launch
            }
            val emailValidation = customValidationClass.isEmailValid(addEntryScreenModel.email)
            if (!emailValidation.validationIsSuccessful) {
                _validationResult.value =
                    AddEntryValidationResult.Error(emailValidation.validationMessage)
                return@launch
            }
            val passwordValidation =
                customValidationClass.isPasswordValid(addEntryScreenModel.password)
            if (!passwordValidation.validationIsSuccessful) {
                _validationResult.value =
                    AddEntryValidationResult.Error(passwordValidation.validationMessage)
                return@launch
            }
            val phoneNumberValidation =
                customValidationClass.isPhoneNumberValid(addEntryScreenModel.phoneNumber)
            if (!phoneNumberValidation.validationIsSuccessful) {
                _validationResult.value =
                    AddEntryValidationResult.Error(phoneNumberValidation.validationMessage)
                return@launch
            }
            _addEntryScreenModel.value = addEntryScreenModel
            _validationResult.value = AddEntryValidationResult.Success("Validation successful")
        }

    }

    fun addEntry() {
        viewModelScope.launch {
            addCredentialUseCase.addCredential(
                CredentialRequestEntity(
                    entryName = _addEntryScreenModel.value.title,
                    email = _addEntryScreenModel.value.email,
                    password = _addEntryScreenModel.value.password,
                    mobileNumber = _addEntryScreenModel.value.phoneNumber
                )
            )
            _addEntryResult.value = AddEntryResult.Success("Entry added successfully")
        }
    }

    fun clearValidationResult() {
        viewModelScope.launch {
            _validationResult.value = AddEntryValidationResult.Idle
        }
    }

    fun clearAddEntryResult() {
        viewModelScope.launch {
            _addEntryResult.value = AddEntryResult.Idle
        }
    }

}