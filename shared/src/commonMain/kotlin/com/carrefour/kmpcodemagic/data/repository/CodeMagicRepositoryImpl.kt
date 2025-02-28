package com.carrefour.kmpcodemagic.data.repository

import com.carrefour.kmpcodemagic.data.mapper.toDomain
import com.carrefour.kmpcodemagic.domain.CodeMagicRepository
import com.carrefour.kmpcodemagic.domain.TokenRepository
import com.carrefour.kmpcodemagic.domain.models.Build
import com.carrefour.kmpcodemagic.network.CodeMagicApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull

class CodeMagicRepositoryImpl(
    private val codeMagicApi: CodeMagicApi,
    private val tokenRepository: TokenRepository,
) : CodeMagicRepository {
    private val _buildListFlow: MutableStateFlow<List<Build>> = MutableStateFlow(emptyList())
    override val buildListFlow: StateFlow<List<Build>> = _buildListFlow.asStateFlow()

    override suspend fun fetchBuildList(): Result<Unit> {
        val token = tokenRepository.getToken().firstOrNull() ?: return Result.failure(Throwable())
        val response = codeMagicApi.getBuildList(token)
        val buildList = response.toDomain()
        _buildListFlow.emit(buildList)
        return if (response.isSuccess) {
            Result.success(Unit)
        }else{
            Result.failure(Throwable())
        }
    }
}