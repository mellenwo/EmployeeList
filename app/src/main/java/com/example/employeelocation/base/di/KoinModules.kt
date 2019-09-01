package com.example.employeelocation.base.di

import android.content.Context
import com.example.employeelocation.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class KoinModules {
    companion object {
        @JvmStatic
        fun initKoin(context: Context): KoinApplication {
            val modules = listOf(CoroutineModule.coroutineModule, appModule, presentationModule, dataModule, domainModule)
            return startKoin {
                if (BuildConfig.DEBUG) {
                    androidLogger()
                }
                androidContext(context)
                modules(modules)
            }
        }
    }
}