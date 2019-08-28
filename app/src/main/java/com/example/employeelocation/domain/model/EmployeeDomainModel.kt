package com.example.employeelocation.domain.model

internal data class EmployeeDomainModel(
    val name: String,
    val locations: List<String>,
    val title: String
)