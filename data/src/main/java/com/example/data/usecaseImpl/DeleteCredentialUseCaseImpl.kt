package com.example.data.usecaseImpl

import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.repo.DeleteCredentialRepo
import com.example.domain.usecase.DeleteCredentialUseCase
import javax.inject.Inject

class DeleteCredentialUseCaseImpl @Inject constructor(
    private val deleteCredentialRepo: DeleteCredentialRepo
) : DeleteCredentialUseCase {
    override suspend fun deleteCredential(credential: CredentialRequestEntity) {
        deleteCredentialRepo.deleteCredential(credential)
    }
}