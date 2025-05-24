package com.example.domain.entity

data class CredentialResponseEntity(
    var entryName: String = "",
    var name: String = "",
    var password: String = "",
    var email: String = "",
    var mobileNumber: String = "",
    var createdAt: Long = 0L,
    var updatedAt: Long = 0L
)
