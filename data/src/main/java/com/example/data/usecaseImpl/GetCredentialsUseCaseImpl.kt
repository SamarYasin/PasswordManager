package com.example.data.usecaseImpl

import com.example.domain.entity.CredentialResponseEntity
import com.example.domain.repo.GetCredentialsRepo
import com.example.domain.usecase.GetCredentialsUseCase
import javax.inject.Inject

class GetCredentialsUseCaseImpl @Inject constructor(
    private val getCredentialsRepo: GetCredentialsRepo
) : GetCredentialsUseCase {
    override suspend fun getCredentials(): List<CredentialResponseEntity> {
        return getCredentialsRepo.getCredentials()
    }
}