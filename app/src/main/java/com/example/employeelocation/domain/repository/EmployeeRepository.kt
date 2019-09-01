package com.example.employeelocation.domain.repository

import com.example.employeelocation.domain.model.EmployeeDomainModel

interface EmployeeRepository {

    suspend fun getEmployees(): List<EmployeeDomainModel>

}