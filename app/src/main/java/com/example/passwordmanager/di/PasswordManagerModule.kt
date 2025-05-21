package com.example.passwordmanager.di

import android.content.Context
import androidx.room.Room
import com.example.passwordmanager.db.CredentialDao
import com.example.passwordmanager.db.PasswordManagerDataBase
import com.example.passwordmanager.repo.CredentialsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): PasswordManagerDataBase {
        return Room.databaseBuilder(
            context,
            PasswordManagerDataBase::class.java,
            "password-manager-db"
        ).build()
    }

    @Provides
    fun provideCredentialDao(database: PasswordManagerDataBase): CredentialDao {
        return database.credentialDao()
    }

    @Provides
    fun provideCredentialsRepo(credentialDao: CredentialDao): CredentialsRepo {
        return CredentialsRepo(credentialDao)
    }

}