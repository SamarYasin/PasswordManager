package com.example.data.di

import com.example.data.localDb.room.CredentialDao
import com.example.data.repoImpl.AddCredentialRepoImpl
import com.example.data.repoImpl.DeleteAllCredentialsRepoImpl
import com.example.data.repoImpl.DeleteCredentialRepoImpl
import com.example.data.repoImpl.GetCredentialsRepoImpl
import com.example.data.repoImpl.UpdateCredentialRepoImpl
import com.example.domain.repo.AddCredentialRepo
import com.example.domain.repo.DeleteAllCredentialsRepo
import com.example.domain.repo.DeleteCredentialRepo
import com.example.domain.repo.GetCredentialsRepo
import com.example.domain.repo.UpdateCredentialRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepoModule {

    @Singleton
    @Provides
    fun provideAddCredentialRepo(credentialDao: CredentialDao): AddCredentialRepo {
        return AddCredentialRepoImpl(credentialDao)
    }

    @Singleton
    @Provides
    fun provideDeleteCredentialsRepo(credentialDao: CredentialDao): DeleteCredentialRepo {
        return DeleteCredentialRepoImpl(credentialDao)
    }

    @Singleton
    @Provides
    fun provideGetCredentialsRepo(credentialDao: CredentialDao): GetCredentialsRepo {
        return GetCredentialsRepoImpl(credentialDao)
    }

    @Singleton
    @Provides
    fun provideUpdateCredentialsRepo(credentialDao: CredentialDao): UpdateCredentialRepo {
        return UpdateCredentialRepoImpl(credentialDao)
    }

    @Singleton
    @Provides
    fun provideDeleteAllCredentialsRepo(credentialDao: CredentialDao): DeleteAllCredentialsRepo {
        return DeleteAllCredentialsRepoImpl(credentialDao)
    }

}