package com.carrefour.kmpcodemagic.ui.feature.onboarding.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carrefour.kmpcodemagic.domain.SetTokenUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class OnBoardingViewModel(private val setTokenUseCase: SetTokenUseCase) : ViewModel() {
    private val _events = Channel<OnBoardingEvents>(1)
    val events = _events.receiveAsFlow()

    fun setToken(token: String) {
        viewModelScope.launch {
            setTokenUseCase(token).onSuccess {
                _events.send(OnBoardingEvents.OnTokenSaved)
            }.onFailure {
                _events.send(OnBoardingEvents.OnTokenFailed)
            }
        }

    }

}