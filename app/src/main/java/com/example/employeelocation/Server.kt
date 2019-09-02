package com.example.employeelocation

import com.example.employeelocation.data.retrofit.response.GetEmployeeListResponse
import com.example.employeelocation.data.retrofit.service.EmployeeRetrofitService
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Server() {
    private val mockWebServer = MockWebServer()
    private val apiService : EmployeeRetrofitService
    private lateinit var retrofit: Retrofit

    init {
        mockWebServer.start()
        enqueueResponse("http/employees_response.json")
        val baseUrl =  mockWebServer.url("").toUrl().toString()

        retrofit = buildRetrofit(baseUrl)
        apiService = retrofit.create(EmployeeRetrofitService::class.java)
    }

    private fun buildGson(): Gson =
        GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

    private fun getOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(interceptor)
        }

        return builder.build()
    }

    suspend fun getEmployeesAsync(): Deferred<GetEmployeeListResponse> {
        return apiService.getEmployeesAsync()
    }

    private fun buildRetrofit(baseUrl: String): Retrofit {
        val gson = buildGson()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(getOkHttpClient())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    private fun enqueueResponse(bodyFileName: String, statusCode: Int = 200) {
        val resource = this::class.java.classLoader.getResource(bodyFileName)
        val body = resource.readText()
        mockWebServer.enqueue(
            MockResponse().setResponseCode(statusCode).setBody(body))
    }
}