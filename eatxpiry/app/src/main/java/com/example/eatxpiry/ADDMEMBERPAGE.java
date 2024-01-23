package com.example.eatxpiry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ADDMEMBERPAGE extends AppCompatActivity {

    ImageView backbutton5;
    private EditText name, email;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmemberpage);

        name = findViewById(R.id.name);
        add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = name.getText().toString();

                Intent intent = new Intent(ADDMEMBERPAGE.this,MEMBERSHARINGPAGE.class);
                intent.putExtra("keyname",username);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Member successfully added!",Toast.LENGTH_SHORT).show();
            }
        });

        backbutton5= findViewById(R.id.backbutton5);

        backbutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ADDMEMBERPAGE.this, MEMBERSHARINGPAGE.class);
                startActivity(intent);
            }
        });
    }
}