package com.example.domain.usecase

import com.example.domain.entity.CredentialResponseEntity

interface GetCredentialsUseCase {
    suspend fun getCredentials(): List<CredentialResponseEntity>
}