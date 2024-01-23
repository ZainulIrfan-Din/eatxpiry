package com.example.ocr;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

public class InventoryOption extends Activity {

    Button Save_Room, Save_Add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventoryoption);

        Save_Room = findViewById(R.id.Save_Room);
        Save_Add = findViewById(R.id.Save_Add);

        /*Save_Room.setVisibility(View.GONE);*/

        Save_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Intent intent = new Intent(getApplicationContext(), INVENTORYOPTIONPAGE.class);
            startActivity(intent);

            /*Save_Room.setVisibility(View.VISIBLE);*/

            }
        });

    }

        public void Save_Fridge (View view){
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "Item successfully added to Fridge!", Toast.LENGTH_SHORT).show();
                }
            }, 1000);

            Intent intent = new Intent(InventoryOption.this, Home.class);
            startActivity(intent);
        }

        public void Save_Cabinet (View view){
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "Item successfully added to Cabinet!", Toast.LENGTH_SHORT).show();
                }
            }, 1000);

            Intent intent = new Intent(InventoryOption.this, Home.class);
            startActivity(intent);
        }

        public void Save_Room (View view){
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "Item successfully added to Room!", Toast.LENGTH_SHORT).show();
                }
            }, 1000);

            Intent intent = new Intent (InventoryOption.this, Home.class);
            startActivity(intent);
        }
}
