package com.example.eatxpiry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SETTINGSPAGE extends AppCompatActivity {

    ImageView backbutton2, policybtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingspage);

        backbutton2= findViewById(R.id.backbutton2);
        policybtn = findViewById(R.id.policybtn);

        backbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SETTINGSPAGE.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); finish();
            }
        });

        policybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SETTINGSPAGE.this,POLICYPAGE.class);
                startActivity(intent);
            }
        });
    }
}