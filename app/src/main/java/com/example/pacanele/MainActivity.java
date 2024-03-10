package com.example.pacanele;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

// pagina principala
public class MainActivity extends AppCompatActivity {
    // butonul catre pagina de gambling aka pacanele
    private Button btnGambling;

    // butonul catre pagina de add founds
    private Button btnAddFounds;

    // butonul catre pagina de instructiuni
    private Button btnInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGambling = findViewById(R.id.btnGambling);
        btnGambling.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openStart();
            }
        });

        btnAddFounds = findViewById(R.id.btnAddFounds);
        btnAddFounds.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openAddFounds();
            }
        });

        btnInstructions = findViewById(R.id.btnInstructions);

        btnInstructions.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openInstructions();
            }
        });
    }

    public void openStart(){
        Intent intent = new Intent(this, GamblingActivity.class);
        startActivity(intent);
    }

    public void openAddFounds(){
        Intent intent = new Intent(this, AddFoundsActivity.class);
        startActivity(intent);
    }

    public void openInstructions(){
        Intent intent = new Intent(this, InstructionsActivity.class);
        startActivity(intent);
    }
}
