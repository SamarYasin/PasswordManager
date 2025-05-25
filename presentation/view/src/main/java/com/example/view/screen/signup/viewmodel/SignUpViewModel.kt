package com.example.view.screen.signup.viewmodel

import androidx.lifecycle.ViewModel
import com.example.view.screen.signup.model.SignUpScreenModel
import com.example.view.validation.CustomValidationClass
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val customValidationClass: CustomValidationClass
) : ViewModel() {

    fun validateSignUpForm(signUpScreenModel: SignUpScreenModel): Boolean {
        return customValidationClass.isNameValid(signUpScreenModel.name) &&
                customValidationClass.isEmailValid(signUpScreenModel.email) &&
                customValidationClass.isPasswordValid(signUpScreenModel.password) &&
                customValidationClass.isPasswordValid(signUpScreenModel.confirmPassword) &&
                customValidationClass.isPhoneNumberValid(signUpScreenModel.phoneNumber) &&
                signUpScreenModel.password == signUpScreenModel.confirmPassword
    }

    fun signUp(
        signUpScreenModel: SignUpScreenModel
    ) {
        // Implement sign-up logic here
        // This could involve calling a repository or use case to create a new user account
        // For example:
        // userRepository.createUser(signUpScreenModel)
    }

    sealed class SignUpResult {
        data class Success(val message: String) : SignUpResult()
        data class Error(val message: String) : SignUpResult()
        object Loading : SignUpResult()
        object Idle : SignUpResult()
    }

}