package com.cendekia.drakorindoapp.ui.webview

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cendekia.drakorindoapp.databinding.ActivityMyWebViewBinding

class MyWebView : AppCompatActivity() {
    companion object {
        const val EXTRA_LINK = "extra_link"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMyWebViewBinding = ActivityMyWebViewBinding.inflate(layoutInflater)
        setContentView(activityMyWebViewBinding.root)

        actionBar?.hide()
        activityMyWebViewBinding.webView.settings.javaScriptEnabled = true

        activityMyWebViewBinding.webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                view.loadUrl("javascript:alert('Youtube berhasil dimuat')")
            }
        }

        activityMyWebViewBinding.webView.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(
                view: WebView,
                url: String,
                message: String,
                result: android.webkit.JsResult
            ): Boolean {
                Toast.makeText(this@MyWebView, message, Toast.LENGTH_LONG).show()
                result.confirm()
                return true
            }
        }

        val extras = intent.extras
        if (extras != null) {
            val drakorindoId = extras.getString(EXTRA_LINK)
            if (drakorindoId != null) {
                activityMyWebViewBinding.webView.loadUrl(drakorindoId)
            }
        }
    }
}