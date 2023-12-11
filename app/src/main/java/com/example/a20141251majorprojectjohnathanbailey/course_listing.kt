package com.example.a20141251majorprojectjohnathanbailey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class course_listing : AppCompatActivity() {

    private var db = Firebase.firestore
    private lateinit var courseList: ArrayList<Courses>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_listing)
        val rvCourses: RecyclerView = findViewById(R.id.rvCourses)
        rvCourses.layoutManager = LinearLayoutManager(this)

        courseList = arrayListOf()

        db = FirebaseFirestore.getInstance()

        db.collection("Courses").get()
            .addOnSuccessListener {
                if(!it.isEmpty){
                    for (data in it.documents){
                        val courses: Courses? = data.toObject(Courses::class.java)
                        if(courses != null){
                            courseList.add(courses)
                        }
                    }
                    rvCourses.adapter = MyAdapter(courseList)
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            }

    }
}