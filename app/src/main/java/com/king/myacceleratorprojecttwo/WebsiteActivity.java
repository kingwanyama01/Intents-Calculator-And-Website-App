package com.king.myacceleratorprojecttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebsiteActivity extends AppCompatActivity {
    WebView mWebSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        mWebSite = findViewById(R.id.my_web);
        WebSettings settings = mWebSite.getSettings();
        settings.setJavaScriptEnabled(true);
//        mWebSite.loadUrl("https://www.emobilis.org");
        mWebSite.loadUrl("file:///android_asset/home.html");
    }
}