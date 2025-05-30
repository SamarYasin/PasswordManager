package com.example.view.screen.addEntry.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.AddCredentialUseCase
import com.example.view.screen.addEntry.model.AddEntryScreenModel
import com.example.view.screen.forgetPassword.model.ForgotPasswordScreenModel
import com.example.view.validation.CustomValidationClass
import javax.inject.Inject

class AddEntryViewModel @Inject constructor(
    private val addCredentialUseCase: AddCredentialUseCase,
    private val customValidationClass: CustomValidationClass
) : ViewModel() {

    fun validateAddEntryForm(addEntryScreenModel: AddEntryScreenModel): Boolean {
        return customValidationClass.isNameValid(addEntryScreenModel.title) &&
                customValidationClass.isNameValid(addEntryScreenModel.name) &&
                customValidationClass.isEmailValid(addEntryScreenModel.email) &&
                customValidationClass.isPasswordValid(addEntryScreenModel.password) &&
                customValidationClass.isPhoneNumberValid(addEntryScreenModel.phoneNumber)
    }

    fun addEntry(title: String, content: String) {
        // Implement logic to add an entry here
        // This could involve calling a repository or use case to save the entry
    }
}