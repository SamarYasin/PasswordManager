package com.example.domain.repo

import com.example.domain.entity.CredentialRequestEntity

interface AddCredentialRepo {
    /**
     * Adds a new credential to the repository.
     *
     * @param credential The credential to be added.
     * @return True if the addition was successful, false otherwise.
     */
    suspend fun addCredential(credential: CredentialRequestEntity): Boolean
}