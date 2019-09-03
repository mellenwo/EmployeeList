package com.example.employeelocation.base.di

import com.example.employeelocation.base.di.CoroutineModule.IO
import com.example.employeelocation.data.repository.EmployeeRepositoryImpl
import com.example.employeelocation.domain.repository.EmployeeRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    single<EmployeeRepository> { EmployeeRepositoryImpl(get(named(IO))) }
}