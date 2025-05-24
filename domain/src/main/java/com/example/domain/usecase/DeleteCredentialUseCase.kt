package com.example.domain.usecase

import com.example.domain.entity.CredentialRequestEntity

interface DeleteCredentialUseCase {
    /**
     * Deletes a credential from the repository.
     *
     * @param credentialId The ID of the credential to be deleted.
     * @return True if the deletion was successful, false otherwise.
     */
    suspend fun deleteCredential(credential : CredentialRequestEntity): Boolean
}