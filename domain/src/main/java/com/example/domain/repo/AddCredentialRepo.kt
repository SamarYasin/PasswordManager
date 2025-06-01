package com.example.domain.repo

import com.example.domain.entity.CredentialRequestEntity

interface AddCredentialRepo {
    suspend fun addCredential(credential: CredentialRequestEntity)
}