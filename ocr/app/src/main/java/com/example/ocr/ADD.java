package com.example.ocr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ADD extends Activity {

    ImageView backbutton5;
    private EditText name, email;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = findViewById(R.id.name);
        add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = name.getText().toString();

                Intent intent = new Intent(ADD.this,InventoryOption.class);
                intent.putExtra("keyname",username);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Location successfully added!",Toast.LENGTH_SHORT).show();
            }
        });

        backbutton5= findViewById(R.id.backbutton5);

        backbutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ADD.this, InventoryOption.class);
                startActivity(intent);
            }
        });
    }

}
