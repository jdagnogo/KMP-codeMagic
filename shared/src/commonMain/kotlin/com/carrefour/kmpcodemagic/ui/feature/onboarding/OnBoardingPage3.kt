package com.carrefour.kmpcodemagic.ui.feature.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carrefour.kmpcodemagic.sharedUi.theme.backgroundBlue
import com.carrefour.kmpcodemagic.sharedUi.theme.onBoardingSubTitle
import com.carrefour.kmpcodemagic.sharedUi.theme.onBoardingTitle
import com.carrefour.kmpcodemagic.ui.feature.onboarding.viewmodels.OnBoardingEvents
import com.carrefour.kmpcodemagic.ui.feature.onboarding.viewmodels.OnBoardingViewModel
import com.carrefour.kmpcodemagic.utils.LaunchedEffectWithLifecycle
import kmp_codemagic.shared.generated.resources.Res
import kmp_codemagic.shared.generated.resources.on_boarding3_subtitle
import kmp_codemagic.shared.generated.resources.on_boarding3_title
import kmp_codemagic.shared.generated.resources.on_boarding_next
import kmp_codemagic.shared.generated.resources.on_boarding_page_3
import kmp_codemagic.shared.generated.resources.on_boarding_save
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun OnBoardingPage3Screen(
    viewModel: OnBoardingViewModel = koinViewModel(),
    onContinue: () -> Unit
) {

    LaunchedEffectWithLifecycle(flow = viewModel.events) { event ->
        when (event) {
            OnBoardingEvents.OnTokenFailed -> {
                //TODO : Display a error toast ?
            }

            OnBoardingEvents.OnTokenSaved -> {
                //TODO Display a success message or navigate to the next screen
                onContinue()
            }
        }
    }
    var text by remember { mutableStateOf("Text") }
    Column(
        modifier = Modifier.fillMaxSize().background(backgroundBlue)
            .padding(16.dp),
        horizontalAlignment = CenterHorizontally
    ) {
        Image(
            modifier = Modifier.height(400.dp),
            painter = painterResource(Res.drawable.on_boarding_page_3),
            contentDescription = null
        )

        Spacer(Modifier.padding(16.dp))

        Text(
            text = stringResource(Res.string.on_boarding3_title),
            style = onBoardingTitle
        )

        Spacer(Modifier.padding(8.dp))

        Text(
            text = stringResource(Res.string.on_boarding3_subtitle),
            style = onBoardingSubTitle
        )
        Spacer(Modifier.padding(16.dp))

        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = { Text("Label") }
        )

        Spacer(Modifier.weight(1f))

        Button(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
            onClick = {viewModel.setToken(text)}
        ) {
            Text(
                text = stringResource(Res.string.on_boarding_next),
                fontSize = 30.sp
            )
        }
    }
}