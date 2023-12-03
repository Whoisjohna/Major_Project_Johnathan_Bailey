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
import com.example.a20141251majorprojectjohnathanbailey.ui.theme._20141251MajorProjectJohnathanBaileyTheme
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.firestore
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
                startActivity(Intent(this, course_listing::class.java))
                // Read from the database
                //myRef.addValueEventListener(object: ValueEventListener {

                //	override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //	val value = snapshot.getValue<String>()
                //	Log.d(TAG, "Value is: " + value)
                //}

                //override fun onCancelled(error: DatabaseError) {
                //	Log.w(TAG, "Failed to read value.", error.toException())
                //	}

                //})
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
            val twit: ImageButton = findViewById(twitButton)
            twit.setOnClickListener {
                val intent = Intent(this, twitter::class.java)
                startActivity(intent)
            }

            //Method launches Social/fb activity
            val fb: ImageButton = findViewById(fbButton)
            fb.setOnClickListener {
                val intent = Intent(this, facebook::class.java)
                startActivity(intent)
            }

            //Method launches Social/IG activity
            val inst: ImageButton = findViewById(igButton)
            inst.setOnClickListener {
                val intent = Intent(this, instagram::class.java)
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

