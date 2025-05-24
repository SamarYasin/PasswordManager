package com.example.data.mapper

import com.example.data.localDb.Credential
import com.example.domain.entity.CredentialRequestEntity
import com.example.domain.entity.CredentialResponseEntity

fun CredentialRequestEntity.map(): Credential {
    return Credential(

    )
}

fun Credential.map(): CredentialResponseEntity {
    return CredentialResponseEntity(

    )
}