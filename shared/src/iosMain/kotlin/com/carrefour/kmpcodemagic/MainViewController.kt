package com.carrefour.kmpcodemagic

import androidx.compose.ui.window.ComposeUIViewController
import com.carrefour.kmpcodemagic.di.initKoin
import platform.UIKit.UIViewController


fun MainViewController(
    mapUIViewController: () -> UIViewController
) = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    mapViewController = mapUIViewController
    App()
}

lateinit var mapViewController: () -> UIViewController