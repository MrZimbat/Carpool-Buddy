package com.example.carpoolbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.carpoolbuddy.Controler.AddVehicleActivity;
import com.example.carpoolbuddy.Controler.SignUpActivity;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goAddVehicle(View v) {
        Intent intent = new Intent(this, AddVehicleActivity.class);
        startActivity(intent);
        }
    }
