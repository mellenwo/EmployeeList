package com.example.employeelocation.domain.usecase

import com.example.employeelocation.domain.model.EmployeeDomainModel
import com.example.employeelocation.domain.repository.EmployeeRepository

internal class GetEmployeeListUseCase(
    private val employeeRepository: EmployeeRepository
) {
    suspend fun execute(): List<EmployeeDomainModel> {
        return employeeRepository.getEmployees()
    }
}