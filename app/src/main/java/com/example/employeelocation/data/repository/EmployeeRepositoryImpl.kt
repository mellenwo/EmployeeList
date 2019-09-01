package com.example.employeelocation.data.repository

import com.example.employeelocation.data.model.toDomainModel
import com.example.employeelocation.data.retrofit.service.EmployeeRetrofitService
import com.example.employeelocation.domain.repository.EmployeeRepository

class EmployeeRepositoryImpl (
    private val employeeRetrofitService: EmployeeRetrofitService
) : EmployeeRepository {

    override suspend fun getEmployees() =
        employeeRetrofitService.getEmployeesAsync()
            .results
            .employees
            .employeeList
            .map { it.toDomainModel() }

}
