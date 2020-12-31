package com.kirvelstudios.cinemaquiz.DirectorLevelActivities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.GenericTransitionOptions;
import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.kirvelstudios.cinemaquiz.DirectorArrayList;
import com.kirvelstudios.cinemaquiz.Directors.Director;
import com.kirvelstudios.cinemaquiz.ImdbActivity;
import com.kirvelstudios.cinemaquiz.R;
import com.kirvelstudios.cinemaquiz.databinding.ActivityDirBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

public class AllDirActivity extends AppCompatActivity {

    ActivityDirBinding binding;

    ArrayList <Button> buttons = new ArrayList<>();
    ArrayList<Director> directors = new ArrayList<>();
    ArrayList <String> dirNames = new ArrayList<>(), allDirNames = new ArrayList<>();
    ArrayList <Integer> posters = new ArrayList<>();
    int curDir = 0, score = 0, posterID = 0, hp;
    boolean isAdvice = false, isAdUsed = false;
    int [] nums;
    String directorName;
    boolean isAnswered = false, sound = false;
    SharedPreferences preferences;
    RewardedAd rewardedAd;

    private void createRewardedAd() {
        rewardedAd = new RewardedAd(this, "your add id");
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

        binding = ActivityDirBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = getApplicationContext().getSharedPreferences("dirPrefs", Context.MODE_PRIVATE);
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

        hp = preferences.getInt("hp", 3);
        if(hp > 0) {
            score = preferences.getInt("score",0);
        }
        if(hp == 0) {
            hp = 3;
        }
        nums = new int[] {R.drawable.heart, R.drawable.heart2, R.drawable.heart3};
        binding.hpImageView.setImageResource(nums[hp-1]);
        setScore();
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
        preferences = getApplicationContext().getSharedPreferences("qPrefs", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putBoolean("sound", sound);
        editor.apply();
        super.onDestroy();
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return Objects.requireNonNull(cm).getActiveNetworkInfo() != null && Objects.requireNonNull(cm.getActiveNetworkInfo()).isConnected();
    }

    public void menuOnClickVoid(View view) {
        switch (view.getId()) {
            case R.id.adviceItem:
                if(score >= 10) {
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
                setSoundIcon();
                break;
        }
    }

    private void noConnectionToast() {
        Toast.makeText(this, getResources().getString(R.string.net_connection), Toast.LENGTH_SHORT).show();
    }

    private void setSoundIcon() {
        if(sound) {
            binding.settingsItem.setIcon(R.drawable.ic_volume_up_orange);
        } else {
            binding.settingsItem.setIcon(R.drawable.ic_volume_off_orange);
        }
    }

    @SuppressLint("SetTextI18n")
    public void setScore() {
        binding.scoreTextView.setText("" + score);
    }

    private void nextDirector() {
        if(curDir == directors.size()) {
            curDir = 0;
            Collections.shuffle(directors);
        }
        uncolorButtons();
        buttonsVisible();
        dirNames.clear();

        directorName = directors.get(curDir).getName();
        dirNames.add(directorName);
        Collections.shuffle(allDirNames);
        for(int i = 0;i < allDirNames.size() && dirNames.size() < 4;i++) {
            if(!allDirNames.get(i).equals(directorName)) {
                dirNames.add(allDirNames.get(i));
            }
        }

        Collections.shuffle(dirNames);
        for(int i = 0;i < 4;i++) {
            buttons.get(i).setText(dirNames.get(i));
        }
        posters = directors.get(curDir).getPosters();
        Collections.shuffle(posters);
        Glide.with(getApplicationContext()).load(posters.get(0)).transition(GenericTransitionOptions.<Drawable>with(R.anim.right_in)).into(binding.directorImageView1);

        for(int i = 0;i < 4;i++) {
            onButtonClick(buttons.get(i), directorName);
        }
        curDir++;
    }

    @SuppressLint("SetTextI18n")
    private void iniXml() {
        buttons.add(binding.firstDirector);
        buttons.add(binding.secondDirector);
        buttons.add(binding.thirdDirector);
        buttons.add(binding.fourthDirector);
        setSoundIcon();
        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void onButtonClick(final Button button, final String dirName) {
        isAdvice = false;
        posterID = 0;

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(binding.floatingActionMenu.isExpanded()) {
                    binding.floatingActionMenu.collapse();
                }
                isAnswered = true;
                binding.nextDirectorImageView.setImageResource(R.drawable.arrow_right_bg);
                binding.nextDirectorImageView.setClickable(true);
                if(button.getText().toString().equals(directorName)) {
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
                    binding.hpImageView.setImageResource(nums[hp-1]);
                }
                binding.scoreTextView.setText("" + score);
                colorButtons(dirName);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_in);
                binding.imdb.startAnimation(animation);
                binding.imdb.setImageResource(R.drawable.imdb_logo);
                binding.imdb.setVisibility(View.VISIBLE);
            }
        });
    }

    private void noHp() {
        if(binding.floatingActionMenu.isExpanded()) {
            binding.floatingActionMenu.collapse();
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
                    binding.hpImageView.setImageResource(R.drawable.heart);
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
            MediaPlayer mediaPlayer = MediaPlayer.create(AllDirActivity.this, R.raw.correct_answer);
            mediaPlayer.start();
        } else {
            MediaPlayer mediaPlayer = MediaPlayer.create(AllDirActivity.this, R.raw.wrong_answer);
            mediaPlayer.start();
        }
    }

    private void setLevel() {
        DirectorArrayList directorArrayList = new DirectorArrayList();
        directors = directorArrayList.getDirectors();
        Collections.shuffle(directors);

        buttons.clear();
        dirNames.clear();
        posters.clear();

        iniXml();

        binding.nextDirectorImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.floatingActionMenu.isExpanded()) {
                    binding.floatingActionMenu.collapse();
                }
                nextDirector();
                isAnswered = false;
                binding.nextDirectorImageView.setClickable(false);
                binding.nextDirectorImageView.setImageResource(R.drawable.arrow_right_transparent);
                binding.imdb.setVisibility(View.GONE);
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
                    if (!(buttons.get(i).getText().toString().equals(directorName))) {
                        buttons.get(i).setVisibility(View.INVISIBLE);
                        c++;
                    }
                }
            } else {
                for (int i = 3; i >= 0 && c < 2; i--) {
                    if (!(buttons.get(i).getText().toString().equals(directorName))) {
                        buttons.get(i).setVisibility(View.INVISIBLE);
                        c++;
                    }
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void advice() {
        if(binding.floatingActionMenu.isExpanded()) {
            binding.floatingActionMenu.collapse();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle(getResources().getString(R.string.advice))
                .setPositiveButton(getResources().getText(R.string.fifty_fifty), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(score >= 25 && !isAnswered && !isAdvice) {
                            isAdvice = true;
                            fiftyFifty();
                            score -= 25;
                            binding.scoreTextView.setText("" + score);
                        } else {
                            Toast.makeText(AllDirActivity.this, getResources().getString(R.string.no_points), Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton(getResources().getString(R.string.other_poster), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(score >= 10 && !isAnswered && !isAdvice) {
                            if(posterID+1 != posters.size()) {
                                anotherMovie();
                                score -= 10;
                                binding.scoreTextView.setText("" + score);
                            } else {
                                Toast.makeText(getApplicationContext(), getResources().getString(R.string.no_posters), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
        builder.show();
        binding.scoreTextView.setText("" + score);
    }

    private void anotherMovie() {
        if(posterID+1 != posters.size()) {
            posterID++;
            binding.directorImageView1.setImageResource(posters.get(posterID));
        }
    }

    private void buttonsVisible() {
        for(int i = 0;i < 4;i++) {
            buttons.get(i).setVisibility(View.VISIBLE);
        }
    }

    public void openImdb(View view) {
        Intent intent = new Intent(this, ImdbActivity.class);
        intent.putExtra("url", directors.get(curDir-1).getUrl());
        Toast.makeText(this, directors.get(curDir-1).getUrl(), Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    private void createAdShowDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Реклама")
                .setMessage("Смотреть рекламу? Вы получите 50 очков")
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("Да", new DialogInterface.OnClickListener() {
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
                    score += 50;
                    binding.scoreTextView.setText("" + score);
                    createRewardedAd();
                }
            };
            rewardedAd.show(this, callback);
        }
    }

    private void setAllDirNames() {
        for(int i = 0;i < directors.size();i++) {
            allDirNames.addAll(directors.get(i).getDirectors());
        }
        Collections.shuffle(directors);
    }

}
