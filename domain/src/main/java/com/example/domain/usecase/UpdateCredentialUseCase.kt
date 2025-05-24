package com.example.domain.usecase

import com.example.domain.entity.CredentialRequestEntity

interface UpdateCredentialUseCase {
    /**
     * Updates an existing credential in the repository.
     *
     * @param credentialId The ID of the credential to be updated.
     * @param newCredentialData The new data for the credential.
     * @return True if the update was successful, false otherwise.
     */
    suspend fun updateCredential(credential : CredentialRequestEntity): Boolean
}