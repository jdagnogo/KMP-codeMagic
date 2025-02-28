package com.carrefour.kmpcodemagic.data.mapper

import com.carrefour.kmpcodemagic.domain.models.Build
import com.carrefour.kmpcodemagic.domain.models.Status
import com.carrefour.kmpcodemagic.network.dto.CodeMagicResponse
import com.carrefour.kmpcodemagic.network.dto.DTOBuild

fun Result<CodeMagicResponse>.toDomain(): List<Build> {
    return if (isSuccess) {
        getOrNull()?.builds?.map { it.toDomain() } ?: emptyList()
    } else {
        emptyList()
    }
}

fun DTOBuild.toDomain(): Build {
    return Build(
        id = this.id ?: "",
        name = this.version ?: "",
        author = this.commit?.authorName ?: "",
        branch = this.branch ?: "",
        commit = this.commit?.commitMessage ?: "",
        url = this.commit?.url ?: "",
        status = this.status.toDomain(),
    )
}

fun String?.toDomain(): Status {
    return when (this) {
        "finished" -> Status.finished
        "canceled" -> Status.canceled
        else -> Status.progress
    }
}