package com.example.carpoolbuddy.Controler;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.carpoolbuddy.Model.Vehicle.Bicycle;
import com.example.carpoolbuddy.Model.Vehicle.Car;
import com.example.carpoolbuddy.Model.Vehicle.HeliCopter;
import com.example.carpoolbuddy.Model.Vehicle.Segway;
import com.example.carpoolbuddy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddVehicleActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;
    private LinearLayout layout;

    private EditText modelField;
    private EditText priceField;
    private EditText ownerField;

    private EditText rangeField;
    private EditText bicycleTypeField;
    private EditText weightField;
    private EditText weightCapacityField;
    private EditText maxAltitudeField;
    private EditText maxAirSpeedField;


    private Spinner userRoleSpinner;
    private String selectedRole;
    private String uid;
    private static int uidGenerator = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        layout = findViewById(R.id.LOaddVehicle);
        userRoleSpinner = findViewById(R.id.SPaddVehicle);
        setupSpinner();
        uid = "" + uidGenerator;
        uidGenerator++;
    }

    // setup spinner where user selects what user type they want to make an account for
    private void setupSpinner() {
        String[] userTypes = {"Bicycle", "Car", "Helicopter", "Segway"};
        // add user types to spinner
        ArrayAdapter<String> langArrAdapter = new ArrayAdapter<String>(AddVehicleActivity.this,
                android.R.layout.simple_spinner_item, userTypes);
        langArrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userRoleSpinner.setAdapter(langArrAdapter);

        //triggered whenever user selects something different
        userRoleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                selectedRole = parent.getItemAtPosition(position).toString();
                addFields();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void addFields() {
        commonFields();
        if(selectedRole.equals("Car")) {
            rangeField = new EditText(this);
            rangeField.setHint("Range");
            layout.addView(rangeField);
        }

        if(selectedRole.equals("Bicycle")){
            bicycleTypeField = new EditText(this);
            bicycleTypeField.setHint("Type");

            weightField = new EditText(this);
            weightField.setHint("weight");

            weightCapacityField = new EditText(this);
            weightCapacityField.setHint("wieght capacity");

            layout.addView(bicycleTypeField);
            layout.addView(weightField);
            layout.addView(weightCapacityField);
        }

        if (selectedRole.equals("Helicopter")){
            maxAirSpeedField = new EditText(this);
            maxAirSpeedField.setHint("Max Speed");

            maxAltitudeField = new EditText(this);
            maxAltitudeField.setHint("Max Altitude");

            layout.addView(maxAirSpeedField);
            layout.addView(maxAltitudeField);
        }

        if(selectedRole.equals("Segway")){
            rangeField = new EditText(this);
            rangeField.setHint("Range");

            weightCapacityField = new EditText(this);
            weightCapacityField.setHint("wieght capacity");

            layout.addView(rangeField);
            layout.addView(weightCapacityField);
        }
    }

    public void commonFields() {
        layout.removeAllViewsInLayout();
        ownerField = new EditText(this);
        ownerField.setHint("owner");
        layout.addView(ownerField);
        modelField = new EditText(this);
        modelField.setHint("Email");
        layout.addView(modelField);
        priceField = new EditText(this);
        priceField.setHint("Password");
        layout.addView(priceField);
    }


    public void addVehicle(View v) {
        String ownerString = ownerField.getText().toString();
        String modelString = modelField.getText().toString();
        String priceString = priceField.getText().toString();

        if(selectedRole.equals("Car")) {
            int range = Integer.parseInt(rangeField.getText().toString());
            Car newCar = new Car(uid, ownerString, modelString, priceString, range);
            uidGenerator++;
            firestore.collection("Vehicles").document(uid).set(newCar);
        }
        if(selectedRole.equals("Bicycle")){
            String bitype = bicycleTypeField.getText().toString();
            int biweight = Integer.parseInt(rangeField.getText().toString());
            int biweightCapacity = Integer.parseInt(rangeField.getText().toString());
            Bicycle newBicycle = new Bicycle(uid, ownerString, modelString, priceString, bitype, biweight, biweightCapacity);
            uidGenerator++;
            firestore.collection("Vehicles").document(uid).set(newBicycle);
        }
        if(selectedRole.equals("Helicopter")){
            int maxSpeed = Integer.parseInt(rangeField.getText().toString());
            int maxAlt = Integer.parseInt(rangeField.getText().toString());
            HeliCopter newHelicopter = new HeliCopter(uid, ownerString, modelString, priceString, maxAlt, maxSpeed);
            uidGenerator++;
            firestore.collection("Vehicles").document(uid).set(newHelicopter);
        }

        if (selectedRole.equals("Segway")){
            int range = Integer.parseInt(rangeField.getText().toString());
            int segweightCapacity = Integer.parseInt(rangeField.getText().toString());
            Segway newSegway = new Segway(uid, ownerString, modelString, priceString, range, segweightCapacity);
            uidGenerator++;
            firestore.collection("Vehicles").document(uid).set(newSegway);
        }
    }

    public void updateUI(FirebaseUser currentUser) {
        if (currentUser != null) {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        }
    }
}