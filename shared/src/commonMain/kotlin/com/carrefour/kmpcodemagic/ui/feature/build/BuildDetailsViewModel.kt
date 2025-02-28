package com.carrefour.kmpcodemagic.ui.feature.build

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.carrefour.kmpcodemagic.domain.models.Build
import com.carrefour.kmpcodemagic.domain.usecase.GetBuildUseCase
import com.carrefour.kmpcodemagic.navigation.BuildDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BuildDetailsViewModel(
    private val getBuildDetailsUseCase: GetBuildUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var _buildId = MutableStateFlow(savedStateHandle.toRoute<BuildDetails>().id)

    private val _build = MutableStateFlow(Build())
    val build = _build.asStateFlow()

    init {
        viewModelScope.launch {
            _build.emit(getBuildDetailsUseCase(_buildId.value) ?: Build())
        }
    }
}