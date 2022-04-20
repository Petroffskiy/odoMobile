package com.example.odoomobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient

class WebSite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_site)

        val webView = findViewById<WebView>(R.id.WebView)

        webView.loadUrl(intent.getStringExtra("swsu")!!)

        val webSettings = webView.settings
        webSettings.javaScriptEnabled=true
        webView.webViewClient = WebViewClient()
        Log.e("TAG", webView.toString())

        webView.canGoBack()
        webView.setOnKeyListener(View.OnKeyListener { _, keyCode, keyEvent ->
            if (keyCode == KeyEvent.KEYCODE_BACK && keyEvent.action == MotionEvent.ACTION_UP && webView.canGoBack()){
                webView.goBack()
                return@OnKeyListener true
            }
            false
        })

    }
}