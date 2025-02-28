package com.carrefour.kmpcodemagic.sharedUi.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.carrefour.kmpcodemagic.domain.models.Build

@Composable
fun BuildComponent(
    modifier: Modifier = Modifier,
    build: Build,
    onClick: (id: String) -> Unit,
) {
    Column(modifier = modifier.clickable { onClick(build.id) }) {
        Text(build.name)
        Text(build.author)
    }
}