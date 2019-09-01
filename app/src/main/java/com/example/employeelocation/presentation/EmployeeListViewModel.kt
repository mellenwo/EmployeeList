package com.example.employeelocation.presentation

import androidx.lifecycle.viewModelScope
import com.example.employeelocation.base.presentation.BaseViewModel
import com.example.employeelocation.domain.usecase.GetEmployeeListUseCase
import kotlinx.coroutines.launch

class EmployeeListViewModel(
    private val getEmployeeListUseCase: GetEmployeeListUseCase
) : BaseViewModel() {

   // var employees = List<EmployeeDomainModel>()


    override fun onLoadData() {
        getEmployeeList()
    }

    private fun getEmployeeList() {
        viewModelScope.launch {
           // employees = getEmployeeListUseCase.execute()
        }
    }

}