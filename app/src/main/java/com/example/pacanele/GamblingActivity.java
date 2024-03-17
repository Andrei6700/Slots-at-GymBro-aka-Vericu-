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
    ImageScrolling image,image2,image3,image4, image5,image6, image7, image8, image9, image10, image11, image12, image13, image14, image15;
    TextView txt_score;
    int count_done = 0;
    private int betAmount = 50; // default bet

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambling);

        btnGoToMainMenu = (Button) findViewById(R.id.btnGoToMainMenu);
        btnGoToMainMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
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

        bet50.setChecked(true); //default val checked in radiobtn

        bet50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                betAmount = 50;
            }
        });

        bet100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                betAmount = 100;
            }
        });

        betAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                betAmount = FoundsStore.SCORE; // bet all money
            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (FoundsStore.SCORE >= betAmount) {
                    btn_start.setVisibility(View.VISIBLE);

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

            if ((image.getValue() == image2.getValue() && image2.getValue() == image3.getValue() &&
                    image3.getValue() == image4.getValue() && image4.getValue() == image5.getValue())) {
                Toast.makeText(this, "You win big prize", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 0;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            else if ((image6.getValue() == image7.getValue() && image7.getValue() == image8.getValue() &&
                    image8.getValue() == image9.getValue() && image9.getValue() == image10.getValue())) {
                Toast.makeText(this, "You win big prize", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 0;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            else if ((image11.getValue() == image12.getValue() && image12.getValue() == image13.getValue() &&
                    image13.getValue() == image14.getValue() && image14.getValue() == image15.getValue())) {
                Toast.makeText(this, "You win big prize", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 0;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            else if ((image.getValue() == image7.getValue() && image7.getValue() == image13.getValue() &&
                    image13.getValue() == image9.getValue() && image9.getValue() == image5.getValue())) {
                Toast.makeText(this, "You win small prize", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 0;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            else if ((image3.getValue() == image7.getValue() && image7.getValue() == image9.getValue() &&
                    image9.getValue() == image11.getValue() && image11.getValue() == image13.getValue())) {
                Toast.makeText(this, "You win small prize", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 0;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            else if ((image.getValue() == image6.getValue() && image6.getValue() == image11.getValue() &&
                    image11.getValue() == image10.getValue() && image10.getValue() == image15.getValue())) {
                Toast.makeText(this, "You win big prize", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 0;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            else if ((image2.getValue() == image7.getValue() && image7.getValue() == image12.getValue() &&
                    image12.getValue() == image9.getValue() && image9.getValue() == image4.getValue())) {
                Toast.makeText(this, "You win big prize", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 0;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            else if ((image3.getValue() == image8.getValue() && image8.getValue() == image13.getValue() &&
                    image13.getValue() == image10.getValue() && image10.getValue() == image5.getValue())) {
                Toast.makeText(this, "You win big prize", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 0;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            else if ((image.getValue() == image7.getValue() && image7.getValue() == image13.getValue() &&
                    image13.getValue() == image10.getValue() && image10.getValue() == image5.getValue())) {
                Toast.makeText(this, "You win big prize", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 0;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            else if ((image3.getValue() == image7.getValue() && image7.getValue() == image13.getValue() &&
                    image13.getValue() == image10.getValue() && image10.getValue() == image5.getValue())) {
                Toast.makeText(this, "You win big prize", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE += 0;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
            else {
                Toast.makeText(this, "You win nothing", Toast.LENGTH_SHORT).show();
                FoundsStore.SCORE -= betAmount;
                txt_score.setText(String.valueOf(FoundsStore.SCORE));
            }
        }
    }

    public void openActivity1(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
