package com.carrefour.kmpcodemagic.ui.feature.onboarding.viewmodels

sealed interface OnBoardingEvents {
    data object OnTokenSaved : OnBoardingEvents
    data object OnTokenFailed : OnBoardingEvents
}