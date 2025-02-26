package com.carrefour.kmpcodemagic.di

import com.carrefour.kmpcodemagic.data.TokenDataStore
import com.carrefour.kmpcodemagic.data.TokenRepositoryImpl
import com.carrefour.kmpcodemagic.domain.GetTokenUseCase
import com.carrefour.kmpcodemagic.domain.GetTokenUseCaseImpl
import com.carrefour.kmpcodemagic.domain.SetTokenUseCase
import com.carrefour.kmpcodemagic.domain.SetTokenUseCaseImpl
import com.carrefour.kmpcodemagic.domain.TokenRepository
import com.carrefour.kmpcodemagic.ui.feature.onboarding.viewmodels.OnBoardingViewModel
import com.carrefour.kmpcodemagic.ui.feature.splashscreen.SplashScreenViewModel
import com.carrefour.kmpcodemagic.ui.feature.profile.ProfileViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module

expect fun platformModule(): Module


fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            provideViewModelModule,
            provideUseCaseModule,
            provideRepositoryModule,
            provideDataStoreModule,
            platformModule()
        )
    }
}


val provideViewModelModule = module {
    viewModelOf(::SplashScreenViewModel)
    viewModelOf(::OnBoardingViewModel)
    viewModelOf(::ProfileViewModel)
}

val provideUseCaseModule = module {
    singleOf(::GetTokenUseCaseImpl).bind(GetTokenUseCase::class)
    singleOf(::SetTokenUseCaseImpl).bind(SetTokenUseCase::class)
}

val provideRepositoryModule = module {
    singleOf(::TokenRepositoryImpl).bind(TokenRepository::class)
}

val provideDataStoreModule = module {
    singleOf(::TokenDataStore)
}