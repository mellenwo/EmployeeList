package com.example.employeelocation.presentation

import com.example.employeelocation.base.delegate.NonNullObservableField
import com.example.employeelocation.base.presentation.BaseViewModel
import com.example.employeelocation.domain.model.EmployeeDomainModel
import com.example.employeelocation.domain.usecase.GetEmployeeListUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class EmployeeListViewModel(
    private val getEmployeeListUseCase: GetEmployeeListUseCase,
    baseCoroutineDispatcher: CoroutineDispatcher
) : BaseViewModel(baseCoroutineDispatcher) {

    var employees = NonNullObservableField <List<EmployeeDomainModel>>(listOf())

    override fun onLoadData() {
        getEmployeeList()
    }

    private fun getEmployeeList() = launch {
        employees.set(getEmployeeListUseCase.execute())
    }

}