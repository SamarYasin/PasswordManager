package com.example.data.usecaseImpl

import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.repo.UpdateCredentialRepo
import com.example.domain.usecase.UpdateCredentialUseCase
import javax.inject.Inject

class UpdateCredentialUseCaseImpl @Inject constructor(
    private val updateCredentialRepo: UpdateCredentialRepo
) : UpdateCredentialUseCase {

    /**
     * Updates an existing credential in the repository.
     *
     * @param credential The credential to be updated.
     * @return True if the update was successful, false otherwise.
     */
    override suspend fun updateCredential(credential: CredentialRequestEntity): Boolean {
        return updateCredentialRepo.updateCredential(credential)
    }

}