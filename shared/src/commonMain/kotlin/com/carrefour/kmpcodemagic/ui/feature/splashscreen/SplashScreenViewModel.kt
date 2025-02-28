package com.carrefour.kmpcodemagic.ui.feature.splashscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carrefour.kmpcodemagic.domain.usecase.GetTokenUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashScreenViewModel(
    private val getTokenUseCase: GetTokenUseCase
) : ViewModel() {
    private val _token = MutableStateFlow(String())
    val token = _token.asStateFlow()

    init {
        viewModelScope.launch {
            getTokenUseCase().collect {
                _token.value = it
            }
        }
    }
}