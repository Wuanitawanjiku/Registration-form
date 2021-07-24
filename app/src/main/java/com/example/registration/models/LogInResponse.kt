package com.example.registration.models

import com.google.gson.annotations.SerializedName

data class LogInResponse(
    var message: String,
    var access_token: String,
    var student_id: String
)
