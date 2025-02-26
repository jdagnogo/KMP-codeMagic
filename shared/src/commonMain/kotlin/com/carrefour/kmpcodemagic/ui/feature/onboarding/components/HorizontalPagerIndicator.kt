@file:OptIn(ExperimentalFoundationApi::class)

package com.carrefour.kmpcodemagic.ui.feature.onboarding.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
internal fun HorizontalPagerIndicator(
    pagerState: PagerState,
    selectedColor: Color = MaterialTheme.colorScheme.onBackground,
    unselectedColor: Color = selectedColor.copy(alpha = 0.3f),
    indicatorSize: Dp = 12.dp,
    spacing: Dp = 4.dp,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color = when (pagerState.currentPage) {
                iteration -> selectedColor
                else -> unselectedColor
            }
            Box(
                modifier = Modifier
                    .padding(spacing)
                    .clip(CircleShape)
                    .background(color)
                    .size(indicatorSize)
            )
        }
    }
}