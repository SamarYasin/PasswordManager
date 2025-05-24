package com.example.domain.repo

import com.example.domain.entity.CredentialRequestEntity

interface DeleteCredentialRepo {
    /**
     * Deletes a credential by its ID.
     *
     * @param credentialId The ID of the credential to delete.
     * @return True if the deletion was successful, false otherwise.
     */
    suspend fun deleteCredential(credential: CredentialRequestEntity): Boolean
}