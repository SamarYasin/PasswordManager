package com.example.data.localDb.sharedPref

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AppSharedPref @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val appSharedPref: SharedPreferences

    init {
        @Suppress("DEPRECATION")
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        @Suppress("DEPRECATION")
        appSharedPref = EncryptedSharedPreferences.create(
            "secure_app_shared_pref",
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    fun putString(key: String, value: String) {
        appSharedPref.edit().putString(key, value).apply()
    }

    fun getString(key: String, defaultValue: String? = null): String? {
        return appSharedPref.getString(key, defaultValue)
    }

    fun putBoolean(key: String, value: Boolean) {
        appSharedPref.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return appSharedPref.getBoolean(key, defaultValue)
    }

    fun putInt(key: String, value: Int) {
        appSharedPref.edit().putInt(key, value).apply()
    }

    fun getInt(key: String, defaultValue: Int = 0): Int {
        return appSharedPref.getInt(key, defaultValue)
    }

    fun clear() {
        appSharedPref.edit().clear().apply()
    }
}