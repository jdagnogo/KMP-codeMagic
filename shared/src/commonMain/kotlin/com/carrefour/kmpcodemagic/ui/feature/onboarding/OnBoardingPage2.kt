package com.carrefour.kmpcodemagic.ui.feature.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carrefour.kmpcodemagic.sharedUi.theme.backgroundBlue
import com.carrefour.kmpcodemagic.sharedUi.theme.onBoardingSubTitle
import com.carrefour.kmpcodemagic.sharedUi.theme.onBoardingTitle
import kmp_codemagic.shared.generated.resources.Res
import kmp_codemagic.shared.generated.resources.on_boarding1_subtitle
import kmp_codemagic.shared.generated.resources.on_boarding1_title
import kmp_codemagic.shared.generated.resources.on_boarding2_subtitle
import kmp_codemagic.shared.generated.resources.on_boarding2_title
import kmp_codemagic.shared.generated.resources.on_boarding_back
import kmp_codemagic.shared.generated.resources.on_boarding_next
import kmp_codemagic.shared.generated.resources.on_boarding_page_1
import kmp_codemagic.shared.generated.resources.on_boarding_page_2
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun OnBoardingPage2Screen(onContinue: () -> Unit, onBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().background(backgroundBlue)
            .padding(16.dp),
        horizontalAlignment = CenterHorizontally
    ) {
        Image(
            modifier = Modifier.height(400.dp),
            painter = painterResource(Res.drawable.on_boarding_page_2),
            contentDescription = null
        )

        Spacer(Modifier.padding(16.dp))

        Text(
            text = stringResource(Res.string.on_boarding2_title),
            style = onBoardingTitle
        )

        Spacer(Modifier.padding(8.dp))

        Text(
            text = stringResource(Res.string.on_boarding2_subtitle),
            style = onBoardingSubTitle
        )

        Spacer(Modifier.weight(1f))

        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            TextButton(onClick = onBack) {
                Text(
                    text = stringResource(Res.string.on_boarding_back),
                    style = onBoardingSubTitle
                )
            }
            Spacer(Modifier.weight(1f))
            Button(
                onClick = onContinue
            ) {
                Text(
                    text = stringResource(Res.string.on_boarding_next),
                    fontSize = 24.sp
                )
            }
        }
    }
}