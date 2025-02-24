package com.carrefour.kmpcodemagic.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

/**
 * Full screen pages
 */
@Serializable data object MainGraph
@Serializable data object SplashScreen
@Serializable data object OnBoarding

/**
 * Screen For the Onboarding
 */
@Serializable data object OnBoardingPage1
@Serializable data object OnBoardingPage2
@Serializable data object OnBoardingPage3

/**
 * Screen with the bottomNav
 */
@Serializable data object Home
@Serializable data object Builds
@Serializable data object Maps
@Serializable data object Profile

data class TopLevelRoute<T : Any>(val name: String, val route: T, val icon: ImageVector)

val topLevelRoutes = listOf(
    TopLevelRoute("Home", Home, Icons.Filled.Home),
    TopLevelRoute("Builds", Builds, Icons.Filled.Search),
    TopLevelRoute("Maps", Maps, Icons.Filled.Search),
    TopLevelRoute("Profile", Profile, Icons.Filled.Search),
)


