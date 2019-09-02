package com.example.employeelocation.data.retrofit.response

import com.example.employeelocation.data.model.EmployeeDataModel
import com.google.gson.annotations.SerializedName

class GetEmployeeListResponse (
    @SerializedName("employees") val employees: ArrayList<EmployeeDataModel>
)