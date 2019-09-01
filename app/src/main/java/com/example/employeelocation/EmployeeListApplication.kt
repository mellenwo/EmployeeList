package com.example.employeelocation

import android.content.Context
import com.example.employeelocation.base.di.KoinModules
import com.facebook.stetho.Stetho
import com.google.android.play.core.splitcompat.SplitCompatApplication
import timber.log.Timber

class EmployeeListApplication: SplitCompatApplication(){

    private lateinit var context: Context

    override fun onCreate() {
        super.onCreate()

        context = this

        initTimber()
        initStetho()
        initKoin()
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initKoin() {
        KoinModules.initKoin(this)
    }
}