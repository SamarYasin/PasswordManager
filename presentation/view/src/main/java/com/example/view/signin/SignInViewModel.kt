package com.example.view.signin

import android.view.View
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(

) : ViewModel(){
    // ViewModel logic for SignIn can be added here
    // For example, you can handle sign-in logic, manage UI state, etc.

    // Example function to handle sign-in
    fun signIn(email: String, password: String) {
        // Implement sign-in logic here
        // This could involve calling a repository or use case to authenticate the user
    }
}