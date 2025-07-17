package com.example.view.screen.setting.model

data class CredentialModel(
    var entryName: String = "",
    var password: String = "",
    var email: String = "",
    var mobileNumber: String = "",
    var createdAt: Long = 0L,
    var updatedAt: Long = 0L
)