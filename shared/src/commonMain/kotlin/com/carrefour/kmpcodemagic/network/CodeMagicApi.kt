package com.carrefour.kmpcodemagic.network

import com.carrefour.kmpcodemagic.network.dto.CodeMagicResponse
import com.carrefour.kmpcodemagic.utils.Constants.APPLICATION_JSON
import com.carrefour.kmpcodemagic.utils.Constants.AUTH_TOKEN
import com.carrefour.kmpcodemagic.utils.Constants.BASE_URL
import com.carrefour.kmpcodemagic.utils.Constants.CONTENT_TYPE
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.headers
import io.ktor.client.request.request
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.URLProtocol
import io.ktor.http.path

interface CodeMagicApi {
    suspend fun getBuildList(token: String): Result<CodeMagicResponse>
}

class CodeMagicApiImpl(private val httpClient: HttpClient) : CodeMagicApi {
    companion object {
    private const val PATH = "/builds"
    private const val APP_ID = "appId"
    private const val APP_ID_VALUE = "668d15ad7b43c9b6b8182f91"
    }

    override suspend fun getBuildList(token: String): Result<CodeMagicResponse> {
        return try {
            val request = httpClient.request {
                method = HttpMethod.Get
                headers {
                    append(AUTH_TOKEN, token)
                    append(CONTENT_TYPE, APPLICATION_JSON)
                }
                url {
                    protocol = URLProtocol.HTTPS
                    host = BASE_URL
                    path(PATH)
                    parameters.append(APP_ID, APP_ID_VALUE)
                }
            }
            if (request.status == HttpStatusCode.OK) {
                Result.success(request.body<CodeMagicResponse>())
            } else {
                Result.failure(Throwable())
            }

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}