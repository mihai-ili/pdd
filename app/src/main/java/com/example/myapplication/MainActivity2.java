package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private Button but1, but2, but3, but4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        but1 = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);
        but3 = findViewById(R.id.but3);
        but4 = findViewById(R.id.but4);

        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int color = 0;
        Button clickedButton = (Button) v;

        // Reset the previously selected button's color (if any)
        if (lastClickedButton != null) {
            lastClickedButton.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent)); //or your default color
        }

        if (v.getId() == R.id.but1) {
            Toast.makeText(this, "неверно", Toast.LENGTH_SHORT).show();
            color = ContextCompat.getColor(this, R.color.button_false);
        } else if (v.getId() == R.id.but2) {
            Toast.makeText(this, "неверно", Toast.LENGTH_SHORT).show();
            color = ContextCompat.getColor(this, R.color.button_false);
        } else if (v.getId() == R.id.but3) {
            Toast.makeText(this, "верно", Toast.LENGTH_SHORT).show();
            color = ContextCompat.getColor(this, R.color.button_try);
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent);
            finish();
        } else if (v.getId() == R.id.but4) {
            Toast.makeText(this, "неверно", Toast.LENGTH_SHORT).show();
            color = ContextCompat.getColor(this, R.color.button_false);
        }

        clickedButton.setBackgroundColor(color);
        lastClickedButton = clickedButton;
    }

    // Add a member variable to track the last clicked button
    private Button lastClickedButton = null;

}