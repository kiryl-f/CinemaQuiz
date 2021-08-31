package com.kirvelstudios.cinemaquiz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.GenericTransitionOptions;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.kirvelstudios.cinemaquiz.Retrofit.MovieService;
import com.kirvelstudios.cinemaquiz.Retrofit.Result;
import com.kirvelstudios.cinemaquiz.Retrofit.RetrofitInstance;
import com.kirvelstudios.cinemaquiz.databinding.ActivityGuessFilmBinding;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.kirvelstudios.cinemaquiz.R.drawable.shadow_green;
import static com.kirvelstudios.cinemaquiz.R.drawable.shadow_red;

public class EasyGuessFilmActivity extends AppCompatActivity {

    ActivityGuessFilmBinding binding;

    ArrayList<Movie> movies = new ArrayList<>();
    int curFilm = 0, score = 0, hp = 3;
    String filmName, url = "", nameType = "", type = "", language = "", region = "", key = "";
    ArrayList <String> used = new ArrayList<>();
    int[] nums;

    private RequestQueue imdbRequestQueue;

    String tmdbLink1, tmdbLink2, imdbLink;
    private boolean flag = true;
    private boolean isAdvice = false, isStarted = false, isAnswered = false, isAdUsed = false, sound = false, isShuffeled = false;
    private ArrayList <Button> buttons = new ArrayList<>();

