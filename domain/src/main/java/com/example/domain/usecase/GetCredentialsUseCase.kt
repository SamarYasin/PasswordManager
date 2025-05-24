package com.example.domain.usecase

import com.example.domain.entity.CredentialResponseEntity

interface GetCredentialsUseCase {
    /**
     * Retrieves a list of credentials from the repository.
     *
     * @return A list of credentials.
     */
    suspend fun getCredentials(): List<CredentialResponseEntity>
}