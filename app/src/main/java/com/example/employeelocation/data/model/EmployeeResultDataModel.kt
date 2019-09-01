package com.example.employeelocation.data.model

import com.google.gson.annotations.SerializedName

class EmployeeResultDataModel (
    @SerializedName("employees") val employees : EmployeeListDataModel
)