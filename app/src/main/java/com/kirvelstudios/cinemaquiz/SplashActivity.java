package com.kirvelstudios.cinemaquiz;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.kirvelstudios.cinemaquiz.DirectorLevelActivities.*;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        String locale = Locale.getDefault().getLanguage();
        String localeUpCase = locale.toUpperCase(), localeLowCase = locale.toLowerCase(), region;
        if(locale.equals("en")) {
            region = "US";
        } else {
            region = localeUpCase;
        }

        Intent filmIntent = new Intent(SplashActivity.this, EasyGuessFilmActivity.class);
        filmIntent.setAction(Intent.ACTION_VIEW);
        filmIntent.putExtra(
                "url",
                "https://api.themoviedb.org/3/movie/top_rated?api_key=33d65e0ed0777308653502b72db75fd0&language="+localeLowCase+'-'+localeUpCase+"&region="+region+"&page=");
        filmIntent.putExtra("tmdbLink1","https://api.themoviedb.org/3/movie/");
        filmIntent.putExtra("nameType", "title");
        filmIntent.putExtra("type", "movie");

        Intent dirIntent = new Intent(SplashActivity.this, AllDirActivity.class);
        dirIntent.setAction(Intent.ACTION_VIEW);

        Intent quoteIntent = new Intent(SplashActivity.this, QuoteActivity.class);
        quoteIntent.setAction(Intent.ACTION_VIEW);


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N_MR1) {
            ShortcutManager shortcutManager;
            shortcutManager = getSystemService(ShortcutManager.class);
            ShortcutInfo shortcut = new ShortcutInfo.Builder(getApplicationContext(), "film")
                    .setShortLabel(getResources().getString(R.string.guess_film))
                    .setIcon(Icon.createWithResource(getApplicationContext(), R.drawable.ic_movie_black_24dp))
                    .setIntent(filmIntent)
                    .build();

            ShortcutInfo dirShortcut = new ShortcutInfo.Builder(getApplicationContext(), "dir")
                    .setShortLabel(getResources().getString(R.string.guess_dir))
                    .setIcon(Icon.createWithResource(getApplicationContext(), R.drawable.ic_videocam_black_24dp))
                    .setIntent(dirIntent)
                    .build();

            ShortcutInfo quoteShortcut = new ShortcutInfo.Builder(getApplicationContext(), "quote")
                    .setShortLabel(getResources().getString(R.string.cinema_quotes))
                    .setIcon(Icon.createWithResource(getApplicationContext(), R.drawable.ic_format_quote_black_24dp))
                    .setIntent(quoteIntent)
                    .build();
            Objects.requireNonNull(shortcutManager).setDynamicShortcuts(Arrays.asList(shortcut, dirShortcut, quoteShortcut));

        }

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
