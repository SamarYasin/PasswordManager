package com.example.domain.repo

import com.example.domain.entity.CredentialRequestEntity

interface UpdateCredentialRepo {
    /**
     * Updates an existing credential in the repository.
     *
     * @param credential The credential to be updated.
     * @return True if the update was successful, false otherwise.
     */
    suspend fun updateCredential(credential: CredentialRequestEntity): Boolean
}