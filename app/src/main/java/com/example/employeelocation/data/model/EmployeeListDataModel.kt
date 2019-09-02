package com.example.employeelocation.data.model

import com.google.gson.annotations.SerializedName

data class EmployeeListDataModel(
    @SerializedName("employees") val employees: ArrayList<EmployeeDataModel>
)