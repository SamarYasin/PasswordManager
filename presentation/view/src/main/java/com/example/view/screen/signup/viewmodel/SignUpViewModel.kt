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
            val nameValidation = customValidationClass.isNameValid(signUpScreenModel.name)
            if(!nameValidation.validationIsSuccessful){
                _validationResult.value = SignUpValidationResult.Error(nameValidation.validationMessage)
                return@launch
            }
            val emailValidation = customValidationClass.isEmailValid(signUpScreenModel.email)
            if(!emailValidation.validationIsSuccessful){
                _validationResult.value = SignUpValidationResult.Error(emailValidation.validationMessage)
                return@launch
            }
            val passwordValidation = customValidationClass.isPasswordValid(signUpScreenModel.password)
            if(!passwordValidation.validationIsSuccessful){
                _validationResult.value = SignUpValidationResult.Error(passwordValidation.validationMessage)
                return@launch
            }
            val confirmPasswordValidation = customValidationClass.isPasswordValid(signUpScreenModel.confirmPassword)
            if(!confirmPasswordValidation.validationIsSuccessful){
                _validationResult.value = SignUpValidationResult.Error(confirmPasswordValidation.validationMessage)
                return@launch
            }
            val phoneNumberValidation = customValidationClass.isPhoneNumberValid(signUpScreenModel.phoneNumber)
            if(!phoneNumberValidation.validationIsSuccessful){
                _validationResult.value = SignUpValidationResult.Error(phoneNumberValidation.validationMessage)
                return@launch
            }
            if(signUpScreenModel.password != signUpScreenModel.confirmPassword){
                _validationResult.value = SignUpValidationResult.Error("Passwords do not match")
                return@launch
            }

            _signUpScreenModel.value = signUpScreenModel
            _validationResult.value =
                SignUpValidationResult.Success("Validation successful")
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
        viewModelScope.launch {
            _validationResult.value = SignUpValidationResult.Idle
        }
    }

    fun clearSignUpResult() {
        viewModelScope.launch {
            _signUpResult.value = SignUpResult.Idle
        }
    }

}