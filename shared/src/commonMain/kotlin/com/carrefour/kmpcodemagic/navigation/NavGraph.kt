package com.carrefour.kmpcodemagic.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.carrefour.kmpcodemagic.ui.feature.home.HomePage
import com.carrefour.kmpcodemagic.ui.feature.onboarding.OnBoardingPage
import com.carrefour.kmpcodemagic.ui.feature.splashscreen.SplashScreenPage

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(200)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(200)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(200)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(200)
            )
        },
    ) {
        composable(
            route = Screen.SplashScreen.route,
        ) {
            SplashScreenPage(navController)
        }
        composable(
            route = Screen.OnBoarding.route,
        ) {
            OnBoardingPage(navController)
        }
        composable(
            route = Screen.Home.route,
        ) {
            HomePage(navController)
        }
    }
}