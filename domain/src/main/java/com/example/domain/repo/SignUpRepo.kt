package com.example.domain.repo

interface SignUpRepo {
    suspend fun signUp(
        entryName: String,
        password: String,
        email: String,
        mobileNumber: String
    )
}