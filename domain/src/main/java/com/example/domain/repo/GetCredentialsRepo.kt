package com.example.domain.repo

import com.example.domain.entity.CredentialResponseEntity

interface GetCredentialsRepo {
    suspend fun getCredentials(): List<CredentialResponseEntity>
}