package com.carrefour.kmpcodemagic.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.carrefour.kmpcodemagic.data.createDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual fun platformModule() = module {
    single<DataStore<Preferences>> { createDataStore(androidContext()) }
}