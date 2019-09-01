package com.example.employeelocation.base.di

import com.example.employeelocation.presentation.EmployeeListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { EmployeeListViewModel(get()) }
}