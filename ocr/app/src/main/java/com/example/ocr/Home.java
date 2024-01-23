package com.example.ocr;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Home extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView= findViewById(R.id.bottomNavigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new Fragment()).commit();

        bottomNavigationView.setSelectedItemId(R.id.menuHome);

       bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               Fragment fragment = null;
               switch (item.getItemId()){
                   case R.id.menuHome:
                       fragment = new Fragment();
                       break;
                   case R.id.menuFAQ:
                       break;

                   case R.id.menuInventory:
                       fragment = new inventory_fragment();
                       break;

                   case R.id.menuScan:
                       break;

                   case R.id.menuProfile:
                       break;
               }
               getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
               return true;
           }
       });
    }
}