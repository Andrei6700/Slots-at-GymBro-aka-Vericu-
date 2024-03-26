package com.example.pacanele;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.media.MediaPlayer;

import com.example.pacanele.ImageScrolling.IEventEnd;
import com.example.pacanele.ImageScrolling.ImageScrolling;

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

        mediaPlayer = MediaPlayer.create(this, R.raw.rollsound);

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
                if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                }
                if (betAmount <= FoundsStore.SCORE) {
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
        Log.d("GamblingActivity", "eventEnd called with result: " + result + ", count: " + count);
        if (count_done < 2)
            count_done++;
        else {
            int randomChance = random.nextInt(100);
            btn_start.setVisibility(View.VISIBLE);
            count_done = 0;

            if (randomChance < 5) {
                if (image.getValue() == image2.getValue() && image2.getValue() == image3.getValue() &&
                        image3.getValue() == image4.getValue() && image4.getValue() == image5.getValue()) {
                    Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 25) {
                if (image6.getValue() == image7.getValue() && image7.getValue() == image8.getValue() &&
                        image8.getValue() == image9.getValue() && image9.getValue() == image10.getValue()) {
                    Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 15) {
                if (image11.getValue() == image12.getValue() && image12.getValue() == image13.getValue() &&
                        image13.getValue() == image14.getValue() && image14.getValue() == image15.getValue()) {
                    Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 80) {
                if (image.getValue() == image6.getValue() && image.getValue() == image11.getValue()) {
                    Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 90) {
                if (image2.getValue() == image7.getValue() && image7.getValue() == image12.getValue()) {
                    Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 100) {
                if (image3.getValue() == image8.getValue() && image8.getValue() == image13.getValue()) {
                    Toast.makeText(this, "6", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 10) {
                if (image4.getValue() == image9.getValue() && image9.getValue() == image14.getValue()) {
                    Toast.makeText(this, "7", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 15) {
                if (image5.getValue() == image10.getValue() && image10.getValue() == image15.getValue()) {
                    Toast.makeText(this, "8", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 20) {
                if (image.getValue() == image7.getValue() && image7.getValue() == image13.getValue() &&
                        image13.getValue() == image9.getValue() && image9.getValue() == image5.getValue() &&
                        image.getValue() == image5.getValue()) {
                    Toast.makeText(this, "9", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 25) {
                if (image11.getValue() == image7.getValue() && image7.getValue() == image3.getValue() &&
                        image3.getValue() == image9.getValue() && image9.getValue() == image15.getValue()) {
                    Toast.makeText(this, "10", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 70) {
                if ((image6.getValue() == image12.getValue() && image12.getValue() == image8.getValue()) &&
                        image8.getValue() == image4.getValue() && image4.getValue() == image10.getValue()) {
                    Toast.makeText(this, "11", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 80) {
                if ((image6.getValue() == image12.getValue() && image12.getValue() == image8.getValue()) && image8.getValue() == image14.getValue()
                        && image14.getValue() == image10.getValue()) {
                    Toast.makeText(this, "12", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 90) {
                if ((image.getValue() == image7.getValue() && image7.getValue() == image3.getValue()) && image3.getValue() == image9.getValue()
                        && image9.getValue() == image15.getValue()) {
                    Toast.makeText(this, "13", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 80) {
                if ((image11.getValue() == image7.getValue() && image7.getValue() == image13.getValue()) && image13.getValue() == image9.getValue()
                        && image9.getValue() == image15.getValue()) {
                    Toast.makeText(this, "14", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 90) {
                if ((image11.getValue() == image7.getValue() && image7.getValue() == image3.getValue()) && image3.getValue() == image9.getValue()
                        && image9.getValue() == image5.getValue()) {
                    Toast.makeText(this, "15", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 80) {
                if ((image.getValue() == image7.getValue() && image7.getValue() == image13.getValue()) && image13.getValue() == image9.getValue()
                        && image9.getValue() == image15.getValue()) {
                    Toast.makeText(this, "16", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 90) {
                if ((image.getValue() == image2.getValue() && image2.getValue() == image8.getValue()) && image8.getValue() == image4.getValue()
                        && image4.getValue() == image5.getValue()) {
                    Toast.makeText(this, "17", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 80) {
                if ((image6.getValue() == image2.getValue() && image2.getValue() == image8.getValue()) && image8.getValue() == image4.getValue()
                        && image4.getValue() == image10.getValue()) {
                    Toast.makeText(this, "18", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 80) {
                if ((image6.getValue() == image7.getValue() && image7.getValue() == image13.getValue()) && image13.getValue() == image9.getValue()
                        && image9.getValue() == image10.getValue()) {
                    Toast.makeText(this, "19", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 90) {
                if ((image.getValue() == image7.getValue() && image7.getValue() == image2.getValue()) && image2.getValue() == image9.getValue()
                        && image9.getValue() == image5.getValue()) {
                    Toast.makeText(this, "20", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 80) {
                if ((image.getValue() == image2.getValue() && image2.getValue() == image4.getValue()) && image4.getValue() == image5.getValue()
                        && image5.getValue() == image13.getValue()) {
                    Toast.makeText(this, "21", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 90) {
                if ((image.getValue() == image2.getValue() && image2.getValue() == image8.getValue()) && image8.getValue() == image4.getValue()
                        && image4.getValue() == image5.getValue()) {
                    Toast.makeText(this, "22", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 80) {
                if ((image6.getValue() == image7.getValue() && image7.getValue() == image3.getValue()) && image3.getValue() == image9.getValue()
                        && image9.getValue() == image10.getValue()) {
                    Toast.makeText(this, "23", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 90) {
                if ((image11.getValue() == image12.getValue() && image12.getValue() == image8.getValue()) && image8.getValue() == image14.getValue()
                        && image14.getValue() == image15.getValue()) {
                    Toast.makeText(this, "24", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 80) {
                if ((image.getValue() == image2.getValue() && image2.getValue() == image3.getValue()) && image3.getValue() == image9.getValue()
                        && image9.getValue() == image15.getValue()) {
                    Toast.makeText(this, "25", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 90) {
                if ((image6.getValue() == image7.getValue() && image7.getValue() == image8.getValue()) && image8.getValue() == image14.getValue()
                        && image14.getValue() == image15.getValue()) {
                    Toast.makeText(this, "26", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 80) {
                if ((image11.getValue() == image12.getValue() && image12.getValue() == image13.getValue()) && image13.getValue() == image9.getValue()
                        && image9.getValue() == image5.getValue()) {
                    Toast.makeText(this, "27", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 80) {
                if ((image11.getValue() == image12.getValue() && image12.getValue() == image3.getValue()) && image3.getValue() == image14.getValue()
                        && image14.getValue() == image15.getValue()) {
                    Toast.makeText(this, "28", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
            } else if (randomChance < 99) {
                if ((image11.getValue() == image7.getValue() && image7.getValue() == image8.getValue()) && image8.getValue() == image9.getValue()
                        && image9.getValue() == image5.getValue()) {
                    Toast.makeText(this, "29", Toast.LENGTH_SHORT).show();
                    FoundsStore.SCORE += 50;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));
                    win = true;
                }
        } else if (randomChance < 49) {
            if (image.getValue() == image5.getValue() && image5.getValue() == image12.getValue()) {
                Toast.makeText(this, "You won on the first column!", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
                win = true;
            }
        }
            else {
                Toast.makeText(this, "You lose", Toast.LENGTH_SHORT).show();
            }
        }
    }

        public void openActivity1 () {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
