package com.example.a20141251majorprojectjohnathanbailey

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class FaceBook : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social)

        val web: WebView = findViewById(R.id.wvSocial)
        web.webViewClient = CustomWebViewClient(this)
        web.loadUrl("https://www.facebook.com/uccjamaica?mibextid=ZbWKwL")

        val webSettings = web.settings
        webSettings.javaScriptEnabled = false
    }
}

//Allows external website to load within WebView element

