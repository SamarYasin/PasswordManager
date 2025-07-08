package com.example.data.mapper

import com.example.data.localDb.Credential
import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.entity.CredentialResponseEntity

fun CredentialRequestEntity.addingMapper(): Credential {
    val credential = Credential()
    credential.entryName = this.entryName
    credential.email = this.email
    credential.password = this.password
    credential.mobileNumber = this.mobileNumber
    credential.createdAt = System.currentTimeMillis()
    credential.updatedAt = System.currentTimeMillis()
    return credential
}

fun CredentialRequestEntity.updatingMapper(): Credential {
    val credential = Credential()
    credential.entryName = this.entryName
    credential.email = this.email
    credential.password = this.password
    credential.mobileNumber = this.mobileNumber
    credential.updatedAt = System.currentTimeMillis()
    return credential
}

fun Credential.listMapper(): CredentialResponseEntity {
    return CredentialResponseEntity(
        entryName = this.entryName,
        password = this.password,
        email = this.email,
        mobileNumber = this.mobileNumber,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt
    )
}

fun CredentialRequestEntity.deletingMapper(): Credential {
    val credential = Credential()
    credential.entryName = this.entryName
    credential.email = this.email
    credential.password = this.password
    credential.mobileNumber = this.mobileNumber
    return credential
}