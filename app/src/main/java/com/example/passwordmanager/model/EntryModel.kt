package com.example.passwordmanager.model

data class EntryModel(
    var id: Long = 0L,
    var title: String = "",
    var username: String = "",
    var password: String = "",
    var email : String = "",
    var mobileNumber : String = "",
    var createdAt: Long = System.currentTimeMillis(),
    var updatedAt: Long = System.currentTimeMillis()
)
