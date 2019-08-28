package com.example.employeelocation.data.model

import com.example.employeelocation.domain.model.EmployeeDomainModel
import com.google.gson.annotations.SerializedName

internal class EmployeeDataModel (
    @SerializedName("name") val name: String,
    @SerializedName("locations") val locations: List<String>,
    @SerializedName("title") val title: String
)

internal fun EmployeeDataModel.toDomainModel() = EmployeeDomainModel(
    name = this.name,
    locations = this.locations,
    title = this.title
)