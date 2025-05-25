package com.example.view.screen.forgetPassword.viewmodel

import androidx.lifecycle.ViewModel
import com.example.view.screen.forgetPassword.model.ForgotPasswordScreenModel
import com.example.view.validation.CustomValidationClass
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgetPasswordViewModel @Inject constructor(
    private val customValidationClass: CustomValidationClass
) : ViewModel(){

    fun validateForgetPasswordForm(forgetPasswordScreenModel: ForgotPasswordScreenModel): Boolean {
        return customValidationClass.isEmailValid(forgetPasswordScreenModel.email) &&
                customValidationClass.isPhoneNumberValid(forgetPasswordScreenModel.phoneNumber)
    }

    // Example function to handle password reset
    fun resetPassword(forgetPasswordScreenModel: ForgotPasswordScreenModel) {
        // Implement password reset logic here
        // This could involve calling a repository or use case to send a reset email
    }

    sealed class ForgetPasswordResult {
        data class Success(val message: String) : ForgetPasswordResult()
        data class Error(val message: String) : ForgetPasswordResult()
        object Loading : ForgetPasswordResult()
        object Idle : ForgetPasswordResult()
    }

}