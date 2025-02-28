package com.carrefour.kmpcodemagic.domain.usecase

import com.carrefour.kmpcodemagic.domain.TokenRepository

interface SetTokenUseCase {
    suspend operator fun invoke(token: String): Result<Unit>
}

internal class SetTokenUseCaseImpl(private val tokenRepository: TokenRepository) : SetTokenUseCase {
    override suspend fun invoke(token: String): Result<Unit> {
        return tokenRepository.setToken(token)
    }
}