package com.example.domain.repo

import com.example.domain.entity.CredentialResponseEntity

interface GetCredentialsRepo {
    /**
     * Fetches the credentials from the repository.
     *
     * @return A list of credentials.
     */
    suspend fun getCredentials(): List<CredentialResponseEntity>
}