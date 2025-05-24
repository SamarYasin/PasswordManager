package com.example.data.usecaseImpl

import com.example.domain.entity.CredentialResponseEntity
import com.example.domain.repo.GetCredentialsRepo
import com.example.domain.usecase.GetCredentialsUseCase
import javax.inject.Inject

class GetCredentialsUseCaseImpl @Inject constructor(
    private val getCredentialsRepo: GetCredentialsRepo
) : GetCredentialsUseCase {

    /**
     * Fetches the credentials from the repository.
     *
     * @return A list of credentials.
     */
    override suspend fun getCredentials(): List<CredentialResponseEntity> {
        return getCredentialsRepo.getCredentials()
    }

}