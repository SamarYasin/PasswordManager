package com.example.passwordmanager.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "password_manager_db")
class CredentialEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L

    // TODO: Check if i need mobile number and name
    var entryName: String = ""
    var name: String = ""
    var password: String = ""
    var email: String = ""
    var mobileNumber: String = ""
    var createdAt: Long = System.currentTimeMillis()
    var updatedAt: Long = System.currentTimeMillis()
}