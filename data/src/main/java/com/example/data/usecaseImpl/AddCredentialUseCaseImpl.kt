package com.example.data.usecaseImpl

import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.repo.AddCredentialRepo
import com.example.domain.usecase.AddCredentialUseCase
import javax.inject.Inject

class AddCredentialUseCaseImpl @Inject constructor(
    private val addCredentialRepo: AddCredentialRepo
) : AddCredentialUseCase {
    override suspend fun addCredential(credential: CredentialRequestEntity) {
        addCredentialRepo.addCredential(credential)
    }
}