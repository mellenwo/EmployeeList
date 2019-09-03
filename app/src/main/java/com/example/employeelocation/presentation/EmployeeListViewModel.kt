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
    var allEmployees = listOf<EmployeeDomainModel>()
    var locations = ArrayList<String>()
    var filteredLocation = NonNullObservableField<List<String>>(listOf())
    var selectedLocation = String()

    override fun onLoadData() {
        initUI()
    }

    private fun initUI() = launch {
        employees.set(getEmployeeListUseCase.execute())

        allEmployees = employees.get()

        val employeesList = employees.get()
        employeesList.forEach {
            locations.addAll(it.locations)
        }
        filteredLocation.set(locations.distinct())
    }

    fun filterByLocation(location: String) {
        val employeeList = allEmployees
        val filteredEmployeeList = employeeList.filter {
            it.locations.contains(location)
        }
        employees.set(filteredEmployeeList)
        selectedLocation = location
    }

}