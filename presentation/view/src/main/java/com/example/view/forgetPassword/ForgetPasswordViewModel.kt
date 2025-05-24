package com.example.view.forgetPassword

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ForgetPasswordViewModel @Inject constructor(

) : ViewModel(){
    // ViewModel logic for ForgetPassword can be added here
    // For example, you can handle password reset logic, manage UI state, etc.

    // Example function to handle password reset
    fun resetPassword(email: String) {
        // Implement password reset logic here
        // This could involve calling a repository or use case to send a reset email
    }
}