package com.example.data.localDb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CredentialDao {

     @Insert
     suspend fun insertCredential(credential: Credential)

     @Query("SELECT * FROM password_manager_db")
     suspend fun getAllCredentials(): List<Credential>

     @Delete
     suspend fun deleteCredential(credential: Credential)

     @Update
     suspend fun updateCredential(credential: Credential)

}