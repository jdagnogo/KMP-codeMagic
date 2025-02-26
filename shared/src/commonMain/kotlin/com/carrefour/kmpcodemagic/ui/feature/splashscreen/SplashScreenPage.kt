package com.carrefour.kmpcodemagic.ui.feature.splashscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SplashScreenPage(
    viewModel: SplashScreenViewModel = koinViewModel(),
    onNavigateToOnBoarding: () -> Unit,
    onNavigateToOnHomePage: () -> Unit
) {
    val token by viewModel.token.collectAsState()

    SplashScreen(
        onContinue = {
            if (token.isEmpty()) {
                onNavigateToOnBoarding()
            } else {
                onNavigateToOnHomePage()
            }
        }
    )
}

@Composable
private fun SplashScreen(
    onContinue: () -> Unit,
) {
    LaunchedEffect(Unit) {
        delay(2000)  // the delay of 2 seconds
        onContinue()
    }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        //Image with logo
        Text("hello")
    }
}

@Preview
@Composable
private fun SplashScreenPagePreview() {
    SplashScreen(onContinue = {})
}
