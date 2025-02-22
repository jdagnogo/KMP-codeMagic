package com.carrefour.kmpcodemagic

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.carrefour.kmpcodemagic.navigation.NavGraph
import com.carrefour.kmpcodemagic.sharedUi.KmpCodeMagicTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navController: NavHostController = rememberNavController()
    KmpCodeMagicTheme {
        NavGraph(navController = navController)
    }
}