package com.example.a20141251majorprojectjohnathanbailey

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.provider.ContactsContract
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity(), Parcelable {
    private val mail: String = "ucconline@ucc.edu.jm"
    private val url: String = "https://ucc.edu.jm/apply/"
    private val web: String = "https://www.ucc.edu.jm/programmes/tm/bsc-in-information-technology#:~:text=PROGRAMME%20DESCRIPTION,that%20solve%20real%20world%20problems. "
    private val db = Firebase.firestore

        @SuppressLint("SuspiciousIndentation", "MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            //Method launches Directory activity
            val directory: ImageButton = findViewById(R.id.ibDir)
            directory.setOnClickListener {
                val intent = Intent(this, ContactsContract.Directory::class.java)
                startActivity(intent)
            }

            val viewCourses: ImageButton = findViewById(R.id.courses)
            db.collection("uccdat")
            viewCourses.setOnClickListener {
                startActivity(Intent(this, CourseListing::class.java))

            }

            //Method launches admission requirements webpage
            val admissions: ImageButton = findViewById(R.id.admissions)
            admissions.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(web)
                startActivity(intent)

            }

            //Launches device browser and loads specified URL
            val apply: ImageButton = findViewById(R.id.ibApply)
            apply.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                startActivity(intent)
            }

            //Method launches Social/Twitter activity
            val twit: ImageButton = findViewById(R.id.twitButton)
            twit.setOnClickListener {
                val intent = Intent(this, Twitter::class.java)
                startActivity(intent)
            }

            //Method launches Social/fb activity
            val fb: ImageButton = findViewById(R.id.fbButton)
            fb.setOnClickListener {
                val intent = Intent(this, FaceBook::class.java)
                startActivity(intent)
            }

            //Method launches Social/IG activity
            val inst: ImageButton = findViewById(R.id.igButton)
            inst.setOnClickListener {
                val intent = Intent(this, Instagram::class.java)
                startActivity(intent)
            }
            //Sends email to preset address when FAB is clicked
            val sendEmail: FloatingActionButton = findViewById(R.id.fabEmail)
            sendEmail.setOnClickListener {
                val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", mail, null))
                intent.putExtra(Intent.EXTRA_EMAIL, mail)
                startActivity(intent)

            }
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {

        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<MainActivity> {
            override fun createFromParcel(parcel: Parcel): MainActivity {
                return MainActivity()
            }

            override fun newArray(size: Int): Array<MainActivity?> {
                return arrayOfNulls(size)
            }
        }
    }

