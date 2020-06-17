package com.kirvelstudios.cinemaquiz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.kirvelstudios.cinemaquiz.Quotes.Quote;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

import me.grantland.widget.AutofitTextView;

public class QuoteActivity extends AppCompatActivity {

    AutofitTextView textView;
    ArrayList <Button> buttons = new ArrayList<>();
    ArrayList <Quote> quotes = new ArrayList<>();
    ArrayList <String> filmNames = new ArrayList<>(), allQuoteNames = new ArrayList<>();
    ImageView next, imdb, hpImageView;
    TextView scoreTextView;
    int cur = 0, score = 0 , hp = 0;
    boolean isAdvice = false, isAdUsed = false;
    int [] nums;
    String filmName;
    boolean isAnswered = false, sound = false;
    SharedPreferences preferences;
    RewardedAd rewardedAd;
    private FloatingActionButton floatingActionButton;
    private String url;
    private FloatingActionsMenu floatingActionsMenu;

    private void createRewardedAd() {
        rewardedAd = new RewardedAd(this, "ca-app-pub-6532809968895987/7693117297");
        RewardedAdLoadCallback loadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdFailedToLoad(int i) {
                super.onRewardedAdFailedToLoad(i);
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), loadCallback);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quote);

        iniXml();

        preferences = getApplicationContext().getSharedPreferences("qPrefs", Context.MODE_PRIVATE);
        sound = preferences.getBoolean("sound", false);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        createRewardedAd();

        setScore();
        setLevel();

        setAllDirNames();

        nextDirector();
        next.setClickable(false);

        hp = preferences.getInt("hp", 3);
        if(hp > 0) {
            score = preferences.getInt("score",0);
        }
        if(hp == 0) {
            hp = 3;
        }
        nums = new int[] {R.drawable.heart, R.drawable.heart2, R.drawable.heart3};
        hpImageView.setImageResource(nums[hp-1]);
        setScore();

        imdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImdb(url);
            }
        });

        floatingActionsMenu = findViewById(R.id.floatingActionMenu);
    }

    @Override
    protected void onDestroy() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("hp", hp);
        if(preferences.contains("max")) {
            editor.putInt("max", score);
        } else {
            editor.putInt("max", Math.max(score, preferences.getInt("max", 0)));
        }
        editor.putInt("score", score);
        editor.putBoolean("sound", sound);
        editor.apply();
        preferences = getApplicationContext().getSharedPreferences("prefs", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putBoolean("sound", sound);
        editor.apply();
        preferences = getApplicationContext().getSharedPreferences("dirPrefs", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putBoolean("sound", sound);
        editor.apply();
        super.onDestroy();
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return Objects.requireNonNull(cm).getActiveNetworkInfo() != null && Objects.requireNonNull(cm.getActiveNetworkInfo()).isConnected();
    }

    public void menuOnClickQuote(View view) {
        switch (view.getId()) {
            case R.id.adviceItem:
                if(score >= 50) {
                    advice();
                } else {
                    Toast.makeText(this, getResources().getString(R.string.no_points), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.adItem:
                if(isNetworkConnected()) {
                    createAdShowDialog();
                } else {
                    noConnectionToast();
                }
                break;
            default:
                sound = !sound;
                setSoundIcon(floatingActionButton);
                break;
        }
    }

    private void noConnectionToast() {
        Toast.makeText(this, getResources().getString(R.string.net_connection), Toast.LENGTH_SHORT).show();
    }

    private void setSoundIcon(FloatingActionButton floatingActionButton) {
        if(sound) {
            floatingActionButton.setIcon(R.drawable.ic_volume_up_orange);
        } else {
            floatingActionButton.setIcon(R.drawable.ic_volume_off_orange);
        }
    }

    @SuppressLint("SetTextI18n")
    public void setScore() {
        scoreTextView.setText("" + score);
    }

    private void nextDirector() {
        if(cur == quotes.size()) {
            cur = 0;
            Collections.shuffle(quotes);
        }
        uncolorButtons();
        buttonsVisible();
        filmNames.clear();
        imdb.setClickable(false);
        filmName = quotes.get(cur).getFilmName();
        url = quotes.get(cur).getLink();
        String quote = quotes.get(cur).getText();

        filmNames.add(filmName);
        Collections.shuffle(allQuoteNames);
        for(int i = 0;i < allQuoteNames.size() && filmNames.size() < 4;i++) {
            if(!allQuoteNames.get(i).equals(filmName)) {
                filmNames.add(allQuoteNames.get(i));
            }
        }

        Collections.shuffle(filmNames);
        for(int i = 0;i < 4;i++) {
            buttons.get(i).setText(filmNames.get(i));
        }
        textView.setText(quote);

        for(int i = 0;i < 4;i++) {
            onButtonClick(buttons.get(i), filmName);
        }
        cur++;
    }

    @SuppressLint("SetTextI18n")
    private void iniXml() {
        textView = findViewById(R.id.quoteTextView);
        next = findViewById(R.id.nextQuoteImage);
        Button button = findViewById(R.id.firstQuote);
        buttons.add(button);
        button = findViewById(R.id.secondQuote);
        buttons.add(button);
        button = findViewById(R.id.thirdQuote);
        buttons.add(button);
        button = findViewById(R.id.fourthQuote);
        buttons.add(button);
        floatingActionButton = findViewById(R.id.settingsItem);
        setSoundIcon(floatingActionButton);
        hpImageView = findViewById(R.id.hpImageView);
        scoreTextView = findViewById(R.id.scoreTextView);
        scoreTextView.setText("" +score);

        imdb = findViewById(R.id.imdb);

        ImageView back = findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void onButtonClick(final Button button, final String dirName) {

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(floatingActionsMenu.isExpanded()) {
                    floatingActionsMenu.collapse();
                }
                isAdvice = false;
                isAnswered = true;
                next.setImageResource(R.drawable.arrow_right_bg);
                next.setClickable(true);
                imdb.setClickable(true);
                if(button.getText().toString().equals(filmName)) {
                    score += 50;
                    if(sound) {
                        playSound(true);
                    }
                } else {
                    hp--;
                    if(sound) {
                        playSound(false);
                    }
                }
                if(hp == 0) {
                    noHp();
                } else {
                    hpImageView.setImageResource(nums[hp-1]);
                }
                scoreTextView.setText("" + score);
                colorButtons(dirName);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_in);
                imdb.startAnimation(animation);
                imdb.setImageResource(R.drawable.imdb_logo);
                imdb.setVisibility(View.VISIBLE);
            }
        });
    }

    private void noHp() {
        if(floatingActionsMenu.isExpanded()) {
            floatingActionsMenu.collapse();
        }
        createRewardedAd();
        String message = getResources().getString(R.string.record) + preferences.getInt("max", 0) + "\n" + getResources().getString(R.string.last_res) + score;
        if(preferences.getInt("max", 0) < score) {
            message += "\n" + getResources().getString(R.string.new_best_res);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle(getResources().getString(R.string.no_points))
                .setMessage(message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setCancelable(false);
        if(!isAdUsed && isNetworkConnected()) {
            builder.setNeutralButton(getResources().getString(R.string.watch_ad_to_continue), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    showAd();
                    hp++;
                    hpImageView.setImageResource(R.drawable.heart);
                    isAdUsed = true;
                }
            });
        }
        builder.show();
    }

    private void colorButtons(String dirName) {
        for(int i = 0;i < 4;i++) {
            if(buttons.get(i).getText().equals(dirName)) {
                buttons.get(i).setBackgroundResource(R.drawable.shadow_green);
            } else {
                buttons.get(i).setBackgroundResource(R.drawable.shadow_red);
            }
        }
    }

    private void uncolorButtons() {
        for(int i = 0;i < 4;i++) {
            buttons.get(i).setBackgroundResource(R.drawable.button);
        }
    }

    private void playSound(boolean correct) {
        if(correct) {
            MediaPlayer mediaPlayer = MediaPlayer.create(QuoteActivity.this, R.raw.correct_answer);
            mediaPlayer.start();
        } else {
            MediaPlayer mediaPlayer = MediaPlayer.create(QuoteActivity.this, R.raw.wrong_answer);
            mediaPlayer.start();
        }
    }

    private void setLevel() {
        QuoteList directorArrayList = new QuoteList(this);
        quotes = directorArrayList.getQuotes();
        Collections.shuffle(quotes);

        buttons.clear();
        filmNames.clear();

        iniXml();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(floatingActionsMenu.isExpanded()) {
                    floatingActionsMenu.collapse();
                }
                nextDirector();
                isAnswered = false;
                next.setClickable(false);
                imdb.setVisibility(View.GONE);
                next.setImageResource(R.drawable.arrow_right_transparent);
            }
        });
    }
    private void fiftyFifty() {
        int c = 0, r;
        Random x = new Random();
        r = x.nextInt((2 - 1) + 1) + 1;

        if(!isAnswered) {
            if(r == 1) {
                for (int i = 0; i < 4 && c < 2; i++) {
                    if (!(buttons.get(i).getText().toString().equals(filmName))) {
                        buttons.get(i).setVisibility(View.INVISIBLE);
                        c++;
                    }
                }
            } else {
                for (int i = 3; i >= 0 && c < 2; i--) {
                    if (!(buttons.get(i).getText().toString().equals(filmName))) {
                        buttons.get(i).setVisibility(View.INVISIBLE);
                        c++;
                    }
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void advice() {
        if(floatingActionsMenu.isExpanded()) {
            floatingActionsMenu.collapse();
        }
        if(!isAnswered) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle(getResources().getString(R.string.advice))
                    .setPositiveButton(getResources().getText(R.string.fifty_fifty), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(score >= 25 && !isAnswered && !isAdvice) {
                                isAdvice = true;
                                fiftyFifty();
                                score -= 25;
                                scoreTextView.setText("" + score);
                            }
                        }
                    });
            builder.show();
        }
        scoreTextView.setText("" + score);
    }

    private void buttonsVisible() {
        for(int i = 0;i < 4;i++) {
            buttons.get(i).setVisibility(View.VISIBLE);
        }
    }

    public void openImdb(String url) {
        Intent intent = new Intent(this, ImdbActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

    private void createAdShowDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle(getResources().getString(R.string.ad))
                .setMessage(getResources().getString(R.string.ad_question))
                .setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showAd();
                    }
                });
        builder.show();
    }

    private void showAd() {
        if(rewardedAd.isLoaded()) {
            RewardedAdCallback callback = new RewardedAdCallback() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                    score += 25;
                    scoreTextView.setText("" + score);
                    createRewardedAd();
                }
            };
            rewardedAd.show(this, callback);
        }
    }

    private void setAllDirNames() {
        for(int i = 0;i < quotes.size();i++) {
            allQuoteNames.addAll(quotes.get(i).getWrongAnswers());
            allQuoteNames.add(quotes.get(i).getFilmName());
        }
        Collections.shuffle(quotes);
    }
}
