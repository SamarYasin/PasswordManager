package com.example.data.repoImpl

import com.example.data.localDb.CredentialDao
import com.example.data.mapper.map
import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.repo.DeleteCredentialRepo
import javax.inject.Inject

class DeleteCredentialRepoImpl @Inject constructor(
    private val credentialDao: CredentialDao
) : DeleteCredentialRepo {
    /**
     * Deletes a credential by its ID.
     *
     * @param credential The credential to delete.
     * @return True if the deletion was successful, false otherwise.
     */
    override suspend fun deleteCredential(credential: CredentialRequestEntity): Boolean {
        return try {
            credentialDao.deleteCredential(credential.map())
            true
        } catch (e: Exception) {
            false
        }
    }

}