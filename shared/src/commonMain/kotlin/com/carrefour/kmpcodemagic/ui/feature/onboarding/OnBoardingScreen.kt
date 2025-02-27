@file:OptIn(ExperimentalFoundationApi::class)

package com.carrefour.kmpcodemagic.ui.feature.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.carrefour.kmpcodemagic.ui.feature.onboarding.components.OnBoardingBottomBar
import com.carrefour.kmpcodemagic.ui.feature.onboarding.viewmodels.OnBoardingEvents
import com.carrefour.kmpcodemagic.ui.feature.onboarding.viewmodels.OnBoardingViewModel
import com.carrefour.kmpcodemagic.utils.LaunchedEffectWithLifecycle
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel = koinViewModel(),
    navigateToMain: () -> Unit,
) {
    val pagerState = rememberPagerState { 4 }
    val coroutineScope = rememberCoroutineScope()
    val text by viewModel.text.collectAsStateWithLifecycle()

    LaunchedEffectWithLifecycle(flow = viewModel.events) { event ->
        when (event) {
            OnBoardingEvents.OnTokenFailed -> {
                //TODO : Display a error toast ?
            }

            OnBoardingEvents.OnTokenSaved -> {
                //TODO Display a success message or navigate to the next screen
                navigateToMain()
            }
        }
    }

    Scaffold(
        bottomBar = {
            OnBoardingBottomBar(
                modifier = Modifier
                    .navigationBarsPadding(),
                pagerState = pagerState,
                enabled = text.isNotBlank(),
                onNextClick = {
                    coroutineScope.launch {
                        pagerState.animateToNextPage()
                    }
                },
                onBackClick = {
                    coroutineScope.launch {
                        pagerState.animateToPreviousPage()
                    }
                },
                onDoneClick = viewModel::setToken,
            )
        }
    ) { padding ->
        HorizontalPager(
            modifier = Modifier.padding(padding),
            state = pagerState,
        ) { page ->
            when (page) {
                0 -> OnBoardingPage1Screen()
                1 -> OnBoardingPage2Screen()
                2 -> OnBoardingPage3Screen()
                3 -> OnBoardingPage4Screen(
                    token = text,
                    onTokenChange = viewModel::onTextChange,
                )
            }
        }
    }
}

suspend fun PagerState.animateToNextPage() {
    val nextPage = (currentPage + 1).coerceIn(0, this.pageCount - 1)
    animateScrollToPage(nextPage)
}

suspend fun PagerState.animateToPreviousPage() {
    animateScrollToPage(currentPage - 1)
}

