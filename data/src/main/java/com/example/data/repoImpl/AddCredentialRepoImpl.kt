package com.example.data.repoImpl

import com.example.data.localDb.CredentialDao
import com.example.data.mapper.map
import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.repo.AddCredentialRepo
import javax.inject.Inject

class AddCredentialRepoImpl @Inject constructor(
    private val credentialDao: CredentialDao
) : AddCredentialRepo {
    /**
     * Adds a new credential to the repository.
     *
     * @param credential The credential to be added.
     * @return True if the addition was successful, false otherwise.
     */
    override suspend fun addCredential(credential: CredentialRequestEntity): Boolean {
        return try {
            credentialDao.insertCredential(credential.map())
            true
        } catch (e: Exception) {
            false
        }
    }

}