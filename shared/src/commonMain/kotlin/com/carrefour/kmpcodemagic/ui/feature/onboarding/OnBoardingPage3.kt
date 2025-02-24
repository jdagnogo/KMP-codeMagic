package com.carrefour.kmpcodemagic.ui.feature.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier

@Composable
fun OnBoardingPage3Screen(onContinue: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = CenterHorizontally) {
        Text("OnBoardingPage3")

        Button(onClick = onContinue){
            Text("Finish")
        }
    }
}