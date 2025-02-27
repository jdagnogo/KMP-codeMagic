package com.carrefour.kmpcodemagic.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.carrefour.kmpcodemagic.ui.feature.home.mainGraph
import com.carrefour.kmpcodemagic.ui.feature.onboarding.onBoardingGraph
import com.carrefour.kmpcodemagic.ui.feature.splashscreen.SplashScreenPage

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SplashScreen,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(200)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
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
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(200)
            )
        },
    ) {
        composable<SplashScreen> {
            SplashScreenPage(
                onNavigateToOnBoarding = { navController.navigate(OnBoarding) },
                onNavigateToOnHomePage = { navController.navigate(MainGraph) }
            )
        }

        onBoardingGraph(
            navigateToMain = {
                val navOptions = NavOptions.Builder()
                    .setPopUpTo(route = OnBoarding, inclusive = true)
                    .build()
                navController.navigate(
                    route = MainGraph,
                    navOptions = navOptions,
                )
            }
        )

        mainGraph()
    }
}