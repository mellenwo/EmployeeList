package com.example.employeelocation.data.repository

import com.example.employeelocation.Server
import com.example.employeelocation.data.model.toDomainModel
import com.example.employeelocation.domain.model.EmployeeDomainModel
import com.example.employeelocation.domain.repository.EmployeeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class EmployeeRepositoryImpl(private val backgroundDispatcher: CoroutineDispatcher) : EmployeeRepository {

    override suspend fun getEmployees(): List<EmployeeDomainModel> = withContext(backgroundDispatcher) {
        Server()
            .getEmployeesAsync()
            .await()
            .employees
            .let { it }
            .map {
                it.toDomainModel()
            }
    }
}
