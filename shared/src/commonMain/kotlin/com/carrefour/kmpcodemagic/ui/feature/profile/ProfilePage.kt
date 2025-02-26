package com.carrefour.kmpcodemagic.ui.feature.profile

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.sp
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProfilePage(
    viewModel: ProfileViewModel = koinViewModel(),
) {
    val token by viewModel.token.collectAsState()
    ProfileScreen(token)
}

@Composable
private fun ProfileScreen(token: String) {
    Text(token, fontSize = 30.sp)
}