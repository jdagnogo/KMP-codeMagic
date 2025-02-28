package com.carrefour.kmpcodemagic.data.repository

import com.carrefour.kmpcodemagic.data.TokenDataStore
import com.carrefour.kmpcodemagic.domain.TokenRepository
import kotlinx.coroutines.flow.Flow

class TokenRepositoryImpl(private val dataStore: TokenDataStore) : TokenRepository {

    override fun getToken(): Flow<String> {
        return dataStore.getToken()
    }

    override suspend fun setToken(token: String): Result<Unit> {
        return dataStore.setToken(token)
    }
}