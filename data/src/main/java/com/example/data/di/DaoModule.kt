package com.example.data.di

import com.example.data.localDb.CredentialDao
import com.example.data.localDb.PasswordManagerDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DaoModule {

    @Singleton
    @Provides
    fun provideCredentialDao(database: PasswordManagerDataBase): CredentialDao {
        return database.credentialDao()
    }

}