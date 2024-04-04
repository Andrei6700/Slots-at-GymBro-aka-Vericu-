package com.example.pacanele;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.pacanele.ImageScrolling.IEventEnd;
import com.example.pacanele.ImageScrolling.ImageScrolling;
import com.example.pacanele.ImageScrolling.PayLinesCombinations;
//import com.example.pacanele.ImageScrolling.PayLinesCombinations;


import java.util.Random;

public class GamblingActivity extends AppCompatActivity implements IEventEnd {
    private static final String TAG = "myApp";
    private Button btnGoToMainMenu;
    ImageView btn_start;
    ImageScrolling image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13, image14, image15;
    TextView txt_score;
    int count_done = 0;
    private int betAmount = 50; // default bet
    private MediaPlayer mediaPlayer;
    private MediaPlayer backgroundPlayer;
    private boolean isScrolling ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambling);

        backgroundPlayer = MediaPlayer.create(this, R.raw.gymbackground); // background sound
        backgroundPlayer.setVolume(0.02f, 0.02f); //set the volume to 50%
        backgroundPlayer.setLooping(true); // the sound will be played in loop
        backgroundPlayer.start();

        mediaPlayer = MediaPlayer.create(this, R.raw.rollsound); // sound from spinning
        mediaPlayer.setVolume(0.5f, 0.5f); // set the volume to 100%

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        btnGoToMainMenu = findViewById(R.id.btnGoToMainMenu);
        btn_start = findViewById(R.id.btn_start);

        image1 =findViewById(R.id.image1);
        image2 =findViewById(R.id.image2);
        image3 =findViewById(R.id.image3);
        image4 =findViewById(R.id.image4);
        image5 =findViewById(R.id.image5);
        image6 =findViewById(R.id.image6);
        image7 =findViewById(R.id.image7);
        image8 =findViewById(R.id.image8);
        image9 =findViewById(R.id.image9);
        image10=findViewById(R.id.image10);
        image11=findViewById(R.id.image11);
        image12=findViewById(R.id.image12);
        image13=findViewById(R.id.image13);
        image14=findViewById(R.id.image14);
        image15=findViewById(R.id.image15);

        txt_score = findViewById(R.id.txt_score);

        image1.setEventEnd(GamblingActivity.this);
        image2.setEventEnd(GamblingActivity.this);
        image3.setEventEnd(GamblingActivity.this);
        image4.setEventEnd(GamblingActivity.this);
        image5.setEventEnd(GamblingActivity.this);
        image6.setEventEnd(GamblingActivity.this);
        image7.setEventEnd(GamblingActivity.this);
        image8.setEventEnd(GamblingActivity.this);
        image9.setEventEnd(GamblingActivity.this);
        image10.setEventEnd(GamblingActivity.this);
        image11.setEventEnd(GamblingActivity.this);
        image12.setEventEnd(GamblingActivity.this);
        image13.setEventEnd(GamblingActivity.this);
        image14.setEventEnd(GamblingActivity.this);
        image15.setEventEnd(GamblingActivity.this);

        RadioButton bet50 = findViewById(R.id.bet50);
        RadioButton bet100 = findViewById(R.id.bet100);
        RadioButton betAll = findViewById(R.id.betAll);

        bet50.setChecked(true); // default val checked in radiobtn

        bet50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                betAmount = 50;
                bet50.setChecked(true); // check 50
                bet100.setChecked(false);
                betAll.setChecked(false);
            }
        });

        bet100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                betAmount = 100;
                bet50.setChecked(false);
                bet100.setChecked(true);
                betAll.setChecked(false);
            }
        });

        betAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FoundsStore.SCORE >= 0) {
                    betAmount = FoundsStore.SCORE;
                    bet50.setChecked(false);
                    bet100.setChecked(false);
                    betAll.setChecked(true);
                } else {
                    Toast.makeText(GamblingActivity.this, "You don't have enough money to bet", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnGoToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isScrolling) {
                    isScrolling = true;
                    if (betAmount <= FoundsStore.SCORE) {
                        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                            mediaPlayer.start();
                        }

                        int spinCost = betAmount;

                        FoundsStore.SCORE -= spinCost;
                        txt_score.setText(String.valueOf(FoundsStore.SCORE));

                        image1.setValueRandom(new Random().nextInt(8),
                                new Random().nextInt(8));
                        Log.v(TAG, "IMAGE 1 >>> "  );

                        image2.setValueRandom(new Random().nextInt(8),
                                new Random().nextInt(8));
                        Log.v(TAG, "IMAGE 2 >>> "  );

                        image3.setValueRandom(new Random().nextInt(8),
                                new Random().nextInt(8));
                        Log.v(TAG, "IMAGE 3 >>> "  );

                        image4.setValueRandom(new Random().nextInt(8),
                                new Random().nextInt(8));
                        Log.v(TAG, "IMAGE 4 >>> "  );

                        image5.setValueRandom(new Random().nextInt(8),
                                new Random().nextInt(8));
                        Log.v(TAG, "IMAGE 5 >>> "  );

                        image6.setValueRandom(new Random().nextInt(8),
                                new Random().nextInt(8));
                        Log.v(TAG, "IMAGE 6 >>> "  );

                        image7.setValueRandom(new Random().nextInt(8),
                                new Random().nextInt(8));
                        Log.v(TAG, "IMAGE 7 >>> "  );

                        image8.setValueRandom(new Random().nextInt(8),
                                new Random().nextInt(8));
                        Log.v(TAG, "IMAGE 8 >>> "  );

                        image9.setValueRandom(new Random().nextInt(8),
                                new Random().nextInt(8));
                        Log.v(TAG, "IMAGE 9 >>> "  );

                        image10.setValueRandom(new Random().nextInt(8),
                                new Random().nextInt(8));
                        Log.v(TAG, "IMAGE 10 >>> "  );

                        image11.setValueRandom(new Random().nextInt(8),
                                new Random().nextInt(8));
                        Log.v(TAG, "IMAGE 11 >>> "  );

                        image12.setValueRandom(new Random().nextInt(8),
                                new Random().nextInt(8));
                        Log.v(TAG, "IMAGE 12 >>> "  );

                        image13.setValueRandom(new Random().nextInt(8),
                                new Random().nextInt(8));
                        Log.v(TAG, "IMAGE 13 >>> "  );

                        image14.setValueRandom(new Random().nextInt(8),
                                new Random().nextInt(8));
                        Log.v(TAG, "IMAGE 14 >>> "  );

                        image15.setValueRandom(new Random().nextInt(8),
                                new Random().nextInt(8));
                        Log.v(TAG, "IMAGE 15 >>> "  );

                    } else {
                        Toast.makeText(GamblingActivity.this, "You not enough money", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

      @Override
      protected void onPause() {
          super.onPause();
          if(backgroundPlayer !=null){
                backgroundPlayer.pause();
                if (isFinishing()) {
                    backgroundPlayer.stop();
                    backgroundPlayer.release();
                }
          }
      }

      @Override
      protected void onDestroy() {
          super.onDestroy();
          if (backgroundPlayer != null) {
              backgroundPlayer.stop();
              backgroundPlayer.release();
          }
      }

    @Override
    public void eventEnd(int result, int count) {
        count_done++;
        //  keep track of how many images have finished scrolling
        if (count_done < 15) // there are 15 images
            return;
        count_done = 0;
        isScrolling = false;

            if (PayLinesCombinations.PayLines1(image1, image2, image3, image4, image5)) {
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            if (PayLinesCombinations.PayLines2(image6, image7, image8, image9, image10)) {
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines3(image11, image12, image13, image14, image15)) {
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines4(image1, image6, image11)) {
                Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines5(image2, image7, image12)) {
                Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines6(image3, image8, image13)) {
                Toast.makeText(this, "6", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines7(image4, image9, image14)) {
                Toast.makeText(this, "7", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines8(image5, image10, image15)) {
                Toast.makeText(this, "8", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines9(image1, image7, image13, image9, image5)) {
                Toast.makeText(this, "9", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines10(image11, image7, image3, image9, image15)) {
                Toast.makeText(this, "10", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines11(image6, image12, image8, image14, image10)) {
                Toast.makeText(this, "11", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines12(image6, image7, image13, image9, image10)) {
                Toast.makeText(this, "12", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines13(image11, image7, image13, image9, image5)) {
                Toast.makeText(this, "13", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines14(image11, image7, image3, image9, image5)) {
                Toast.makeText(this, "14", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines15(image11, image7, image13, image9, image5)) {
                Toast.makeText(this, "15", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines16(image1, image7, image13, image9, image15)) {
                Toast.makeText(this, "16", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines17(image1, image2, image8, image4, image5)) {
                Toast.makeText(this, "17", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines18(image6, image2, image8, image4, image10)) {
                Toast.makeText(this, "18", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines19(image6, image7, image2, image9, image10)) {
                Toast.makeText(this, "19", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines20(image1, image2, image4, image5, image13)) {
                Toast.makeText(this, "20", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines21(image1, image2, image4, image5, image13)) {
                Toast.makeText(this, "21", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines22(image1, image2, image8, image4, image5)) {
                Toast.makeText(this, "22", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines23(image6, image7, image3, image9, image10)) {
                Toast.makeText(this, "23", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines24(image11, image12, image8, image14, image15)) {
                Toast.makeText(this, "24", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines25(image1, image2, image3, image9, image15)) {
                Toast.makeText(this, "25", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines26(image6, image7, image8, image14, image15)) {
                Toast.makeText(this, "26", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if (PayLinesCombinations.PayLines27(image11, image12, image13, image9, image5)) {
                Toast.makeText(this, "27", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if ( PayLinesCombinations.PayLines28(image11, image12, image3, image14, image15)) {
                Toast.makeText(this, "28", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            if ( PayLinesCombinations.PayLines29(image11, image7, image8, image9, image5)) {
                Toast.makeText(this, "29", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
        }


    public void openActivity1 () {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
