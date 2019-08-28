package com.example.employeelocation.data.model

import com.google.gson.annotations.SerializedName

internal class EmployeeResultDataModel (
    @SerializedName("employees") val employees : EmployeeListDataModel
)