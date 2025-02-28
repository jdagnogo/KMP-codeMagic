package com.carrefour.kmpcodemagic.domain

import com.carrefour.kmpcodemagic.domain.models.Build
import kotlinx.coroutines.flow.StateFlow

interface CodeMagicRepository {
    val buildListFlow: StateFlow<List<Build>>
    suspend fun fetchBuildList(): Result<Unit>
}