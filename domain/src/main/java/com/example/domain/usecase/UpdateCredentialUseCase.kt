package com.example.domain.usecase

import com.example.domain.entity.CredentialRequestEntity

interface UpdateCredentialUseCase {
    suspend fun updateCredential(credential : CredentialRequestEntity)
}