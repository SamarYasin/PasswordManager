package com.example.data.mapper

import com.example.data.localDb.Credential
import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.entity.CredentialResponseEntity

fun CredentialRequestEntity.map(): Credential {
    val credential = Credential()
    credential.entryName = this.entryName
    credential.name = this.name
    credential.email = this.email
    credential.password = this.password
    credential.mobileNumber = this.mobileNumber
    return credential
}

fun Credential.map(): CredentialResponseEntity {
    return CredentialResponseEntity(
        entryName = this.entryName,
        name = this.name,
        password = this.password,
        email = this.email,
        mobileNumber = this.mobileNumber,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt
    )
}