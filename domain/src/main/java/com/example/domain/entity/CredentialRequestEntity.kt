package com.example.domain.entity

data class CredentialRequestEntity(
    var entryName: String = "",
    var password: String = "",
    var email: String = "",
    var mobileNumber: String = ""
)
