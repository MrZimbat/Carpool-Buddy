package com.example.carpoolbuddy.Controler;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.carpoolbuddy.R;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goAddVehicle(View V) {
        Intent intent = new Intent(this, AddVehicleActivity.class);
        startActivity(intent);
        }

        public void goVehicleInfo(View V){
            Intent intent = new Intent(this, com.example.carpoolbuddy.Controler.VehicleInfoActivity.class);
            startActivity(intent);
        }
    }
