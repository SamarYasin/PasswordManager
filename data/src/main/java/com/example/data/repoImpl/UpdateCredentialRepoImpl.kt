package com.example.data.repoImpl

import com.example.data.localDb.room.CredentialDao
import com.example.data.mapper.updatingMapper
import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.repo.UpdateCredentialRepo
import javax.inject.Inject

class UpdateCredentialRepoImpl @Inject constructor(
    private val credentialDao: CredentialDao
) : UpdateCredentialRepo {
    override suspend fun updateCredential(credential: CredentialRequestEntity) {
        try {
            credentialDao.updateCredential(credential.updatingMapper())
        } catch (e: Exception) {
            e.message
        }
    }

}