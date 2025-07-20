package com.example.data.localDb.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "password_manager_db")
class Credential {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L

    // TODO: Check if i need mobile number and name
    var entryName: String = ""
    var password: String = ""
    var email: String = ""
    var mobileNumber: String = ""
    var createdAt: Long = 0L
    var updatedAt: Long = 0L
}