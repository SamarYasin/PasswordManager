package com.example.view.screen.signin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.view.SignInResult
import com.example.view.SignInValidationResult
import com.example.view.screen.signin.model.SignInScreenModel
import com.example.view.validation.CustomValidationClass
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val customValidationClass: CustomValidationClass
) : ViewModel() {

    private val _signInScreenModel = MutableStateFlow(SignInScreenModel())

    private val _validationResult =
        MutableStateFlow<SignInValidationResult>(SignInValidationResult.Idle)
    val validationResult: Flow<SignInValidationResult> get() = _validationResult

    private val _signInResult = MutableStateFlow<SignInResult>(SignInResult.Idle)
    val signInResult: Flow<SignInResult> get() = _signInResult

    fun validateSignInForm(signInScreenModel: SignInScreenModel) {
        viewModelScope.launch {
            val emailValidation = customValidationClass.isEmailValid(signInScreenModel.email)
            if (!emailValidation.validationIsSuccessful) {
                _validationResult.value =
                    SignInValidationResult.Error(emailValidation.validationMessage)
                return@launch
            }
            val passwordValidation =
                customValidationClass.isPasswordValid(signInScreenModel.password)
            if (!passwordValidation.validationIsSuccessful) {
                _validationResult.value =
                    SignInValidationResult.Error(passwordValidation.validationMessage)
                return@launch
            }
            _signInScreenModel.value = signInScreenModel
            _validationResult.value =
                SignInValidationResult.Success("Validation successful")
        }
    }

    // TODO: Fix it to handle actual sign-in logic
    fun signIn() {
        viewModelScope.launch {
            if (_validationResult.value is SignInValidationResult.Success) {
                _signInResult.value = SignInResult.Success("Sign-in successful")
            } else {
                _signInResult.value = SignInResult.Error("Sign-in failed due to validation errors")
            }
        }
    }

    fun clearValidationError() {
        viewModelScope.launch {
            _validationResult.value = SignInValidationResult.Idle
        }
    }

    fun clearSignInResult() {
        viewModelScope.launch {
            _signInResult.value = SignInResult.Idle
        }
    }

}