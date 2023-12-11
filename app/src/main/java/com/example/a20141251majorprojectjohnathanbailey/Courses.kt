package com.example.a20141251majorprojectjohnathanbailey

data class Courses (val coursecode: String? = null, val courseTitle: String? = null,
                    val credits: String? = null, val description: String? = null,
                    val prerequisites: String? = null) {
    // Null default values create a no-argument default constructor, which is needed
    // for deserialization from a DataSnapshot.
}