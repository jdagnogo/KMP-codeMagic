package com.carrefour.kmpcodemagic.domain.usecase

import com.carrefour.kmpcodemagic.domain.CodeMagicRepository
import com.carrefour.kmpcodemagic.domain.models.Build
import kotlinx.coroutines.flow.Flow

interface ObserveBuildListUseCase {
    suspend operator fun invoke(): Flow<List<Build>>
}

internal class ObserveBuildListUseCaseImpl(private val codeMagicRepository: CodeMagicRepository) :
    ObserveBuildListUseCase {
    override suspend fun invoke(): Flow<List<Build>> {
        return codeMagicRepository.buildListFlow
    }
}