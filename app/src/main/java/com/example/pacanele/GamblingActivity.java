package com.example.pacanele;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
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


import java.util.Random;

public class GamblingActivity extends AppCompatActivity implements IEventEnd {
    private Button btnGoToMainMenu;
    ImageView btn_start;
    ImageScrolling image, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13, image14, image15;
    TextView txt_score;
    int count_done = 0;
    private int betAmount = 50; // default bet
    boolean win = false;
    Random random = new Random();
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambling);

        MediaPlayer backgroundPlayer = MediaPlayer.create(this, R.raw.gymbackground); // background sound
        backgroundPlayer.setVolume(0.5f, 0.5f); //set the volume to 50%
        backgroundPlayer.setLooping(true); // the sound will be played in loop
        backgroundPlayer.start();

        mediaPlayer = MediaPlayer.create(this, R.raw.rollsound); // sound from spinning
        mediaPlayer.setVolume(1.0f, 1.0f); // set the volume to 100%

        btnGoToMainMenu = findViewById(R.id.btnGoToMainMenu);
        btnGoToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        btn_start = findViewById(R.id.btn_start);

        image = findViewById(R.id.image);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);
        image10 = findViewById(R.id.image10);
        image11 = findViewById(R.id.image11);
        image12 = findViewById(R.id.image12);
        image13 = findViewById(R.id.image13);
        image14 = findViewById(R.id.image14);
        image15 = findViewById(R.id.image15);

        txt_score = findViewById(R.id.txt_score);

        image.setEventEnd(GamblingActivity.this);
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

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (betAmount <= FoundsStore.SCORE) {
                    if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                        mediaPlayer.start();
                    }
                    btn_start.setVisibility(View.VISIBLE);

                    int spinCost = betAmount;

                    FoundsStore.SCORE -= spinCost;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));

                    // Utilizarea obiectului random deja creat
                    int randomValue = random.nextInt(8);
                    image.setValueRandom   (random.nextInt(8), random.nextInt((15 - 5) + 1) + 5);
                    image2.setValueRandom  (random.nextInt(8), random.nextInt((15 - 5) + 1) + 5);
                    image3.setValueRandom  (random.nextInt(8), random.nextInt((15 - 5) + 1) + 5);
                    image4.setValueRandom  (random.nextInt(8), random.nextInt((15 - 5) + 1) + 5);
                    image5.setValueRandom  (random.nextInt(8), random.nextInt((15 - 5) + 1) + 5);
                    image6.setValueRandom  (random.nextInt(8), random.nextInt((15 - 5) + 1) + 5);
                    image7.setValueRandom  (random.nextInt(8), random.nextInt((15 - 5) + 1) + 5);
                    image8.setValueRandom  (random.nextInt(8), random.nextInt((15 - 5) + 1) + 5);
                    image9.setValueRandom  (random.nextInt(8), random.nextInt((15 - 5) + 1) + 5);
                    image10.setValueRandom (random.nextInt(8), random.nextInt((15 - 5) + 1) + 5);
                    image11.setValueRandom (random.nextInt(8), random.nextInt((15 - 5) + 1) + 5);
                    image12.setValueRandom (random.nextInt(8), random.nextInt((15 - 5) + 1) + 5);
                    image13.setValueRandom (random.nextInt(8), random.nextInt((15 - 5) + 1) + 5);
                    image14.setValueRandom (random.nextInt(8), random.nextInt((15 - 5) + 1) + 5);
                    image15.setValueRandom (random.nextInt(8), random.nextInt((15 - 5) + 1) + 5);

                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                } else {
                    Toast.makeText(GamblingActivity.this, "You not enough money", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void eventEnd(int result, int count) {
        if (count_done < 2)
            count_done++;
        else {
            int randomChance = random.nextInt(100);
            count_done = 0;

            win = false;

            //if () {  fac cum e aici si pun in oridine gen 5 5 5 6 6 6 7 7 .... etc
            if (randomChance < 1 && PayLinesCombinations.PayLines1(image, image2, image3, image4, image5)) {
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }

            if (randomChance < 5 && PayLinesCombinations.PayLines2(image6, image7, image8, image9, image10)) {
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 6 && PayLinesCombinations.PayLines3(image11, image12, image13, image14, image15)) {
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 7 && PayLinesCombinations.PayLines4(image, image6, image11)) {
                Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 8 && PayLinesCombinations.PayLines5(image2, image7, image12)) {
                Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 9 && PayLinesCombinations.PayLines6(image3, image8, image13)) {
                Toast.makeText(this, "6", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 10 && PayLinesCombinations.PayLines7(image4, image9, image14)) {
                Toast.makeText(this, "7", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 11 && PayLinesCombinations.PayLines8(image5, image10, image15)) {
                Toast.makeText(this, "8", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 12 && PayLinesCombinations.PayLines9(image, image7, image13, image9, image5)) {
                Toast.makeText(this, "9", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 13 && PayLinesCombinations.PayLines10(image11, image7, image3, image9, image15)) {
                Toast.makeText(this, "10", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 14 && PayLinesCombinations.PayLines11(image6, image12, image8, image14, image10)) {
                Toast.makeText(this, "11", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 15 && PayLinesCombinations.PayLines12(image6, image7, image13, image9, image10)) {
                Toast.makeText(this, "12", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 16 && PayLinesCombinations.PayLines13(image11, image7, image13, image9, image5)) {
                Toast.makeText(this, "13", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 17 && PayLinesCombinations.PayLines14(image11, image7, image3, image9, image5)) {
                Toast.makeText(this, "14", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 18 && PayLinesCombinations.PayLines15(image11, image7, image13, image9, image5)) {
                Toast.makeText(this, "15", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 19 && PayLinesCombinations.PayLines16(image, image7, image13, image9, image15)) {
                Toast.makeText(this, "16", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 20 && PayLinesCombinations.PayLines17(image, image2, image8, image4, image5)) {
                Toast.makeText(this, "17", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 21 && PayLinesCombinations.PayLines18(image6, image2, image8, image4, image10)) {
                Toast.makeText(this, "18", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 22 && PayLinesCombinations.PayLines19(image6, image7, image2, image9, image10)) {
                Toast.makeText(this, "19", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 23 && PayLinesCombinations.PayLines20(image, image2, image4, image5, image13)) {
                Toast.makeText(this, "20", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 24 && PayLinesCombinations.PayLines21(image, image2, image4, image5, image13)) {
                Toast.makeText(this, "21", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 25 && PayLinesCombinations.PayLines22(image, image2, image8, image4, image5)) {
                Toast.makeText(this, "22", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 26 && PayLinesCombinations.PayLines23(image6, image7, image3, image9, image10)) {
                Toast.makeText(this, "23", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 27 && PayLinesCombinations.PayLines24(image11, image12, image8, image14, image15)) {
                Toast.makeText(this, "24", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 28 && PayLinesCombinations.PayLines25(image, image2, image3, image9, image15)) {
                Toast.makeText(this, "25", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 29 && PayLinesCombinations.PayLines26(image6, image7, image8, image14, image15)) {
                Toast.makeText(this, "26", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 30 && PayLinesCombinations.PayLines27(image11, image12, image13, image9, image5)) {
                Toast.makeText(this, "27", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 31 && PayLinesCombinations.PayLines28(image11, image12, image3, image14, image15)) {
                Toast.makeText(this, "28", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (randomChance < 32 && PayLinesCombinations.PayLines29(image11, image7, image8, image9, image5)) {
                Toast.makeText(this, "29", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
            if (!win) {
                Toast.makeText(this, "You lost", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void openActivity1 () {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
