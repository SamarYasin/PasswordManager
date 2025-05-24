package com.example.passwordmanager.di

import com.example.data.usecaseImpl.AddCredentialUseCaseImpl
import com.example.data.usecaseImpl.DeleteCredentialUseCaseImpl
import com.example.data.usecaseImpl.GetCredentialsUseCaseImpl
import com.example.data.usecaseImpl.UpdateCredentialUseCaseImpl
import com.example.domain.repo.AddCredentialRepo
import com.example.domain.repo.DeleteCredentialRepo
import com.example.domain.repo.GetCredentialsRepo
import com.example.domain.repo.UpdateCredentialRepo
import com.example.domain.usecase.AddCredentialUseCase
import com.example.domain.usecase.DeleteCredentialUseCase
import com.example.domain.usecase.GetCredentialsUseCase
import com.example.domain.usecase.UpdateCredentialUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {

    @Provides
    fun provideAddCredentialUseCase(addCredentialRepo: AddCredentialRepo): AddCredentialUseCase {
        return AddCredentialUseCaseImpl(addCredentialRepo)
    }

    @Provides
    fun provideDeleteCredentialsUseCase(deleteCredentialRepo: DeleteCredentialRepo): DeleteCredentialUseCase {
        return DeleteCredentialUseCaseImpl(deleteCredentialRepo)
    }

    @Provides
    fun provideGetCredentialsUseCase(getCredentialsRepo: GetCredentialsRepo): GetCredentialsUseCase {
        return GetCredentialsUseCaseImpl(getCredentialsRepo)
    }

    @Provides
    fun provideUpdateCredentialsUseCase(updateCredentialRepo: UpdateCredentialRepo): UpdateCredentialUseCase {
        return UpdateCredentialUseCaseImpl(updateCredentialRepo)
    }

}