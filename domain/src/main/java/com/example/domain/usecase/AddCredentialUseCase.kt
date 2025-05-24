package com.example.domain.usecase

import com.example.domain.entity.CredentialRequestEntity

interface AddCredentialUseCase {
    /**
     * Adds a new credential to the repository.
     *
     * @param credential The credential to be added.
     * @return True if the addition was successful, false otherwise.
     */
    suspend fun addCredential(credential: CredentialRequestEntity): Boolean
}