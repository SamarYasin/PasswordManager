package com.example.view.signup

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(

) : ViewModel(){

    fun signUp(
        name: String,
        email: String,
        password: String,
        repeatPassword: String
    ) {
        // Implement sign-up logic here
    }

}