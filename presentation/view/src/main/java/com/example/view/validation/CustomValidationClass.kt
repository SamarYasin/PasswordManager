package com.example.view.validation

import com.example.view.validation.model.ValidationModel
import javax.inject.Inject

class CustomValidationClass @Inject constructor(

) {

    fun isEmailValid(email: String): ValidationModel {
        return if (email.contains("@") && email.contains(".")) {
            ValidationModel(true, "Valid email address.")
        } else {
            ValidationModel(false, "Invalid email address.")
        }
    }

    fun isPasswordValid(password: String): ValidationModel {
        return if (password.length >= 12 && password.any { it.isDigit() } && password.any { it.isUpperCase() }) {
            ValidationModel(true, "Valid password.")
        } else {
            ValidationModel(false, "Password must be at least 12 characters, contain a digit and an uppercase letter.")
        }
    }

    fun isPhoneNumberValid(phoneNumber: String): ValidationModel {
        return if (phoneNumber.length == 11 && phoneNumber.all { it.isDigit() }) {
            ValidationModel(true, "Valid phone number.")
        } else {
            ValidationModel(false, "Phone number must be 11 digits.")
        }
    }

    fun isNameValid(name: String): ValidationModel {
        return if (name.isNotBlank() && name.length in 5..50) {
            ValidationModel(true, "Valid name.")
        } else {
            ValidationModel(false, "Name must be 5-50 characters and not blank.")
        }
    }

}