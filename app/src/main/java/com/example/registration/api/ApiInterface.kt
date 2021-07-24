package com.example.registration.api

import com.example.registration.models.LogInRequest
import com.example.registration.models.LogInResponse
import com.example.registration.models.RegistrationRequest
import com.example.registration.models.RegistrationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
    fun registerStudent(@Body registrationRequest: RegistrationRequest): Call<RegistrationResponse>
    @POST("/studentS/login")
    fun logInStudent(@Body logInRequest: LogInRequest): Call<LogInResponse>
}