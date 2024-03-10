package com.example.pacanele;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class GamblingActivity extends AppCompatActivity {

    private Button btnGoToMainMenu;

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
    }
    public void openActivity1(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}