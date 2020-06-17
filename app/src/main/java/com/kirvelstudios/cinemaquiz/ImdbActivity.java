package com.kirvelstudios.cinemaquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class ImdbActivity extends AppCompatActivity {


    private WebView webView;
    private Intent dataIntent;
    private String url;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imdb);

        webView = findViewById(R.id.imdbWebView);

        dataIntent = getIntent();
        url = dataIntent.getStringExtra("url");
        Log.d("web","url:"+url);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }

    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }
}
