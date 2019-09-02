package com.example.employeelocation.base.di

import com.example.employeelocation.base.di.CoroutineModule.UI
import com.example.employeelocation.presentation.EmployeeListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val presentationModule = module {
    viewModel { EmployeeListViewModel(get(), get(named(UI))) }
}