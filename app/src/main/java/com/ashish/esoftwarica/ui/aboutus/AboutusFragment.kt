package com.ashish.esoftwarica.ui.aboutus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ashish.esoftwarica.R

class AboutusFragment : Fragment() {
    private lateinit var myWebview : WebView


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_aboutus, container, false)

        val mWebView: WebView? = view?.findViewById(R.id.web) as WebView
        mWebView?.loadUrl("https://softwarica.edu.np/")
        val webSettings = mWebView?.getSettings()
        webSettings?.setJavaScriptEnabled(true)
        mWebView!!.webViewClient = WebViewClient()
        return view
    }
}