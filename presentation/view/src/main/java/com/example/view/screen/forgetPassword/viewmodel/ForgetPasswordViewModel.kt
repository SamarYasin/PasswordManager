package com.example.view.screen.forgetPassword.viewmodel

import androidx.lifecycle.ViewModel
import com.example.view.ForgetPasswordResult
import com.example.view.ForgetPasswordValidationResult
import com.example.view.screen.forgetPassword.model.ForgotPasswordScreenModel
import com.example.view.validation.CustomValidationClass
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class ForgetPasswordViewModel @Inject constructor(
    private val customValidationClass: CustomValidationClass
) : ViewModel() {

    private val _forgotPasswordScreenModel = MutableStateFlow(ForgotPasswordScreenModel())

    private val _validationResult =
        MutableStateFlow<ForgetPasswordValidationResult>(ForgetPasswordValidationResult.Idle)
    val validationResult: Flow<ForgetPasswordValidationResult> get() = _validationResult

    private val _forgotPasswordResult =
        MutableStateFlow<ForgetPasswordResult>(ForgetPasswordResult.Idle)
    val forgotPasswordResult: Flow<ForgetPasswordResult> get() = _forgotPasswordResult

    fun validateForgetPasswordForm(forgetPasswordScreenModel: ForgotPasswordScreenModel) {
        val isValid = customValidationClass.isEmailValid(forgetPasswordScreenModel.email) &&
                customValidationClass.isPhoneNumberValid(forgetPasswordScreenModel.phoneNumber)

        if (isValid){
            _validationResult.value = ForgetPasswordValidationResult.Success("Validation successful")
        } else {
            _validationResult.value = ForgetPasswordValidationResult.Error("Validation failed")
        }

    }

    // TODO: Fix it to handle actual sign-in logic
    fun resetPassword() {
        if (_validationResult.value is ForgetPasswordValidationResult.Success) {
            // Simulate a password reset operation
            _forgotPasswordResult.value = ForgetPasswordResult.Success("Password reset link sent successfully")
        } else {
            _forgotPasswordResult.value = ForgetPasswordResult.Error("Failed to send password reset link")
        }
    }


}