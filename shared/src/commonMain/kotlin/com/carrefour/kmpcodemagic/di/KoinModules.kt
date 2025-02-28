package com.carrefour.kmpcodemagic.di

import com.carrefour.kmpcodemagic.data.TokenDataStore
import com.carrefour.kmpcodemagic.data.repository.CodeMagicRepositoryImpl
import com.carrefour.kmpcodemagic.data.repository.TokenRepositoryImpl
import com.carrefour.kmpcodemagic.domain.CodeMagicRepository
import com.carrefour.kmpcodemagic.domain.TokenRepository
import com.carrefour.kmpcodemagic.domain.usecase.FetchBuildListUseCase
import com.carrefour.kmpcodemagic.domain.usecase.FetchBuildListUseCaseImpl
import com.carrefour.kmpcodemagic.domain.usecase.GetBuildUseCase
import com.carrefour.kmpcodemagic.domain.usecase.GetBuildUseCaseImpl
import com.carrefour.kmpcodemagic.domain.usecase.GetTokenUseCase
import com.carrefour.kmpcodemagic.domain.usecase.GetTokenUseCaseImpl
import com.carrefour.kmpcodemagic.domain.usecase.ObserveBuildListUseCase
import com.carrefour.kmpcodemagic.domain.usecase.ObserveBuildListUseCaseImpl
import com.carrefour.kmpcodemagic.domain.usecase.SetTokenUseCase
import com.carrefour.kmpcodemagic.domain.usecase.SetTokenUseCaseImpl
import com.carrefour.kmpcodemagic.network.CodeMagicApi
import com.carrefour.kmpcodemagic.network.CodeMagicApiImpl
import com.carrefour.kmpcodemagic.network.TokenAuthenticationPlugin
import com.carrefour.kmpcodemagic.ui.feature.build.BuildDetailsViewModel
import com.carrefour.kmpcodemagic.ui.feature.build.BuildViewModel
import com.carrefour.kmpcodemagic.ui.feature.onboarding.viewmodels.OnBoardingViewModel
import com.carrefour.kmpcodemagic.ui.feature.profile.ProfileViewModel
import com.carrefour.kmpcodemagic.ui.feature.splashscreen.SplashScreenViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
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
            provideHttpClientModule,
            provideApiModule,
            platformModule()
        )
    }
}
val provideHttpClientModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
            }
            install(Logging)
        }
    }
}

val provideViewModelModule = module {
    viewModelOf(::SplashScreenViewModel)
    viewModelOf(::OnBoardingViewModel)
    viewModelOf(::ProfileViewModel)
    viewModelOf(::BuildViewModel)
    viewModelOf(::BuildDetailsViewModel)
}

val provideUseCaseModule = module {
    singleOf(::GetTokenUseCaseImpl).bind(GetTokenUseCase::class)
    singleOf(::SetTokenUseCaseImpl).bind(SetTokenUseCase::class)
    singleOf(::FetchBuildListUseCaseImpl).bind(FetchBuildListUseCase::class)
    singleOf(::ObserveBuildListUseCaseImpl).bind(ObserveBuildListUseCase::class)
    singleOf(::GetBuildUseCaseImpl).bind(GetBuildUseCase::class)
}

val provideRepositoryModule = module {
    singleOf(::TokenRepositoryImpl).bind(TokenRepository::class)
    singleOf(::CodeMagicRepositoryImpl).bind(CodeMagicRepository::class)
}

val provideApiModule = module {
    singleOf(::CodeMagicApiImpl).bind(CodeMagicApi::class)
    singleOf(::TokenAuthenticationPlugin)
}

val provideDataStoreModule = module {
    singleOf(::TokenDataStore)
}