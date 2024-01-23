package com.example.ocr;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class INVENTORYOPTIONPAGE extends AppCompatActivity {

    ImageView backbutton4, deleteF, deleteJ, deleteB;
    TextView deletetextF, deletetextB, deletetextJ;
    Button addmember;
    View deletelineF, deletelineB, deletelineJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventoryoptionpage);

        backbutton4= findViewById(R.id.backbutton4);

        backbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(INVENTORYOPTIONPAGE.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); finish();
            }
        });

        addmember= findViewById(R.id.addmember);
        deleteF= findViewById(R.id.deleteF);
        deletetextF = findViewById(R.id.item1);
        deleteJ= findViewById(R.id.deleteJ);
        deletetextJ = findViewById(R.id.item2);
        deleteB= findViewById(R.id.deleteB);
        deletetextB = findViewById(R.id.item3);
        deletelineF = findViewById(R.id.deletelineF);
        deletelineJ = findViewById(R.id.deletelineJ);
        deletelineB = findViewById(R.id.deletelineB);

        addmember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(INVENTORYOPTIONPAGE.this, ADD.class);
                startActivity(intent);

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        deleteF.setVisibility(View.VISIBLE);
                        deleteB.setVisibility(View.VISIBLE);
                        deleteJ.setVisibility(View.VISIBLE);

                        deletetextF.setVisibility(View.VISIBLE);
                        deletetextB.setVisibility(View.VISIBLE);
                        deletetextJ.setVisibility(View.VISIBLE);

                        deletelineF.setVisibility(View.VISIBLE);
                        deletelineB.setVisibility(View.VISIBLE);
                        deletelineJ.setVisibility(View.VISIBLE);
                    }
                }, 5000);
            }
        });


        deleteF= findViewById(R.id.deleteF);
        deletetextF = findViewById(R.id.item1);

        deleteF.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                /*Intent intent = new Intent(MEMBERSHARINGPAGE.this, com.example.eatxpiry.DELETEPAGE.class);
                startActivity(intent);*/

                deleteF.setVisibility(View.GONE);
                deletetextF.setVisibility(View.GONE);
                deletelineF.setVisibility(View.GONE);

                Toast.makeText(getApplicationContext(),"Location successfully deleted!",Toast.LENGTH_SHORT).show();
            }
        });

        deleteJ= findViewById(R.id.deleteJ);
        deletetextJ = findViewById(R.id.item2);

        deleteJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Intent intent = new Intent(MEMBERSHARINGPAGE.this, com.example.eatxpiry.DELETEPAGE.class);
                startActivity(intent);*/

                deleteJ.setVisibility(View.GONE);
                deletetextJ.setVisibility(View.GONE);
                deletelineJ.setVisibility(View.GONE);

                Toast.makeText(getApplicationContext(),"Location successfully deleted!",Toast.LENGTH_SHORT).show();
            }
        });

        deleteB= findViewById(R.id.deleteB);
        deletetextB = findViewById(R.id.item3);

        deleteB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Intent intent = new Intent(MEMBERSHARINGPAGE.this, com.example.eatxpiry.DELETEPAGE.class);
                startActivity(intent);*/

                deleteB.setVisibility(View.GONE);
                deletetextB.setVisibility(View.GONE);
                deletelineB.setVisibility(View.GONE);

                Toast.makeText(getApplicationContext(),"Location successfully deleted!",Toast.LENGTH_SHORT).show();
            }
        });

    }
}