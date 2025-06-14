package com.example.view.screen.signup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.view.SignUpResult
import com.example.view.SignUpValidationResult
import com.example.view.screen.signup.model.SignUpScreenModel
import com.example.view.validation.CustomValidationClass
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val customValidationClass: CustomValidationClass
) : ViewModel() {

    private val _signUpScreenModel = MutableStateFlow(SignUpScreenModel())

    private val _validationResult = MutableStateFlow<SignUpValidationResult>(SignUpValidationResult.Idle)
    val validationResult: Flow<SignUpValidationResult> get() = _validationResult

    private val _signUpResult = MutableStateFlow<SignUpResult>(SignUpResult.Idle)
    val signUpResult: Flow<SignUpResult> get() = _signUpResult

    fun validateSignUpForm(signUpScreenModel: SignUpScreenModel) {
        viewModelScope.launch {
            _signUpScreenModel.value = signUpScreenModel
            val isValid = customValidationClass.isNameValid(signUpScreenModel.name) &&
                    customValidationClass.isEmailValid(signUpScreenModel.email) &&
                    customValidationClass.isPasswordValid(signUpScreenModel.password) &&
                    customValidationClass.isPasswordValid(signUpScreenModel.confirmPassword) &&
                    customValidationClass.isPhoneNumberValid(signUpScreenModel.phoneNumber) &&
                    signUpScreenModel.password == signUpScreenModel.confirmPassword

            if (isValid) {
                _validationResult.value =
                    SignUpValidationResult.Success("Validation successful")
            } else {
                _validationResult.value =
                    SignUpValidationResult.Error("Validation failed")
            }
        }
    }

    // TODO: Fix it to handle actual sign-up logic
    fun signUp() {
        viewModelScope.launch {
            if (_validationResult.value is SignUpValidationResult.Success) {
                // Simulate a sign-up process
                _signUpResult.value = SignUpResult.Success("Sign-up successful")
            } else {
                _signUpResult.value = SignUpResult.Error("Sign-up failed due to validation errors")
            }
        }
    }

    fun clearValidationError() {
        _validationResult.value = SignUpValidationResult.Idle
    }

    fun clearSignUpError() {
        _signUpResult.value = SignUpResult.Idle
    }

}