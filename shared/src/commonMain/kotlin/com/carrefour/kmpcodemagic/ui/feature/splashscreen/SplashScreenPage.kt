package com.carrefour.kmpcodemagic.ui.feature.splashscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SplashScreenPage(
    onNavigateToOnBoarding: () -> Unit,
) {
    LaunchedEffect(Unit) {
        delay(2000)  // the delay of 2 seconds
        onNavigateToOnBoarding()
    }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        //Image with logo
        Text("Hello")
    }

}

@Preview
@Composable
private fun SplashScreenPagePreview() {
    SplashScreenPage(onNavigateToOnBoarding = {})
}
