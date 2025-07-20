package com.example.data.localDb.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.BuildConfig
import net.zetetic.database.sqlcipher.SupportOpenHelperFactory

@Database(entities = [Credential::class], version = 1, exportSchema = false)
abstract class PasswordManagerDataBase : RoomDatabase() {
    abstract fun credentialDao(): CredentialDao

    companion object {
        @Volatile private var INSTANCE: PasswordManagerDataBase? = null

        fun getInstance(context: Context): PasswordManagerDataBase {
            return INSTANCE ?: synchronized(this) {
                val passphrase: ByteArray = BuildConfig.DB_PASSPHRASE.toByteArray(Charsets.UTF_8)
                val factory = SupportOpenHelperFactory(passphrase)
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