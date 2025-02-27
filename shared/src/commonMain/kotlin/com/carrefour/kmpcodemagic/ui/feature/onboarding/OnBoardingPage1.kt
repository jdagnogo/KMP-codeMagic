package com.carrefour.kmpcodemagic.ui.feature.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kmp_codemagic.shared.generated.resources.Res
import kmp_codemagic.shared.generated.resources.bg_clouds
import kmp_codemagic.shared.generated.resources.codemagic1
import kmp_codemagic.shared.generated.resources.on_boarding1_subtitle
import kmp_codemagic.shared.generated.resources.on_boarding1_title
import kmp_codemagic.shared.generated.resources.rocket
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun OnBoardingPage1Screen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(22.dp)),
                painter = painterResource(Res.drawable.bg_clouds),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Image(
                modifier = Modifier.align(Alignment.TopStart),
                painter = painterResource(Res.drawable.rocket),
                contentDescription = null
            )
        }

        Spacer(Modifier.padding(16.dp))

        Text(
            text = stringResource(Res.string.on_boarding1_title),
            style = MaterialTheme.typography.displayLarge,
        )

        Spacer(Modifier.padding(8.dp))

        Text(
            text = stringResource(Res.string.on_boarding1_subtitle),
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center,
        )
    }
}