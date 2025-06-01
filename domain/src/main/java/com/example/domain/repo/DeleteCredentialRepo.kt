package com.example.domain.repo

import com.example.domain.entity.CredentialRequestEntity

interface DeleteCredentialRepo {
    suspend fun deleteCredential(credential: CredentialRequestEntity)
}