package com.example.restauant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class commander extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commander);
        Button conformer = findViewById(R.id.button4);
        Button annuler = findViewById(R.id.button2);
        TextView tv = findViewById(R.id.textlist);

        String com=getIntent().getStringExtra("liste");
        tv.setText("votre commande :"+ com);
        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(commander.this,pageMenu.class));
            }
        });
        conformer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(commander.this, "votre commande est confermer , Merci", Toast.LENGTH_SHORT).show();
            }
        });

    }
}