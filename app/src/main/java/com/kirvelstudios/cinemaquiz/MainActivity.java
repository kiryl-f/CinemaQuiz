package com.kirvelstudios.cinemaquiz;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.kirvelstudios.cinemaquiz.DirectorLevelActivities.AllDirActivity;
import com.kirvelstudios.cinemaquiz.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    String locale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageView view = findViewById(R.id.circleImageView);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InfoActivity.class));
            }
        });
        locale = Locale.getDefault().getLanguage();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdView mAdView = findViewById(R.id.adView);

        mAdView.loadAd(new AdRequest.Builder().build());

        setSettingsImageView();

        binding.guessFilmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EasyGuessFilmActivity.class);
                String localeUpCase = locale.toUpperCase(), localeLowCase = locale.toLowerCase(), region;
                if(locale.equals("en")) {
                    region = "US";
                } else {
                    region = localeUpCase;
                }
                intent.putExtra("key","33d65e0ed0777308653502b72db75fd0");
                intent.putExtra("language", localeLowCase+'-'+localeUpCase);
                intent.putExtra("region", region);
                intent.putExtra("nameType", "title");
                intent.putExtra("type", "movie");
                intent.putExtra("tmdbLink1","https://api.themoviedb.org/3/movie/");
                intent.putExtra("nameType", "title");
                intent.putExtra("type", "movie");
                startActivity(intent);
            }
        });

        binding.guessActorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AllDirActivity.class));
            }
        });

        binding.guessQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(MainActivity.this,QuoteActivity.class));
            }
        });

        binding.guessTvSeriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EasyGuessFilmActivity.class);
                String localeUpCase = locale.toUpperCase(), localeLowCase = locale.toLowerCase();
                intent.putExtra(
                        "url",
                        "https://api.themoviedb.org/3/tv/popular?api_key=33d65e0ed0777308653502b72db75fd0&language="+localeLowCase+'-'+localeUpCase+"&region="+localeUpCase+"&page=");
                intent.putExtra("tmdbLink1","https://api.themoviedb.org/3/tv/");
                intent.putExtra("nameType", "name");
                intent.putExtra("type", "tv");
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        setSettingsImageView();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        setSettingsImageView();
        super.onRestart();
    }

    @Override
    protected void onStart() {
        setSettingsImageView();
        super.onStart();
    }

    private void setSettingsImageView() {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("prefs", Context.MODE_PRIVATE);
        if(preferences.getBoolean("sound", false)) {
            binding.soundImageView.setImageResource(R.drawable.sound_bg);
        } else {
            binding.soundImageView.setImageResource(R.drawable.sound_off_bg);
        }
    }

    public void onClickMenuButtons(View view) {
        switch (view.getId()) {
            case R.id.soundImageView:
                SharedPreferences preferences = getApplicationContext().getSharedPreferences("prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                if (preferences.getBoolean("sound", false)) {
                    editor.putBoolean("sound", false);
                    editor.apply();
                    preferences = getApplicationContext().getSharedPreferences("dirPrefs", Context.MODE_PRIVATE);
                    editor = preferences.edit();
                    editor.putBoolean("sound", false);
                    editor.apply();
                    preferences = getApplicationContext().getSharedPreferences("qPrefs", Context.MODE_PRIVATE);
                    editor = preferences.edit();
                    editor.putBoolean("sound", false);
                    editor.apply();
                    binding.soundImageView.setImageResource(R.drawable.sound_off_bg);
                } else {
                    editor.putBoolean("sound", true);
                    editor.apply();
                    preferences = getApplicationContext().getSharedPreferences("dirPrefs", Context.MODE_PRIVATE);
                    editor = preferences.edit();
                    editor.putBoolean("sound", true);
                    editor.apply();
                    preferences = getApplicationContext().getSharedPreferences("qPrefs", Context.MODE_PRIVATE);
                    editor = preferences.edit();
                    editor.putBoolean("sound", true);
                    editor.apply();
                    binding.soundImageView.setImageResource(R.drawable.sound_bg);
                }
                break;
            case R.id.exitAppImageView:
                finish();
                break;
            case R.id.rateAppImageView:
                Uri uri = Uri.parse("market://details?id=" + this.getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
                }
                break;
        }
    }

}