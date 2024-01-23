package com.example.eatxpiryinventory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity2 extends AppCompatActivity {

    EditText FoodName,ExpiryDate, Location;
    Button btnAdd, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add2);

            FoodName = (EditText)findViewById(R.id.idTxtFoodName);
            ExpiryDate =(EditText)findViewById(R.id.idTxtExpDate);
            Location = (EditText)findViewById(R.id.idTxtLocation);

            btnAdd = (Button)findViewById(R.id.idBtnAdd);
            btnBack = (Button)findViewById(R.id.idBtnBack);

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                insertData();
                clearAll();
                finish();
                }
            });

            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AddActivity2.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); finish();
                }
            });
    }

    private void insertData()
    {
        Map<String,Object> map = new HashMap<>();
        map.put("FoodName",FoodName.getText().toString());
        map.put("ExpiryDate",ExpiryDate.getText().toString());
        map.put("Location",Location.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Inventory").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddActivity2.this, "Data Insert Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(AddActivity2.this, "Error While Insert", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void clearAll()
    {
        FoodName.setText("");
        ExpiryDate.setText("");
        Location.setText("");
    }
}