package com.example.view.screen.signin.viewmodel

import androidx.lifecycle.ViewModel
import com.example.view.screen.signin.model.SignInScreenModel
import com.example.view.screen.signup.model.SignUpScreenModel
import com.example.view.validation.CustomValidationClass
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val customValidationClass: CustomValidationClass
) : ViewModel() {

    fun validateSignInForm(signInScreenModel: SignInScreenModel): Boolean {
        return customValidationClass.isEmailValid(signInScreenModel.email) &&
                customValidationClass.isPasswordValid(signInScreenModel.password)
    }

    fun signIn(signInScreenModel: SignInScreenModel) {
        // Implement sign-in logic here
        // This could involve calling a repository or use case to authenticate the user
    }

    sealed class SignInResult {
        data class Success(val message: String) : SignInResult()
        data class Error(val message: String) : SignInResult()
        object Loading : SignInResult()
        object Idle : SignInResult()
    }

}