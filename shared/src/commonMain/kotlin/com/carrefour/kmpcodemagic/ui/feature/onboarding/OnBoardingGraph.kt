package com.carrefour.kmpcodemagic.ui.feature.onboarding

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.carrefour.kmpcodemagic.navigation.OnBoarding
import com.carrefour.kmpcodemagic.navigation.OnBoardingPage1

internal fun NavGraphBuilder.onBoardingGraph(
    navigateToMain: () -> Unit
) {
    navigation<OnBoarding>(startDestination = OnBoardingPage1) {
        composable<OnBoardingPage1>(
            enterTransition = {
                slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Left)
            },
            exitTransition = {
                slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Left)
            },
            popEnterTransition = {
                slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)
            },
            popExitTransition = {
                slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Right)
            }
        ) {
            OnBoardingScreen(
                navigateToMain = navigateToMain,
            )
        }
    }
}
