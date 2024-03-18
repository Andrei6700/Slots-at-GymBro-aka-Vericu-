package com.example.pacanele;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambling);

        btnGoToMainMenu = (Button) findViewById(R.id.btnGoToMainMenu);
        btnGoToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        btn_start = (ImageView) findViewById(R.id.btn_start);

        image = (ImageScrolling) findViewById(R.id.image);
        image2 = (ImageScrolling) findViewById(R.id.image2);
        image3 = (ImageScrolling) findViewById(R.id.image3);
        image4 = (ImageScrolling) findViewById(R.id.image4);
        image5 = (ImageScrolling) findViewById(R.id.image5);
        image6 = (ImageScrolling) findViewById(R.id.image6);
        image7 = (ImageScrolling) findViewById(R.id.image7);
        image8 = (ImageScrolling) findViewById(R.id.image8);
        image9 = (ImageScrolling) findViewById(R.id.image9);
        image10 = (ImageScrolling) findViewById(R.id.image10);
        image11 = (ImageScrolling) findViewById(R.id.image11);
        image12 = (ImageScrolling) findViewById(R.id.image12);
        image13 = (ImageScrolling) findViewById(R.id.image13);
        image14 = (ImageScrolling) findViewById(R.id.image14);
        image15 = (ImageScrolling) findViewById(R.id.image15);

        txt_score = (TextView) findViewById(R.id.txt_score);

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
                    btn_start.setVisibility(View.VISIBLE);

                    int spinCost = betAmount;

                    FoundsStore.SCORE -= spinCost;
                    txt_score.setText(String.valueOf(FoundsStore.SCORE));

                    image.setValueRandom(new Random().nextInt(8),
                            new Random().nextInt((15 - 5) + 1) + 5);
                    image2.setValueRandom(new Random().nextInt(8),
                            new Random().nextInt((15 - 5) + 1) + 5);
                    image3.setValueRandom(new Random().nextInt(8),
                            new Random().nextInt((15 - 5) + 1) + 5);
                    image4.setValueRandom(new Random().nextInt(8),
                            new Random().nextInt((15 - 5) + 1) + 5);
                    image5.setValueRandom(new Random().nextInt(8),
                            new Random().nextInt((15 - 5) + 1) + 5);
                    image6.setValueRandom(new Random().nextInt(8),
                            new Random().nextInt((15 - 5) + 1) + 5);
                    image7.setValueRandom(new Random().nextInt(8),
                            new Random().nextInt((15 - 5) + 1) + 5);
                    image8.setValueRandom(new Random().nextInt(8),
                            new Random().nextInt((15 - 5) + 1) + 5);
                    image9.setValueRandom(new Random().nextInt(8),
                            new Random().nextInt((15 - 5) + 1) + 5);
                    image10.setValueRandom(new Random().nextInt(8),
                            new Random().nextInt((15 - 5) + 1) + 5);
                    image11.setValueRandom(new Random().nextInt(8),
                            new Random().nextInt((15 - 5) + 1) + 5);
                    image12.setValueRandom(new Random().nextInt(8),
                            new Random().nextInt((15 - 5) + 1) + 5);
                    image13.setValueRandom(new Random().nextInt(8),
                            new Random().nextInt((15 - 5) + 1) + 5);
                    image14.setValueRandom(new Random().nextInt(8),
                            new Random().nextInt((15 - 5) + 1) + 5);
                    image15.setValueRandom(new Random().nextInt(8),
                            new Random().nextInt((15 - 5) + 1) + 5);

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
            btn_start.setVisibility(View.VISIBLE);
            count_done = 0;

            // first line
            if (image.getValue() == image2.getValue() && image2.getValue() == image3.getValue() &&
                    image3.getValue() == image4.getValue() && image4.getValue() == image5.getValue()) {
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            // second line
            else if (image6.getValue() == image7.getValue() && image7.getValue() == image8.getValue() &&
                    image8.getValue() == image9.getValue() && image9.getValue() == image10.getValue()) {
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            // third line
            else if (image11.getValue() == image12.getValue() && image12.getValue() == image13.getValue() &&
                    image13.getValue() == image14.getValue() && image14.getValue() == image15.getValue()) {
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //firs column
            else if (image.getValue() == image6.getValue() && image6.getValue() == image11.getValue()) {
                Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //second column
            else if (image2.getValue() == image7.getValue() && image7.getValue() == image12.getValue()) {
                Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            // third column
            else if (image3.getValue() == image8.getValue() && image8.getValue() == image13.getValue()) {
                Toast.makeText(this, "6", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //4 column
            else if (image4.getValue() == image9.getValue() && image9.getValue() == image14.getValue()) {
                Toast.makeText(this, "7", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //5 column
            else if (image5.getValue() == image10.getValue() && image10.getValue() == image15.getValue() ) {
                Toast.makeText(this, "8", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            // V
            else if (image.getValue() == image7.getValue() && image7.getValue() == image13.getValue()
                    && image13.getValue() == image9.getValue() && image9.getValue() == image5.getValue()) {
                Toast.makeText(this, "9", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //^
            else if (image11.getValue() == image7.getValue() && image7.getValue() == image3.getValue()
                    && image3.getValue() == image9.getValue() && image9.getValue() == image15.getValue() ) {
                Toast.makeText(this, "10 ", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else if ((image6.getValue() == image12.getValue() && image12.getValue() == image8.getValue()) && image8.getValue() == image4.getValue()
                    && image4.getValue() == image10.getValue()) {
                Toast.makeText(this, "11", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else if ((image6.getValue() == image12.getValue() && image12.getValue() == image8.getValue()) && image8.getValue() == image14.getValue()
                    && image14.getValue() == image10.getValue()) {
                Toast.makeText(this, "12", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else if ((image.getValue() == image7.getValue() && image7.getValue() == image3.getValue()) && image3.getValue() == image9.getValue()
                    && image9.getValue() == image15.getValue()) {
                Toast.makeText(this, "13", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else if ((image11.getValue() == image7.getValue() && image7.getValue() == image13.getValue()) && image13.getValue() == image9.getValue()
                    && image9.getValue() == image15.getValue()) {
                Toast.makeText(this, "14", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else if ((image11.getValue() == image7.getValue() && image7.getValue() == image3.getValue()) && image3.getValue() == image9.getValue()
                    && image9.getValue() == image5.getValue()) {
                Toast.makeText(this, "15", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else if ((image.getValue() == image7.getValue() && image7.getValue() == image13.getValue()) && image13.getValue() == image9.getValue()
                    && image9.getValue() == image15.getValue()) {
                Toast.makeText(this, "16", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else if ((image.getValue() == image2.getValue() && image2.getValue() == image8.getValue()) && image8.getValue() == image4.getValue()
                    && image4.getValue() == image5.getValue()) {
                Toast.makeText(this, "17", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else if ((image6.getValue() == image2.getValue() && image2.getValue() == image8.getValue()) && image8.getValue() == image4.getValue()
                    && image4.getValue() == image10.getValue()) {
                Toast.makeText(this, "18", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else if ((image6.getValue() == image7.getValue() && image7.getValue() == image13.getValue()) && image13.getValue() == image9.getValue()
                    && image9.getValue() == image10.getValue()) {
                Toast.makeText(this, "19", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else if ((image.getValue() == image7.getValue() && image7.getValue() == image2.getValue()) && image2.getValue() == image9.getValue()
                    && image9.getValue() == image5.getValue()) {
                Toast.makeText(this, "20", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else if ((image.getValue() == image2.getValue() && image2.getValue() == image4.getValue()) && image4.getValue() == image5.getValue()
                    && image5.getValue() == image13.getValue()) {
                Toast.makeText(this, "21", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else if ((image.getValue() == image2.getValue() && image2.getValue() == image8.getValue()) && image8.getValue() == image4.getValue()
                    && image4.getValue() == image5.getValue()) {
                Toast.makeText(this, "22", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else if ((image6.getValue() == image7.getValue() && image7.getValue() == image3.getValue()) && image3.getValue() == image9.getValue()
                    && image9.getValue() == image10.getValue()) {
                Toast.makeText(this, "23", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else if ((image11.getValue() == image12.getValue() && image12.getValue() == image8.getValue()) && image8.getValue() == image14.getValue()
                    && image14.getValue() == image15.getValue()) {
                Toast.makeText(this, "24", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else if ((image.getValue() == image2.getValue() && image2.getValue() == image3.getValue()) && image3.getValue() == image9.getValue()
                    && image9.getValue() == image15.getValue()) {
                Toast.makeText(this, "25", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else if ((image6.getValue() == image7.getValue() && image7.getValue() == image8.getValue()) && image8.getValue() == image14.getValue()
                    && image14.getValue() == image15.getValue()) {
                Toast.makeText(this, "26", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else if ((image11.getValue() == image12.getValue() && image12.getValue() == image13.getValue()) && image13.getValue() == image9.getValue()
                    && image9.getValue() == image5.getValue()) {
                Toast.makeText(this, "27", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else if ((image11.getValue() == image12.getValue() && image12.getValue() == image3.getValue()) && image3.getValue() == image14.getValue()
                    && image14.getValue() == image15.getValue()) {
                Toast.makeText(this, "28", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else if ((image11.getValue() == image7.getValue() && image7.getValue() == image8.getValue()) && image8.getValue() == image9.getValue()
                    && image9.getValue() == image5.getValue()) {
                Toast.makeText(this, "29", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            else if (image.getValue() == image2.getValue()){
                Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 50;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }

            //
            else {
                Toast.makeText(this, "You lose :(", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 0;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            this.eventEnd(result, count);
        }
    }

    public void openActivity1() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
