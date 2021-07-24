package com.example.registration.models

import com.google.gson.annotations.SerializedName

data class LogInRequest(
    var email: String,
    var password: String
)
