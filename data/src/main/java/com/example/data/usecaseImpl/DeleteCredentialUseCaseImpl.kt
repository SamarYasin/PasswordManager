package com.example.data.usecaseImpl

import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.repo.DeleteCredentialRepo
import com.example.domain.usecase.DeleteCredentialUseCase
import javax.inject.Inject

class DeleteCredentialUseCaseImpl @Inject constructor(
    private val deleteCredentialRepo: DeleteCredentialRepo
) : DeleteCredentialUseCase {

    /**
     * Deletes a credential by its ID.
     *
     * @param credential The credential to delete.
     * @return True if the deletion was successful, false otherwise.
     */
    override suspend fun deleteCredential(credential: CredentialRequestEntity): Boolean {
        return deleteCredentialRepo.deleteCredential(credential)
    }
}