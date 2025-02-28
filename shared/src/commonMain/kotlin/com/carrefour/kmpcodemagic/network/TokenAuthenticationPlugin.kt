package com.carrefour.kmpcodemagic.network

import com.carrefour.kmpcodemagic.domain.TokenRepository
import io.ktor.client.plugins.api.ClientPlugin
import io.ktor.client.plugins.api.createClientPlugin
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking

class TokenAuthenticationPlugin(
    private val tokenRepository: TokenRepository,
) {

    fun createPlugin(): ClientPlugin<Unit> {
        val token = runBlocking { tokenRepository.getToken().firstOrNull().orEmpty() }

        return createClientPlugin(PLUGIN_NAME) {
            onRequest { request, _ ->
                request.headers.append(TOKEN, token)
            }
        }
    }

    private companion object {
        const val TOKEN = "token"
        const val PLUGIN_NAME = "AuthenticationPlugin"
    }
}