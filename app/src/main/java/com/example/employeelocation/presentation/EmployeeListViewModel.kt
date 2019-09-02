package com.example.employeelocation.presentation

import androidx.databinding.ObservableField
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
    var locations = ArrayList<String>()
    var locationsList = ObservableField<ArrayList<String>>()

    override fun onLoadData() {
        getEmployeeList()
    }

    private fun getEmployeeList() = launch {
        employees.set(getEmployeeListUseCase.execute())

        val employeesList = employees.get()
        employeesList.forEach {
            locations.addAll(it.locations)
        }
        locationsList.set(locations)
    }

    fun buildEmployeeLocationsList(locations: ArrayList<String>) : List<String> {
        return locations.distinct()
    }

}