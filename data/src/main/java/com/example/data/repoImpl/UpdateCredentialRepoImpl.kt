package com.example.data.repoImpl

import com.example.data.localDb.CredentialDao
import com.example.data.mapper.map
import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.repo.UpdateCredentialRepo
import javax.inject.Inject

class UpdateCredentialRepoImpl @Inject constructor(
    private val credentialDao: CredentialDao
) : UpdateCredentialRepo {

    /**
     * Updates an existing credential in the repository.
     *
     * @param credential The credential to be updated.
     * @return True if the update was successful, false otherwise.
     */
    override suspend fun updateCredential(credential: CredentialRequestEntity): Boolean {
        return try {
            credentialDao.updateCredential(credential.map())
            true
        } catch (e: Exception) {
            false
        }
    }

}