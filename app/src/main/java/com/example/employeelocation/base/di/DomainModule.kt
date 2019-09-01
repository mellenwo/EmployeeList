package com.example.employeelocation.base.di

import com.example.employeelocation.domain.usecase.GetEmployeeListUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetEmployeeListUseCase(get()) }
}