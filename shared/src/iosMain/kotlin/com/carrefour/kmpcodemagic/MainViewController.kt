package com.carrefour.kmpcodemagic

import androidx.compose.ui.window.ComposeUIViewController
import com.carrefour.kmpcodemagic.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}