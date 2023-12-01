package com.example.a20141251majorprojectjohnathanbailey

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a20141251majorprojectjohnathanbailey.ui.theme._20141251MajorProjectJohnathanBaileyTheme
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val mail: String = "ucconline@ucc.edu.jm"
    private val url: String = "https://ucc.edu.jm/apply/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Creates directory object and links to button
        //Method launches Directory activity
        val directory: ImageButton = findViewById(R.id.ibDir)
        directory.setOnClickListener {
            val intent = Intent(this, Directory::class.java)
            startActivity(intent)
        }

        //Method launches Social/IG activity
        val web: ImageButton = findViewById(R.id.ibSocials)
        web.setOnClickListener {
            val intent = Intent(this, Social::class.java)
            startActivity(intent)
        }

        //Launches device browser and loads specified URL
        val apply: ImageButton = findViewById(R.id.ibApply)
        apply.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(url))
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
}


