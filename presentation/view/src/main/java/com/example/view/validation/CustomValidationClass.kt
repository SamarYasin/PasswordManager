package com.example.view.validation

import javax.inject.Inject

class CustomValidationClass @Inject constructor(

) {

    fun isEmailValid(email: String): Boolean {
        return email.contains("@") && email.contains(".")
    }

    fun isPasswordValid(password: String): Boolean {
        return password.length >= 12 && password.any { it.isDigit() } && password.any { it.isUpperCase() }
    }

    fun isPhoneNumberValid(phoneNumber: String): Boolean {
        return phoneNumber.length == 11 && phoneNumber.all { it.isDigit() }
    }

    fun isNameValid(name: String): Boolean {
        return name.isNotBlank() && name.length in 5..50
    }

    fun isTitleValid(title: String): Boolean {
        return title.isNotBlank() && title.length in 5..100
    }

}