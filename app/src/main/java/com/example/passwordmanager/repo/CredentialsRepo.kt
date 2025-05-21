package com.example.passwordmanager.repo

import com.example.passwordmanager.db.CredentialDao
import com.example.passwordmanager.db.CredentialEntity
import javax.inject.Inject

class CredentialsRepo @Inject constructor(
    private val credentialDao: CredentialDao
) {

    suspend fun insertCredential(credential: CredentialEntity) {
        credentialDao.insertCredential(credential)
    }

    suspend fun deleteCredential(credential: CredentialEntity) {
        credentialDao.deleteCredential(credential)
    }

    suspend fun updateCredential(credential: CredentialEntity) {
        credentialDao.updateCredential(credential)
    }

    suspend fun getAllCredentials(): List<CredentialEntity> {
        return credentialDao.getAllCredentials()
    }

}