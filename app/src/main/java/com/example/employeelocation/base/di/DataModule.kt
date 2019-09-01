package com.example.employeelocation.base.di

import com.example.employeelocation.data.repository.EmployeeRepositoryImpl
import com.example.employeelocation.domain.repository.EmployeeRepository
import org.koin.dsl.module

val dataModule = module {

    single<EmployeeRepository> { EmployeeRepositoryImpl(get()) }

}