package com.example.androidca

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.example.androidca.models.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
interface ApiService {

//    @POST("auth/get-verification-code")
//    fun getVerificationCode(@Body request: VerificationRequest): Call<VerificationResponse>
//
//    @POST("auth/register")
//    fun registerUser(@Body request: RegisterRequest): Call<RegisterResponse>

    @POST("auth/login")
    fun loginUser(@Body request: LoginRequest): Call<LoginResponse>

}