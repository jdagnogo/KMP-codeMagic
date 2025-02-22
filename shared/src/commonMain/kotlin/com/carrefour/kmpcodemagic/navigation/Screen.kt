package com.carrefour.kmpcodemagic.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object SplashScreen : Screen("splash_screen")
    object OnBoarding : Screen("on_boarding")
}