package com.carrefour.kmpcodemagic.ui.feature.onboarding.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carrefour.kmpcodemagic.domain.usecase.SetTokenUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class OnBoardingViewModel(private val setTokenUseCase: SetTokenUseCase) : ViewModel() {
    private val _events = Channel<OnBoardingEvents>(1)
    val events = _events.receiveAsFlow()

    val text = MutableStateFlow("")

    fun setToken() {
        val token = text.value

        viewModelScope.launch {
            setTokenUseCase(token).onSuccess {
                _events.send(OnBoardingEvents.OnTokenSaved)
            }.onFailure {
                _events.send(OnBoardingEvents.OnTokenFailed)
            }
        }

    }

    fun onTextChange(text: String) {
        this.text.update { text }
    }

}