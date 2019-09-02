package com.example.employeelocation.data.retrofit.service

import com.example.employeelocation.data.retrofit.response.GetEmployeeListResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface EmployeeRetrofitService {

    @GET("/employees/list")
    fun getEmployeesAsync(): Deferred<GetEmployeeListResponse>

}