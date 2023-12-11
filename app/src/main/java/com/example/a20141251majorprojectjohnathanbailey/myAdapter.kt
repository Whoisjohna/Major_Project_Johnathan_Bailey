package com.example.a20141251majorprojectjohnathanbailey

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val courseList: ArrayList<Courses>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val code: TextView = itemView.findViewById(R.id.tvCourseCode)
        val courseTitle:TextView = itemView.findViewById(R.id.tvCourseName)
        val credits:TextView = itemView.findViewById(R.id.tvCredits)
        val description:TextView = itemView.findViewById(R.id.tvCourseDetails)
        val prerequisites:TextView = itemView.findViewById(R.id.tvPrerequisite)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.code.text = courseList[position].coursecode
        holder.courseTitle.text = courseList[position].courseTitle
        holder.credits.text = courseList[position].credits
        holder.description.text = courseList[position].courseTitle
        holder.prerequisites.text = courseList[position].prerequisites

    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}