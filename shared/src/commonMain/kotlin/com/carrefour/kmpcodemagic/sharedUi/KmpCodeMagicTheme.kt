package com.carrefour.kmpcodemagic.sharedUi

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carrefour.kmpcodemagic.sharedUi.theme.brandRed
import com.carrefour.kmpcodemagic.sharedUi.theme.primary
import com.carrefour.kmpcodemagic.sharedUi.theme.primaryDark
import com.carrefour.kmpcodemagic.sharedUi.theme.white
import kmp_codemagic.shared.generated.resources.Metropolis_Bold
import kmp_codemagic.shared.generated.resources.Metropolis_Regular
import kmp_codemagic.shared.generated.resources.Res
import org.jetbrains.compose.resources.Font

private val DarkColorPalette = darkColorScheme(
    primary = primary,
    secondary = primaryDark,
    tertiary = brandRed,
    onPrimary = white,
)

private val LightColorPalette = lightColorScheme(
    primary = primary,
    secondary = primaryDark,
    tertiary = brandRed,
    background = white,
)

@Composable
fun KmpCodeMagicTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    val metropolisFamily = FontFamily(
        Font(Res.font.Metropolis_Regular, FontWeight.Normal),
        Font(Res.font.Metropolis_Bold, FontWeight.Bold),
    )

    val typography = Typography(
        bodyMedium = TextStyle(
            fontFamily = metropolisFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 22.sp
        ),
        displayLarge = TextStyle(
            fontFamily = metropolisFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
        ),
        displayMedium = TextStyle(
            fontFamily = metropolisFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            lineHeight = 24.sp
        ),
    )

    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(8.dp),
        large = RoundedCornerShape(12.dp)
    )

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
