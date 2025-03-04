package com.carrefour.kmpcodemagic.ui.feature.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.carrefour.kmpcodemagic.navigation.BuildDetails
import com.carrefour.kmpcodemagic.navigation.Builds
import com.carrefour.kmpcodemagic.navigation.Home
import com.carrefour.kmpcodemagic.navigation.MainGraph
import com.carrefour.kmpcodemagic.navigation.Maps
import com.carrefour.kmpcodemagic.navigation.Profile
import com.carrefour.kmpcodemagic.navigation.topLevelRoutes
import com.carrefour.kmpcodemagic.ui.feature.build.BuildDetailsPage
import com.carrefour.kmpcodemagic.ui.feature.build.BuildListPage
import com.carrefour.kmpcodemagic.ui.feature.map.MapPage
import com.carrefour.kmpcodemagic.ui.feature.profile.ProfilePage


internal fun NavGraphBuilder.mainGraph() {
    composable<MainGraph> {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = {
                NavigationBar {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    topLevelRoutes.forEach { topLevelRoute ->
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    topLevelRoute.icon,
                                    contentDescription = topLevelRoute.name
                                )
                            },
                            label = { Text(topLevelRoute.name) },
                            selected = currentDestination?.hierarchy?.any {
                                it.hasRoute(
                                    topLevelRoute.route::class
                                )
                            } == true,
                            onClick = {
                                navController.navigate(topLevelRoute.route) {
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    // on the back stack as users select items
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        ) { innerPadding ->
            NavHost(navController, startDestination = Home, Modifier.padding(innerPadding)) {
                composable<Home> { HomePage() }
                composable<BuildDetails> { BuildDetailsPage(onBack = { navController.popBackStack() }) }
                composable<Builds> {
                    BuildListPage(
                        onNavigateToBuildDetails = { id ->
                            navController.navigate(BuildDetails(id))
                        }
                    )
                }
                composable<Maps> { MapPage() }
                composable<Profile> { ProfilePage() }
            }
        }
    }
}