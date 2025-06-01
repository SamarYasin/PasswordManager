package com.example.domain.repo

import com.example.domain.entity.CredentialRequestEntity

interface UpdateCredentialRepo {
    suspend fun updateCredential(credential: CredentialRequestEntity)
}