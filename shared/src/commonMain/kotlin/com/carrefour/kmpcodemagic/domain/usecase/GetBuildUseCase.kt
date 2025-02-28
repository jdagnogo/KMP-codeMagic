package com.carrefour.kmpcodemagic.domain.usecase

import com.carrefour.kmpcodemagic.domain.CodeMagicRepository
import com.carrefour.kmpcodemagic.domain.models.Build

interface GetBuildUseCase {
    suspend operator fun invoke(id: String): Build?
}

class GetBuildUseCaseImpl(
    private val repository: CodeMagicRepository
) : GetBuildUseCase {
    override suspend fun invoke(id: String): Build? {
        return repository.buildListFlow.value.firstOrNull { it.id == id }
    }
}