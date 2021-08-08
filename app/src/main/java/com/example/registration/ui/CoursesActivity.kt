package com.example.registration.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.registration.CoursesAdapter
import com.example.registration.R
import com.example.registration.databinding.ActivityCoursesBinding
import com.example.registration.databinding.ActivityLogInBinding
import com.example.registration.ui.Course
import com.example.registration.viewmodel.CoursesViewModel
import com.example.registration.viewmodel.LogInViewModel

class CoursesActivity : AppCompatActivity() {

    lateinit var binding: ActivityCoursesBinding
    val coursesViewModel: CoursesViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        binding = ActivityCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume(){
        super.onResume()
        coursesViewModel.coursesLiveData.observe(this, { coursesResponse->

        })
    }
}











//displayContent()

//fun displayContent(){
//        var rvCourses = findViewById<RecyclerView>(R.id.rvCourses)
//        var courseList = listOf(
//            Course("MB101", "Mobile Development", "Introduction to Android Development with Kotlin", "John Owuor"),
//            Course("BE2101", "Backend Development", "Introduction to Backend Development with Python", "James Mwai"),
//            Course("IOT104", "IoT", "IoT implementation", "Barre Yassin"),
//            Course("FE105", "Frontend Development", "Introduction to Frontend Development with JavaScript", "Purity Maina"),
//            Course("IDX502", "Industrial Design", "Design for everyday life", "Erick Asiago"),
//            Course("UXR301", "UX Research", "UX and UI field research", "Joy Wambui")
//        )
//        var coursesAdapter = CoursesAdapter(courseList)
//        rvCourses.layoutManager = LinearLayoutManager(baseContext)
//        rvCourses.adapter = coursesAdapter
//    }