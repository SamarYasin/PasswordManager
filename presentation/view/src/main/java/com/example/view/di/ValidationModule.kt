package com.example.view.di

import com.example.view.validation.CustomValidationClass
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object ValidationModule {

    @Provides
    fun provideSignUpValidation(): CustomValidationClass {
        return CustomValidationClass()
    }

}