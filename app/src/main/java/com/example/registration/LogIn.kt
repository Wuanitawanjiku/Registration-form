package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.registration.api.ApiClient
import com.example.registration.api.ApiInterface
import com.example.registration.models.LogInRequest
import com.example.registration.models.LogInResponse
import com.example.registration.models.RegistrationRequest
import com.example.registration.models.RegistrationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogIn : AppCompatActivity() {

    lateinit var etEmailLogIn: EditText
    lateinit var etPasswordLogIn: EditText
    lateinit var btnLogIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        views()
        logIn()
    }

    fun views() {
        etEmailLogIn = findViewById(R.id.etEmailLogIn)
        etPasswordLogIn = findViewById(R.id.etPasswordLogIn)
        btnLogIn = findViewById(R.id.btnLogIn)

    }

    fun logIn() {

        var error = false
        btnLogIn.setOnClickListener {
            var logInEmail = etEmailLogIn.text.toString()
            if (logInEmail.isEmpty()) {
                error = true
                etEmailLogIn.setError("Email is required")
            }
            var idLogInPassword = etPasswordLogIn.text.toString()
            if (idLogInPassword.isEmpty()) {
                error = true
                etPasswordLogIn.setError("ID Number required")
            }

            var logInRequest = LogInRequest(
                email = logInEmail,
                password = idLogInPassword
            )


            val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
            var request = retrofit.logInStudent(logInRequest)
            request.enqueue(object : Callback<LogInResponse> {

                override fun onResponse(
                    call: Call<LogInResponse>,
                    response: Response<LogInResponse>
                ) {
                    if (response.isSuccessful) {
                        Toast.makeText(baseContext, "LogIn successful", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                override fun onFailure(call: Call<LogInResponse>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }

            })
            val intent = Intent(baseContext, CoursesActivity::class.java)
            startActivity(intent)
        }

    }
}

