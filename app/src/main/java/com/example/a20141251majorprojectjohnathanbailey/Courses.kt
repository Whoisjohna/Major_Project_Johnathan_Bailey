package com.example.a20141251majorprojectjohnathanbailey

data class Courses (val Course_code: String? = null, val Course_Title: String? = null,
                    val Credits: String? = null, val Description: String? = null,
                    val Pre_requisites: String? = null) {
    // Null default values create a no-argument default constructor, which is needed
    // for deserialization from a DataSnapshot.
}