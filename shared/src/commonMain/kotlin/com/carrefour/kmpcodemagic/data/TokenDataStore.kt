package com.carrefour.kmpcodemagic.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext


/**
 * A class responsible for storing and retrieving an authentication token using DataStore.
 *
 * This class provides methods to securely store a token and retrieve it later.
 * It utilizes the DataStore API for persistent storage of preferences.
 *
 * @property dataStore The DataStore instance used for storing preferences.
 */
class TokenDataStore(val dataStore: DataStore<Preferences>) {
    private val TOKEN_KEY = "tokenKey"

    fun getToken(): Flow<String> {
        return dataStore.data.map {
            it[stringPreferencesKey(TOKEN_KEY)].orEmpty()
        }.flowOn(Dispatchers.IO)
    }

    suspend fun setToken(token: String): Result<Unit> {
        return withContext(Dispatchers.IO) {
            try {
                dataStore.edit {
                    it[stringPreferencesKey(TOKEN_KEY)] = token
                }
                Result.success(Unit)
            } catch (e: Exception) {
                e.printStackTrace()
                Result.failure(e)
            }
        }
    }
}