package com.example.data.usecaseImpl

import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.repo.UpdateCredentialRepo
import com.example.domain.usecase.UpdateCredentialUseCase
import javax.inject.Inject

class UpdateCredentialUseCaseImpl @Inject constructor(
    private val updateCredentialRepo: UpdateCredentialRepo
) : UpdateCredentialUseCase {
    override suspend fun updateCredential(credential: CredentialRequestEntity) {
        updateCredentialRepo.updateCredential(credential)
    }
}