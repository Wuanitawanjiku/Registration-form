package com.example.registration

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etDob: EditText
    lateinit var etIdNumber: EditText
    lateinit var etNationality: EditText
    lateinit var etPhoneNumber: EditText
    lateinit var etEmail: EditText
    lateinit var btnRegister: Button

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
        clickRegister()
    }

    fun castViews(){
        etName = findViewById(R.id.etName)
        etDob  = findViewById(R.id.etDob)
        etNationality = findViewById(R.id.etNationality)
        etIdNumber = findViewById(R.id.etIdNumber)
        etEmail = findViewById(R.id.etEmail)
        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        btnRegister = findViewById(R.id.btnRegister)

    }
    fun clickRegister(){
    btnRegister.setOnClickListener {
        var name = etName.text.toString()

        if (name.isEmpty()) {
            etName.setError("Name is required")
        }

        var dob = etDob.text.toString()

        if (dob.isEmpty()) {
            etDob.setError("Date of birth is required")
        }
        var nationality = etNationality.text.toString()
        var idNumber = etIdNumber.text.toString()
        var email = etEmail.text.toString()
        var phoneNumber = etPhoneNumber.text.toString()

        var details = Register(
            name = name, dob = dob, nationality = nationality,
            idNumber = idNumber, email = email, phoneNumber = phoneNumber
        )

        Toast.makeText(baseContext, details.toString(), Toast.LENGTH_LONG).show()
        val intent = Intent(baseContext, CoursesActivity::class.java)
        startActivity(intent)
    }
}
data class Register(var name: String,
                    var dob: String,
                    var nationality: String,
                    var idNumber: String,
                    var email: String,
                    var phoneNumber: String)
}

