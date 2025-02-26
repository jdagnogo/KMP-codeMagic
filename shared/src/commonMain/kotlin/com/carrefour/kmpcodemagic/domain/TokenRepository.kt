package com.carrefour.kmpcodemagic.domain

import kotlinx.coroutines.flow.Flow

/**
 * Interface for managing and storing authentication tokens.
 *
 * This interface defines the contract for retrieving and setting authentication tokens.
 * Implementations of this interface are responsible for persisting the token securely
 * and providing it when requested.
 */
interface TokenRepository {
    fun getToken(): Flow<String>
    suspend fun setToken(token: String): Result<Unit>
}