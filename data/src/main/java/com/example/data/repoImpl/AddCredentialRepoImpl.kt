package com.example.data.repoImpl

import com.example.data.localDb.room.CredentialDao
import com.example.data.mapper.addingMapper
import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.repo.AddCredentialRepo
import javax.inject.Inject

class AddCredentialRepoImpl @Inject constructor(
    private val credentialDao: CredentialDao
) : AddCredentialRepo {
    override suspend fun addCredential(credential: CredentialRequestEntity) {
        try {
            credentialDao.insertCredential(credential.addingMapper())
        } catch (e: Exception) {
            e.message
        }
    }

}