    private RewardedAd rewardedAd;

    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = ActivityGuessFilmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createActivity();
    }

    @Override
    protected void onStop() {
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
        preferences = getApplicationContext().getSharedPreferences("dirPrefs", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putBoolean("sound", sound);
        editor.apply();
        preferences = getApplicationContext().getSharedPreferences("qPrefs", Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putBoolean("sound", sound);
        editor.apply();
        super.onStop();
    }

    private void createActivity() {
        nums = new int[] {R.drawable.heart, R.drawable.heart2, R.drawable.heart3};

        ImageView button = findViewById(R.id.backButton);
        button.setOnClickListener(v -> finish());

        preferences = getApplicationContext().getSharedPreferences("prefs", Context.MODE_PRIVATE);
        hp = preferences.getInt("hp", 3);
        sound = preferences.getBoolean("sound", false);
        if(hp > 0) {
            score = preferences.getInt("score",0);
        }
        iniXmlElements();

        if(hp == 0) {
            hp = 3;
        }
        binding.hpImageView.setImageResource(nums[hp-1]);
        setScore();

        movies.clear();
        binding.nextFilmImage.setImageResource(R.drawable.arrow_right_transparent);
        buttonsClickable(false);

        MobileAds.initialize(this, initializationStatus -> {
        });

        createRewardedAd();

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        tmdbLink1 = intent.getStringExtra("tmdbLink1");
        tmdbLink2 = "?api_key=*key*language=ru-RU";
        nameType = intent.getStringExtra("nameType");
        type = intent.getStringExtra("type");
        language = intent.getStringExtra("language");
        region = intent.getStringExtra("region");
        key = intent.getStringExtra("key");

        imdbRequestQueue = Volley.newRequestQueue(this);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(movies.size() > 2) {
                    if(!isShuffeled) {
                        Collections.shuffle(movies);
                        isShuffeled = true;
                    }
                }
                if(movies.size() > 250) {
                    runOnUiThread(() -> {
                        if(!isStarted) {
                            binding.nextFilmImage.setClickable(true);
                            binding.nextFilmImage.setImageResource(R.drawable.arrow_right);
                            binding.nextFilmImage.callOnClick();
                            binding.filmProgressBar.setVisibility(View.INVISIBLE);
                            setOnClickButtons();
                            isStarted = true;
                        }

                    });

                } else {
                    runOnUiThread(() -> {
                        binding.nextFilmImage.setClickable(false);
                        binding.nextFilmImage.setImageResource(R.drawable.arrow_right_transparent);
                        binding.filmProgressBar.setVisibility(VISIBLE);
                        isStarted = false;
                    });
                }
            }
        };
        final Timer timer = new Timer();
        timer.schedule(task, 50, 50);

        setAllMovies();

        binding.nextFilmImage.setOnClickListener(v -> {
            if(movies.size() < 1) {
                setAllMovies();
            }
            if(binding.floatingActionMenu.isExpanded()) {
                binding.floatingActionMenu.collapse();
            }
            if(flag) {
                nextFilm();
                flag = false;
                curFilm++;
                isAnswered = false;
                binding.nextFilmImage.setImageResource(R.drawable.arrow_right_transparent);
            }
        });

        binding.imdb.setOnClickListener(v -> openIMDBWebView());

    }

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

    private void setSoundIcon(FloatingActionButton floatingActionButton) {
        if(sound) {
            floatingActionButton.setIcon(R.drawable.ic_volume_up_orange);
        } else {
            floatingActionButton.setIcon(R.drawable.ic_volume_off_orange);
        }
    }

    private void iniXmlElements() {
        setButtons();
        setSoundIcon(binding.settingsItem);
        binding.refreshImageView.setOnClickListener(v -> refreshImage("https://image.tmdb.org/t/p/w780"+movies.get(curFilm).getBackdropPath()));
    }

    private void playSound(boolean correct) {
        if(correct) {
            MediaPlayer mediaPlayer = MediaPlayer.create(EasyGuessFilmActivity.this, R.raw.correct_answer);
            mediaPlayer.start();
        } else {
            MediaPlayer mediaPlayer = MediaPlayer.create(EasyGuessFilmActivity.this, R.raw.wrong_answer);
            mediaPlayer.start();
        }
    }

    private void setButtons() {
        Button button = findViewById(R.id.firstFilm); button.setBackground(getDrawable(R.drawable.button));
        buttons.add(button);
        button = findViewById(R.id.secondFilm);
        buttons.add(button);
        button = findViewById(R.id.thirdFilm);
        buttons.add(button);
        button = findViewById(R.id.fourthFilm);
        buttons.add(button);
        buttonsVisible();
    }

    private void setOnClickButtons() {
        for(int i = 0;i < 4;i++) {
            final Button button = buttons.get(i);
            buttons.get(i).setOnClickListener(v -> {
                isAnswered = true;
                if(binding.floatingActionMenu.isExpanded()) {
                    binding.floatingActionMenu.collapse();
                }
                binding.nextFilmImage.setImageResource(R.drawable.arrow_right_bg);
                flag = true;
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_in);
                binding.imdb.startAnimation(animation);
                if(type.equals("tv")) {
                    binding.imdb.setImageResource(R.drawable.ic_link_black_24dp);
                } else {
                    binding.imdb.setImageResource(R.drawable.imdb_logo);
                }
                binding.imdb.setClickable(true);
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
                    binding.hpImageView.setImageResource(nums[hp-1]);
                }
                setScore();
                colorButtons(filmName);
            });
        }
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
                .setPositiveButton("Ok", (dialog, which) -> finish())
                .setCancelable(false);
        if(!isAdUsed && isNetworkConnected()) {
            builder.setNeutralButton(getResources().getString(R.string.watch_ad_to_continue), (dialog, which) -> {
                showAd();
                hp++;
                binding.hpImageView.setImageResource(R.drawable.heart);
                isAdUsed = true;
            });
        }
        builder.show();
    }

    @SuppressLint("SetTextI18n")
    private void setScore() {
        TextView textView = findViewById(R.id.scoreTextView);
        textView.setText("" + score);
    }

    private void setAllMovies() {
        for(int i = 1;i <= 40;i++) {
            getMovies(i);
        }
    }

    private void nextFilm() {
        if(curFilm == movies.size()) {
            curFilm = 0;
            Collections.shuffle(movies);
        }
        buttonsVisible();
        isAdvice = false;
        if(movies.size() < 500) {
            setAllMovies();
            Collections.shuffle(movies);
        }
        uncolorButtons();
        buttonsClickable(false);
        refreshImage("https://image.tmdb.org/t/p/w780"+movies.get(curFilm).getBackdropPath());
        setMovieImdbLinkAndGenre(movies.get(curFilm).getId());
        setButtonsText(movies.get(curFilm));
        filmName = movies.get(curFilm).getTitle();
        binding.imdb.setImageResource(R.drawable.lock);
        binding.imdb.setClickable(false);
        Collections.shuffle(movies);
    }

    private void refreshImage(String url) {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(this);
        circularProgressDrawable.setStrokeWidth(10f);
        circularProgressDrawable.setCenterRadius(40f);
        circularProgressDrawable.setColorSchemeColors(getColor(R.color.colorAccent));
        circularProgressDrawable.start();
        Glide.with(getApplicationContext())
                .load(url)
                .placeholder(circularProgressDrawable)
                .transition(GenericTransitionOptions.with(R.anim.right_in))
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(12)))
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        binding.refreshImageView.setVisibility(VISIBLE);
                        TextView textView = findViewById(R.id.noConTextView);
                        textView.setVisibility(VISIBLE);
                        buttonsClickable(false);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        binding.refreshImageView.setVisibility(GONE);
                        TextView textView = findViewById(R.id.noConTextView);
                        textView.setVisibility(GONE);
                        buttonsClickable(true);
                        return false;
                    }
                })
                .into(binding.filmImageView);
    }

    private void noConnectionToast() {
        Toast.makeText(this, getResources().getString(R.string.net_connection), Toast.LENGTH_SHORT).show();
    }

    private void createAdShowDialog() {
        if(binding.floatingActionMenu.isExpanded()) {
            binding.floatingActionMenu.collapse();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle(getResources().getString(R.string.ad))
                .setMessage(getResources().getString(R.string.ad_question))
                .setNegativeButton(getResources().getString(R.string.no), (dialog, which) -> {

                }).setPositiveButton(getResources().getString(R.string.yes), (dialog, which) -> showAd());
        builder.show();
    }

    private void showAd() {
        if(rewardedAd.isLoaded()) {
            RewardedAdCallback callback = new RewardedAdCallback() {
                @Override
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                    score += 25;
                    setScore();
                }
            };
            rewardedAd.show(EasyGuessFilmActivity.this, callback);
            createRewardedAd();
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return Objects.requireNonNull(cm).getActiveNetworkInfo() != null && Objects.requireNonNull(cm.getActiveNetworkInfo()).isConnected();
    }

    private void getMovies(int page) {
        MovieService service = RetrofitInstance.getService();
        Call<Result> call = service.getMovie(page, key, language, region);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, retrofit2.Response<Result> response) {
                Result result = response.body();
                Log.d("result", String.valueOf(result.getTotalResults()));
                movies.addAll(result.getResults());Log.d("size", "" + movies.size());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }

        });
    }

    private String getFirstWord(String title) {
        int space = title.length();
        for(int i = 0;i < title.length();i++) {
            if(title.charAt(i) == ' ') {
                space = i;
                break;
            }
        }
        return title.substring(0,space);
    }

    private void setMovieImdbLinkAndGenre(final Integer id) {
        final String url = tmdbLink1 + id + tmdbLink2;
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            try {
                if(type.equals("tv")) {
                    imdbLink = response.getString("homepage");
                } else {
                    imdbLink = "https://www.imdb.com/title/" + response.getString("imdb_id");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, Throwable::printStackTrace);
        imdbRequestQueue.add(request);
    }

    public void openIMDBWebView() {
        Intent intent = new Intent(this, ImdbActivity.class);
        intent.putExtra("url", imdbLink);
        startActivity(intent);
    }

    private void setButtonsText(Movie movie) {
        ArrayList <String> list = new ArrayList<>();
        list.add(movie.getTitle());

        if(used.size() == 20) {
            used.clear();
        }

        used.add(movie.getTitle());
        for(int i = 0;i < movies.size();i++) {
            if(list.size() == 4) { break; }
            Movie curMovie = movies.get(i);
            if(getFirstWord(curMovie.getTitle()).equals(getFirstWord(movie.getTitle())) && !getFirstWord(movie.getTitle()).equals("The") && Collections.frequency(list, curMovie.getTitle()) == 0
                    && Collections.frequency(used, curMovie.getTitle()) == 0) {
                list.add(curMovie.getTitle());
                used.add(curMovie.getTitle());
            }
        }
        for(int i = 0;i < movies.size();i++) {
            if(list.size() == 4) { break; }
            Movie curMovie = movies.get(i);
            if(Collections.frequency(list, curMovie.getTitle()) == 0) {
                if(curMovie.getGenreIds().size() > 0 && movie.getGenreIds().size() > 0){
                    if(curMovie.getGenreIds().get(0).equals(movie.getGenreIds().get(0))) {
                        list.add(curMovie.getTitle());
                        used.add(curMovie.getTitle());
                    }
                } else {
                    list.add(curMovie.getTitle());
                    used.add(curMovie.getTitle());
                }
            }
        }
        for(int i = 0;i < movies.size();i++) {
            if(list.size() == 4) { break; }
            Movie curMovie = movies.get(i);
            if(getFirstWord(curMovie.getTitle()).equals(getFirstWord(movie.getTitle())) && !getFirstWord(movie.getTitle()).equals("The")
                    && Collections.frequency(list, curMovie.getTitle()) == 0
                    && Collections.frequency(used, curMovie.getTitle()) == 0) {
                list.add(curMovie.getTitle());
                used.add(curMovie.getTitle());
            }
        }

        if(list.size() < 4) {
            for(int i = 0;i < movies.size() && list.size() < 4;i++) {
                if(!movies.get(i).getTitle().equals(movie.getTitle()) && Collections.frequency(list, movies.get(i).getTitle()) == 0) {
                    list.add(movies.get(i).getTitle());
                }
            }
        }
        Collections.shuffle(list);
        for(int i = 0;i < 4;i++) {
            buttons.get(i).setText(list.get(i));
        }
    }

    private void colorButtons(String filmName) {
        for(int i = 0;i < 4;i++) {
            if(buttons.get(i).getText().equals(filmName)) {
                buttons.get(i).setBackgroundResource(shadow_green);
            } else {
                buttons.get(i).setBackgroundResource(shadow_red);
            }
            buttons.get(i).setClickable(false);
        }
    }

    private void uncolorButtons() {
        for(int i = 0;i < 4;i++) {
            buttons.get(i).setClickable(true);
            buttons.get(i).setBackgroundResource(R.drawable.button);
        }
    }

    private void buttonsClickable(boolean clickable) {
        for(int i = 0;i < 4;i++) {
            buttons.get(i).setClickable(clickable);
        }
    }

    private void fiftyFifty(final String filmName) {
        if(binding.floatingActionMenu.isExpanded()) {
            binding.floatingActionMenu.collapse();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle(getResources().getString(R.string.advice))
                .setMessage(getResources().getString(R.string.fifty_fifty))
                .setPositiveButton(getResources().getString(R.string.yes), (dialog, which) -> {
                    if(score >= 25) {
                        score -= 25;
                        setScore();

                        int c = 0, r;
                        Random x = new Random();
                        r = x.nextInt((2 - 1) + 1) + 1;

                        if(!isAdvice && buttons.size() == 4) {
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
                        isAdvice = true;
                    } else {
                        Toast.makeText(EasyGuessFilmActivity.this, getResources().getString(R.string.no_points), Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton(getResources().getString(R.string.no), (dialog, which) -> {}).setNeutralButton(getResources().getString(R.string.ad_question), (dialog, which) -> showAd());
        builder.show();
    }

    private void buttonsVisible() {
        for(int i = 0;i < 4;i++) {
            buttons.get(i).setVisibility(View.VISIBLE);
        }
    }

    public void menuOnClick(View view) {
        switch (view.getId()) {
            case R.id.adviceItem:
                if(isNetworkConnected()) {
                    if(!isAdvice && !isAnswered) {
                        fiftyFifty(filmName);
                    }
                } else {
                    noConnectionToast();
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
                setSoundIcon(binding.settingsItem);
                break;
        }
    }
}
