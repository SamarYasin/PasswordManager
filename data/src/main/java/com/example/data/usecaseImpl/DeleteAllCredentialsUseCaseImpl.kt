package com.example.data.usecaseImpl

import com.example.domain.repo.DeleteAllCredentialsRepo
import com.example.domain.usecase.DeleteAllCredentialsUseCase
import javax.inject.Inject

class DeleteAllCredentialsUseCaseImpl @Inject constructor(
    private val deleteAllCredentialRepo: DeleteAllCredentialsRepo
) : DeleteAllCredentialsUseCase {
    override suspend fun deleteAllCredential() {
        deleteAllCredentialRepo.deleteAllCredential()
    }
}