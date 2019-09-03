package com.example.employeelocation.base.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Define Dispatchers for coroutines
 */

object CoroutineModule {
    const val UI = "UI"
    const val BACKGROUND = "Background"
    const val IO = "IO"

    val coroutineModule = module {
        single<CoroutineDispatcher>(named(UI), definition = { Dispatchers.Main })
        single(named(BACKGROUND), definition = { Dispatchers.Default })
        single(named(IO), definition = { Dispatchers.IO })
    }
}