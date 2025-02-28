package com.carrefour.kmpcodemagic.ui.feature.build

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BuildDetailsPage(
    viewModel: BuildDetailsViewModel = koinViewModel(),
    onBack: () -> Unit
) {
    val build by viewModel.build.collectAsState()
    Scaffold(
        topBar = {
            Text("build Details ${build.toString()}")
        }
    ) {

    }

}