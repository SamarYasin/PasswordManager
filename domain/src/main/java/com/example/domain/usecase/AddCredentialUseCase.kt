package com.example.domain.usecase

import com.example.domain.entity.CredentialRequestEntity

interface AddCredentialUseCase {
    suspend fun addCredential(credential: CredentialRequestEntity)
}