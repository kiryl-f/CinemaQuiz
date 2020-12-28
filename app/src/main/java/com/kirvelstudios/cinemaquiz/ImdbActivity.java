package com.kirvelstudios.cinemaquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.kirvelstudios.cinemaquiz.databinding.ActivityImdbBinding;

public class ImdbActivity extends AppCompatActivity {

    ActivityImdbBinding binding;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityImdbBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        WebView webView = findViewById(R.id.imdbWebView);

        Intent dataIntent = getIntent();
        String url = dataIntent.getStringExtra("url");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }

    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }
}
