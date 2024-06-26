package com.example.pacanele;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;
import android.media.MediaPlayer;

public class AddFoundsActivity extends AppCompatActivity {
    private Button btnGoToMainMenu;
    private EditText selectMoney;
    private EditText cardNumberField;
    private EditText cvvField;
    private EditText expiryDateField;
    private MediaPlayer mediaPlayer;
    private MediaPlayer backgroundSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_founds);

        btnGoToMainMenu = findViewById(R.id.btnGoToMainMenu);
        selectMoney = findViewById(R.id.SelectMoney);
        cardNumberField = findViewById(R.id.NumberCardfield);
        expiryDateField = findViewById(R.id.ExpiryCardfield);

        mediaPlayer = MediaPlayer.create(this, R.raw.moneycomplete);
        backgroundSound = MediaPlayer.create(this, R.raw.backgroundaddfounds);
        backgroundSound.setLooping(true); // to play the sound in a loop
        backgroundSound.start();

        backgroundSound.setVolume(0.02f, 0.02f); //set the volume to 50%
        mediaPlayer.setVolume(0.2f, 0.2f); //set the volume to 50%
        btnGoToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });

        Button btnAddFounds = findViewById(R.id.btnAddFounds);
        btnAddFounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFunds();
                mediaPlayer.start();
            }
        });

        InputFilter filter = new InputFilter() {
            final int maxDigits = 4;

            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                for (int i = start; i < end; i++) {
                    if (!Character.isDigit(source.charAt(i)) && source.charAt(i) != ' ') {
                        return "";
                    }
                }
                int len = dest.length();
                if (len > 0) {
                    char lastChar = dest.charAt(len - 1);
                    if (lastChar == ' ' && source.charAt(start) == ' ') {
                        return "";
                    }
                    if (Character.isDigit(lastChar) && (len % 5) == 4 && source.charAt(start) != ' ') {
                        return " " + source;
                    }
                }
                return null;
            }
        };
        cardNumberField.setFilters(new InputFilter[]{filter});

        InputFilter expiryFilter = new InputFilter() {
            final int maxDigits = 2;

            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                for (int i = start; i < end; i++) {
                    if (!Character.isDigit(source.charAt(i)) && source.charAt(i) != '/') {
                        return "";
                    }
                }
                int len = dest.length();
                if (len > 0) {
                    char lastChar = dest.charAt(len - 1);
                    if (lastChar == '/' && source.charAt(start) == '/') {
                        return "";
                    }
                    if (Character.isDigit(lastChar) && (len % 3) == 2 && source.charAt(start) != '/') {
                        return "/" + source;
                    }
                }
                return null;
            }
        };
        expiryDateField.setFilters(new InputFilter[]{expiryFilter});
    }

    private void addFunds() {
        String moneyString = selectMoney.getText().toString();
        if (!moneyString.isEmpty()) {
            int money = Integer.parseInt(moneyString);
            if (money >= 50) {
                FoundsStore.SCORE += money;
                Toast.makeText(this, "Funds added successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Minimum amount to add is 50", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_SHORT).show();
        }
    }

    public void openActivity1(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    protected void onPause() {
        super.onPause();
        if (backgroundSound != null) {
            backgroundSound.pause();
            if (isFinishing()) {
                backgroundSound.stop();
                backgroundSound.release();
            }
        }
        if (backgroundSound != null) {
            backgroundSound.pause();
            if (isFinishing()) {
                backgroundSound.stop();
                backgroundSound.release();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (backgroundSound != null) {
            backgroundSound.release();
            backgroundSound = null;
        }
        if (backgroundSound != null) {
            backgroundSound.release();
            backgroundSound = null;
        }
    }

}