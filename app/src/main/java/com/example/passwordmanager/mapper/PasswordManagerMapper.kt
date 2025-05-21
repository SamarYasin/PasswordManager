package com.example.passwordmanager.mapper

import com.example.passwordmanager.db.CredentialEntity
import com.example.passwordmanager.model.EntryModel

fun CredentialEntity.map(): EntryModel {
    return EntryModel(
        id = this.id,
        title = this.entryName,
        username = this.name,
        password = this.password,
        email = this.email,
        mobileNumber = this.mobileNumber,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt
    )
}

fun EntryModel.map(): CredentialEntity {
    return CredentialEntity().apply {
        id = this@map.id
        entryName = this@map.title
        name = this@map.username
        password = this@map.password
        email = this@map.email
        mobileNumber = this@map.mobileNumber
        createdAt = this@map.createdAt
        updatedAt = this@map.updatedAt
    }
}