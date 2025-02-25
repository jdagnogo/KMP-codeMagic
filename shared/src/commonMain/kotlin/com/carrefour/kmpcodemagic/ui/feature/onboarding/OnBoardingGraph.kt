package com.carrefour.kmpcodemagic.ui.feature.onboarding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.carrefour.kmpcodemagic.navigation.OnBoarding
import com.carrefour.kmpcodemagic.navigation.OnBoardingPage1
import com.carrefour.kmpcodemagic.navigation.OnBoardingPage2
import com.carrefour.kmpcodemagic.navigation.OnBoardingPage3

internal fun NavGraphBuilder.onBoardingGraph(
    navHostController: NavHostController,
    onContinue: () -> Unit
) {
    navigation<OnBoarding>(startDestination = OnBoardingPage1) {
        composable<OnBoardingPage1> {
            OnBoardingPage1Screen(onContinue = { navHostController.navigate(OnBoardingPage2) })
        }

        composable<OnBoardingPage2> {
            OnBoardingPage2Screen(
                onBack = { navHostController.navigate(OnBoardingPage1) },
                onContinue = { navHostController.navigate(OnBoardingPage3) })
        }

        composable<OnBoardingPage3> {
            OnBoardingPage3Screen(
                onBack = { navHostController.navigate(OnBoardingPage2) },
                onContinue = onContinue)
        }
    }
}
