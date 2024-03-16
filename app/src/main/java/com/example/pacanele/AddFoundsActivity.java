package com.example.pacanele;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class AddFoundsActivity extends AppCompatActivity {
    private Button btnGoToMainMenu;
    private EditText selectMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_founds);

        btnGoToMainMenu = findViewById(R.id.btnGoToMainMenu);
        selectMoney = findViewById(R.id.SelectMoney);

        btnGoToMainMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity1();
            }
        });

        Button btnAddFounds = findViewById(R.id.btnAddFounds);
        btnAddFounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFunds();
            }
        });
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
}
