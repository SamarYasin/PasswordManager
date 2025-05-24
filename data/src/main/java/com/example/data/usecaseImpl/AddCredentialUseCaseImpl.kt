package com.example.data.usecaseImpl

import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.repo.AddCredentialRepo
import com.example.domain.usecase.AddCredentialUseCase
import javax.inject.Inject

class AddCredentialUseCaseImpl @Inject constructor(
    private val addCredentialRepo: AddCredentialRepo
) : AddCredentialUseCase {
    /**
     * Adds a new credential to the repository.
     *
     * @param credential The credential to be added.
     * @return True if the addition was successful, false otherwise.
     */
    override suspend fun addCredential(credential: CredentialRequestEntity): Boolean {
        return addCredentialRepo.addCredential(credential)
    }

}