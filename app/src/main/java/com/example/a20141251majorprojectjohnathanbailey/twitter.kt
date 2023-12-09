package com.example.a20141251majorprojectjohnathanbailey

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class Twitter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twitter)
        val webSettings = web.settings
        webSettings.javaScriptEnabled = true

//Allows external website to load within WebView element

        class CustomViewClient internal constructor(private val activity: Activity) :
            WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                val url: String = request?.url.toString()
                view?.loadUrl(url)
                return true
            }

            override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
                webView.loadUrl(url)
                return true
            }

            override fun onReceivedError(
                view: WebView,
                request: WebResourceRequest,
                error: WebResourceError
            ) {
                Toast.makeText(activity, "Error! $error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
