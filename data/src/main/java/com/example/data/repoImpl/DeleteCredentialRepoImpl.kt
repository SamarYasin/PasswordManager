package com.example.data.repoImpl

import com.example.data.localDb.room.CredentialDao
import com.example.data.mapper.deletingMapper
import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.repo.DeleteCredentialRepo
import javax.inject.Inject

class DeleteCredentialRepoImpl @Inject constructor(
    private val credentialDao: CredentialDao
) : DeleteCredentialRepo {
    override suspend fun deleteCredential(credential: CredentialRequestEntity) {
        try {
            credentialDao.deleteCredential(credential.deletingMapper())
        } catch (e: Exception) {
            e.message
        }
    }

}