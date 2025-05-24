package com.example.data.repoImpl

import com.example.data.localDb.CredentialDao
import com.example.data.mapper.map
import com.example.domain.entity.CredentialResponseEntity
import com.example.domain.repo.GetCredentialsRepo
import javax.inject.Inject

class GetCredentialsRepoImpl @Inject constructor(
    private val credentialDao: CredentialDao
) : GetCredentialsRepo {

    /**
     * Fetches the credentials from the repository.
     *
     * @return A list of credentials.
     */
    override suspend fun getCredentials(): List<CredentialResponseEntity> {
        return try {
            val list = credentialDao.getAllCredentials()
            list.map { it.map() }
        } catch (e: Exception) {
            emptyList()
        }
    }

}