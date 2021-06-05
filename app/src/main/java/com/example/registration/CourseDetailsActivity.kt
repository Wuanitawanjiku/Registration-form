package com.example.registration

//import android.content.Intent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CourseDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_details)
        var btnCourseDetails = findViewById<Button>(R.id.btnCourseDetails)
        btnCourseDetails.setOnClickListener {
            var intent = Intent(baseContext, CoursesActivity::class.java)
            startActivity(intent)
        }
    }
}
