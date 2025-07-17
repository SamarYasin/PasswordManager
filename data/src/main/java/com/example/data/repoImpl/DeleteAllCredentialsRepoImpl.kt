package com.example.data.repoImpl

import com.example.data.localDb.CredentialDao
import com.example.domain.repo.DeleteAllCredentialsRepo
import javax.inject.Inject

class DeleteAllCredentialsRepoImpl @Inject constructor(
    private val credentialDao: CredentialDao
) : DeleteAllCredentialsRepo{
    override suspend fun deleteAllCredential() {
        try {
            credentialDao.deleteAllCredentials()
        }catch (e : Exception) {
            e.message
        }
    }
}