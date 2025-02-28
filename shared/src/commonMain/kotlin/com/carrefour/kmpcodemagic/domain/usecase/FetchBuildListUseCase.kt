package com.carrefour.kmpcodemagic.domain.usecase

import com.carrefour.kmpcodemagic.domain.CodeMagicRepository

interface FetchBuildListUseCase {
    suspend operator fun invoke(): Result<Unit>
}

internal class FetchBuildListUseCaseImpl(private val codeMagicRepository: CodeMagicRepository) :
    FetchBuildListUseCase {
    override suspend fun invoke(): Result<Unit> {
        return codeMagicRepository.fetchBuildList()
    }
}