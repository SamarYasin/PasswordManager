package com.example.data.repoImpl

import com.example.data.localDb.room.CredentialDao
import com.example.data.mapper.listMapper
import com.example.domain.entity.CredentialResponseEntity
import com.example.domain.repo.GetCredentialsRepo
import javax.inject.Inject

class GetCredentialsRepoImpl @Inject constructor(
    private val credentialDao: CredentialDao
) : GetCredentialsRepo {
    override suspend fun getCredentials(): List<CredentialResponseEntity> {
        return try {
            val list = credentialDao.getAllCredentials()
            list.map { it.listMapper() }
        } catch (e: Exception) {
            emptyList()
        }
    }

}