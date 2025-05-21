package com.example.passwordmanager.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CredentialEntity::class], version = 1, exportSchema = false)
abstract class PasswordManagerDataBase : RoomDatabase() {
    abstract fun credentialDao(): CredentialDao

    companion object {
        @Volatile
        private var INSTANCE: PasswordManagerDataBase? = null

        fun getInstance(context: android.content.Context): PasswordManagerDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = androidx.room.Room.databaseBuilder(
                    context.applicationContext,
                    PasswordManagerDataBase::class.java,
                    "password_manager_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}