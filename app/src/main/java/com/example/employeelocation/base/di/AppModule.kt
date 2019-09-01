package com.example.employeelocation.base.di

import android.content.Context
import com.example.employeelocation.EmployeeListApplication
import org.koin.dsl.module

val appModule = module {
    single { get<Context>() as EmployeeListApplication }
}