package com.carrefour.kmpcodemagic.domain.usecase

import com.carrefour.kmpcodemagic.domain.TokenRepository
import kotlinx.coroutines.flow.Flow

interface GetTokenUseCase {
    operator fun invoke(): Flow<String>
}

internal class GetTokenUseCaseImpl(private val tokenRepository: TokenRepository) : GetTokenUseCase {
    override fun invoke(): Flow<String> {
        return tokenRepository.getToken()
    }
}