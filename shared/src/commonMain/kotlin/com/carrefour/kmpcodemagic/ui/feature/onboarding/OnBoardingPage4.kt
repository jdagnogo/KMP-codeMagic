package com.carrefour.kmpcodemagic.ui.feature.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import kmp_codemagic.shared.generated.resources.Res
import kmp_codemagic.shared.generated.resources.codemagic2
import kmp_codemagic.shared.generated.resources.codemagic3
import kmp_codemagic.shared.generated.resources.on_boarding3_subtitle
import kmp_codemagic.shared.generated.resources.on_boarding3_title
import kmp_codemagic.shared.generated.resources.on_boarding4_subtitle
import kmp_codemagic.shared.generated.resources.on_boarding4_title
import kmp_codemagic.shared.generated.resources.on_boarding_page_3
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun OnBoardingPage4Screen(
    token: String,
    onTokenChange: (String) -> Unit,
) {
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = CenterHorizontally
    ) {
        Image(
            modifier = Modifier.height(200.dp),
            painter = painterResource(Res.drawable.codemagic2),
            contentDescription = null
        )

        Text(
            text = stringResource(Res.string.on_boarding4_title),
            style = MaterialTheme.typography.displayLarge,
        )

        Spacer(Modifier.padding(8.dp))

        Text(
            text = stringResource(Res.string.on_boarding4_subtitle),
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center,
        )
        Spacer(Modifier.padding(16.dp))

        TokenTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            token = token,
            onTokenChange = onTokenChange,
        )

        val annotatedString = buildAnnotatedString {
            append("Grab your api token from your")
            val link = LinkAnnotation.Url(
                url = "https://codemagic.io/teams",
                styles = TextLinkStyles(style = SpanStyle(color = MaterialTheme.colorScheme.primary)),
                linkInteractionListener = {
                    val url = (it as LinkAnnotation.Url).url
                    uriHandler.openUri(url)
                }
            )
            withLink(link = link) {
                append(" account")
            }
            append(" under ")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onSurfaceVariant)) {
                append("Personal Account > Integrations > Codemagic API")
            }
            append(".")
        }
        Text(
            text = annotatedString,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Composable
fun TokenTextField(
    token: String,
    modifier: Modifier = Modifier,
    onTokenChange: (String) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = token,
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        onValueChange = onTokenChange,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        textStyle = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onSurface),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        ),
        placeholder = {
            Text(
                text = "API Token*",
                style = MaterialTheme.typography.titleMedium,
            )
        },
    )
}

