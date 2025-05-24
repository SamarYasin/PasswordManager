package com.example.data.di

import com.example.data.localDb.CredentialDao
import com.example.data.repoImpl.AddCredentialRepoImpl
import com.example.data.repoImpl.DeleteCredentialRepoImpl
import com.example.data.repoImpl.GetCredentialsRepoImpl
import com.example.data.repoImpl.UpdateCredentialRepoImpl
import com.example.domain.repo.AddCredentialRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object RepoModule {

    @Provides
    fun provideAddCredentialRepo(credentialDao: CredentialDao): AddCredentialRepo {
        return AddCredentialRepoImpl(credentialDao)
    }

    @Provides
    fun provideDeleteCredentialsRepo(credentialDao: CredentialDao): DeleteCredentialRepoImpl {
        return DeleteCredentialRepoImpl(credentialDao)
    }

    @Provides
    fun provideGetCredentialsRepo(credentialDao: CredentialDao): GetCredentialsRepoImpl {
        return GetCredentialsRepoImpl(credentialDao)
    }

    @Provides
    fun provideUpdateCredentialsRepo(credentialDao: CredentialDao): UpdateCredentialRepoImpl {
        return UpdateCredentialRepoImpl(credentialDao)
    }

}