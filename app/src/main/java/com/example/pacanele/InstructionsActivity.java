package com.example.pacanele;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import java.util.ArrayList;

public class InstructionsActivity extends AppCompatActivity {
    ArrayList<InstructionsHandler> messages = new ArrayList<>();
    Button btnGoToMainMenu;

    int[] instructionsImage = {R.drawable.gamblingadd, R.drawable.stopgambling, R.drawable.dependentajocuridenoroc,
            R.drawable.imaginejoc, R.drawable.payfirst,
            R.drawable.payconfirm}; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        btnGoToMainMenu = (Button) findViewById(R.id.btnGoToMainMenu);
        btnGoToMainMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity1();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.movieRecyclerView);

        setUpMovies();

        Adapter_recyclerView adapter = new Adapter_recyclerView(this, messages);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpMovies() {
        String[] titles = getResources().getStringArray(R.array.title);
        String[] messagesArray = getResources().getStringArray(R.array.message); // get the array from strings.xml

        for (int i = 0; i < titles.length; i++) {
            messages.add(new InstructionsHandler(titles[i], messagesArray[i], instructionsImage[i]));
        }
    }

    public void openActivity1(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}