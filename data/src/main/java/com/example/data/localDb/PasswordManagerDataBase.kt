package com.example.data.localDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.BuildConfig
import net.sqlcipher.database.SupportFactory
import net.sqlcipher.database.SQLiteDatabase

@Database(entities = [Credential::class], version = 1, exportSchema = false)
abstract class PasswordManagerDataBase : RoomDatabase() {
    abstract fun credentialDao(): CredentialDao

    companion object {
        @Volatile
        private var INSTANCE: PasswordManagerDataBase? = null

        fun getInstance(context: Context): PasswordManagerDataBase {
            return INSTANCE ?: synchronized(this) {
                val passphrase: ByteArray = SQLiteDatabase.getBytes(
                    BuildConfig.DB_PASSPHRASE.toCharArray())
                val factory = SupportFactory(passphrase)
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PasswordManagerDataBase::class.java,
                    "password_manager_db"
                )
                    .openHelperFactory(factory)
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

}