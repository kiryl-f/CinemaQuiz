package com.kirvelstudios.cinemaquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class ImdbActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imdb);

        WebView webView = findViewById(R.id.imdbWebView);

        Intent dataIntent = getIntent();
        String url = dataIntent.getStringExtra("url");
        Log.d("web","url:"+ url);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }

    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }
}
