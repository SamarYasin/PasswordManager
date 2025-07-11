package com.example.view

sealed interface UiResult {
    data object Idle : UiResult
    data object Loading : UiResult
    data class Success<T>(val data: T) : UiResult
    data class Error<T>(val data: T) : UiResult
}

sealed class SignUpValidationResult : UiResult {
    data class Success(val successMessage: String) : SignUpValidationResult()
    data class Error(val errorModel: String) : SignUpValidationResult()
    data object Loading : SignUpValidationResult()
    data object Idle : SignUpValidationResult()
}

sealed class SignUpResult : UiResult {
    data class Success(val successMessage: String) : SignUpResult()
    data class Error(val errorModel: String) : SignUpResult()
    data object Loading : SignUpResult()
    data object Idle : SignUpResult()
}

sealed class SignInValidationResult : UiResult {
    data class Success(val successMessage: String) : SignInValidationResult()
    data class Error(val errorModel: String) : SignInValidationResult()
    data object Loading : SignInValidationResult()
    data object Idle : SignInValidationResult()
}

sealed class SignInResult : UiResult {
    data class Success(val message: String) : SignInResult()
    data class Error(val message: String) : SignInResult()
    data object Loading : SignInResult()
    data object Idle : SignInResult()
}

sealed class ForgetPasswordValidationResult : UiResult {
    data class Success(val message: String) : ForgetPasswordValidationResult()
    data class Error(val message: String) : ForgetPasswordValidationResult()
    data object Loading : ForgetPasswordValidationResult()
    data object Idle : ForgetPasswordValidationResult()
}

sealed class ForgetPasswordResult : UiResult {
    data class Success(val message: String) : ForgetPasswordResult()
    data class Error(val message: String) : ForgetPasswordResult()
    data object Loading : ForgetPasswordResult()
    data object Idle : ForgetPasswordResult()
}

sealed class AddEntryValidationResult : UiResult {
    data class Success(val message: String) : AddEntryValidationResult()
    data class Error(val message: String) : AddEntryValidationResult()
    data object Loading : AddEntryValidationResult()
    data object Idle : AddEntryValidationResult()
}

sealed class AddEntryResult : UiResult {
    data class Success(val message: String) : AddEntryResult()
    data class Error(val message: String) : AddEntryResult()
    data object Loading : AddEntryResult()
    data object Idle : AddEntryResult()
}

sealed class EditEntryValidationResult : UiResult {
    data class Success(val message: String) : EditEntryValidationResult()
    data class Error(val message: String) : EditEntryValidationResult()
    data object Loading : EditEntryValidationResult()
    data object Idle : EditEntryValidationResult()
}

sealed class EditEntryResult : UiResult {
    data class Success(val message: String) : EditEntryResult()
    data class Error(val message: String) : EditEntryResult()
    data object Loading : EditEntryResult()
    data object Idle : EditEntryResult()
}

sealed class DeleteEntryResult : UiResult {
    data class Success(val message: String) : DeleteEntryResult()
    data class Error(val message: String) : DeleteEntryResult()
    data object Loading : DeleteEntryResult()
    data object Idle : DeleteEntryResult()
}