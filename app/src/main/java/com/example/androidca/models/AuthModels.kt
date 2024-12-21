package com.example.androidca.models

data class LoginRequest(
    val username: String,
    val password: String
)

data class LoginResponse(
    val message: String,
    val user: User?
)

data class User(
    val id: Int,
    val username: String,
    val isPaidUser: Boolean
)