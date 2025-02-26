package com.carrefour.kmpcodemagic

import android.app.Application
import com.carrefour.kmpcodemagic.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent


class KMPApplication : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@KMPApplication)
        }
    }
}