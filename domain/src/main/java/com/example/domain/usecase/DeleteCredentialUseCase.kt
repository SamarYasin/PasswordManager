package com.example.domain.usecase

import com.example.domain.entity.CredentialRequestEntity

interface DeleteCredentialUseCase {
    suspend fun deleteCredential(credential : CredentialRequestEntity)
}