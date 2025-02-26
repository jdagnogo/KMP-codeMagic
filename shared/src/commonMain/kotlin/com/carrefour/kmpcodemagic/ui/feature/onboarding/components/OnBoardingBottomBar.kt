@file:OptIn(ExperimentalFoundationApi::class)

package com.carrefour.kmpcodemagic.ui.feature.onboarding.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kmp_codemagic.shared.generated.resources.Res
import kmp_codemagic.shared.generated.resources.on_boarding_back
import kmp_codemagic.shared.generated.resources.on_boarding_next
import kmp_codemagic.shared.generated.resources.on_boarding_save
import org.jetbrains.compose.resources.stringResource


@Composable
fun OnBoardingBottomBar(
    pagerState: PagerState,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onNextClick: () -> Unit,
    onDoneClick: () -> Unit,
) {
    val isLastPage = pagerState.currentPage == pagerState.pageCount - 1

    Column(
        modifier = modifier,
    ) {
        HorizontalPagerIndicator(
            modifier = Modifier.wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            pagerState = pagerState,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            if (pagerState.currentPage != 0) {
                TextButton(
                    onClick = onBackClick,
                ) {
                    Text(
                        text = stringResource(Res.string.on_boarding_back),
                    )
                }
            }
            Spacer(Modifier.weight(1f))

            if (isLastPage) {
                Button(
                    onClick = onDoneClick,
                    enabled = enabled,
                ) {
                    Text(
                        text = stringResource(Res.string.on_boarding_save),
                    )
                }
            } else {
                Button(onClick = onNextClick) {
                    Text(
                        text = stringResource(Res.string.on_boarding_next),
                    )
                }
            }
        }
    }
}
