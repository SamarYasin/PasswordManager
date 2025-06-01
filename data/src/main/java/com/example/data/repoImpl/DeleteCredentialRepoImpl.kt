package com.example.data.repoImpl

import com.example.data.localDb.CredentialDao
import com.example.data.mapper.map
import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.repo.DeleteCredentialRepo
import javax.inject.Inject

class DeleteCredentialRepoImpl @Inject constructor(
    private val credentialDao: CredentialDao
) : DeleteCredentialRepo {
    override suspend fun deleteCredential(credential: CredentialRequestEntity) {
        try {
            credentialDao.deleteCredential(credential.map())

        } catch (e: Exception) {
            e.message
        }
    }

}