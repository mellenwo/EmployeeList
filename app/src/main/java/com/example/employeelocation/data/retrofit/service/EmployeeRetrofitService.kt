package com.example.employeelocation.data.retrofit.service

import com.example.employeelocation.data.retrofit.response.GetEmployeeListResponse
import retrofit2.http.GET

internal interface EmployeeRetrofitService {

    @GET
    suspend fun getEmployeesAsync(): GetEmployeeListResponse

}