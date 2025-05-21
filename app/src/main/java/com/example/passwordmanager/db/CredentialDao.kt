package com.example.passwordmanager.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CredentialDao {

     @Insert
     suspend fun insertCredential(credential: CredentialEntity)

     @Query("SELECT * FROM password_manager_db")
     suspend fun getAllCredentials(): List<CredentialEntity>

     @Delete
     suspend fun deleteCredential(credential: CredentialEntity)

     @Update
     suspend fun updateCredential(credential: CredentialEntity)

}