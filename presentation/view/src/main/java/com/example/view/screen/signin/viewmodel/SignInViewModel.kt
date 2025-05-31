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
            _signInScreenModel.value = signInScreenModel
            val isValid = customValidationClass.isEmailValid(signInScreenModel.email) &&
                    customValidationClass.isPasswordValid(signInScreenModel.password)

            if (isValid){
                _validationResult.value = SignInValidationResult.Success("Validation successful")
            } else {
                _validationResult.value = SignInValidationResult.Error("Validation failed")
            }
        }
    }

    // TODO: Fix it to handle actual sign-in logic
    fun signIn() {
        viewModelScope.launch {
            if (_validationResult.value is SignInValidationResult.Success) {
                // Simulate a sign-in process
                _signInResult.value = SignInResult.Success("Sign-in successful")
            } else {
                _signInResult.value = SignInResult.Error("Sign-in failed due to validation errors")
            }
        }
    }

    fun clearValidationError() {
        _validationResult.value = SignInValidationResult.Idle
    }

    fun clearSignInError() {
        _signInResult.value = SignInResult.Idle
    }

}