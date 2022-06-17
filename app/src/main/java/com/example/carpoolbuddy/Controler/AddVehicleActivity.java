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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddVehicleActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;
    private LinearLayout layout;

    private EditText modelField;
    private EditText priceField;
    private EditText ownerField;

    private EditText rangeField;
    private EditText capacityField;
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
        setContentView(R.layout.activity_addvehicle);
        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        layout = findViewById(R.id.LOaddVehicle);
        userRoleSpinner = (Spinner) findViewById(R.id.SPaddVehicle);
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
            capacityField = new EditText(this);
            capacityField.setHint("Copacity");
            layout.addView(rangeField);
            layout.addView(capacityField);
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
        modelField.setHint("model");
        layout.addView(modelField);
        priceField = new EditText(this);
        priceField.setHint("price");
        layout.addView(priceField);
    }


    public void addVehicle(View v) {
        String ownerString = ownerField.getText().toString();
        String modelString = modelField.getText().toString();
        int priceString = Integer.parseInt(priceField.getText().toString());

        DocumentReference newRideRef = firestore.collection(Constants.VEHICLE_CONSTANT).document();
        String vehicleId = newRideRef.getId();

        if(selectedRole.equals("Car")) {
            int range = Integer.parseInt(rangeField.getText().toString());
            int capacity = Integer.parseInt(capacityField.getText().toString());
            Car newCar = new Car(ownerString, modelString, capacity, vehicleId, null, true, "car", priceString, range);
            System.out.println(newCar);
            firestore.collection("Vehicles").document(vehicleId).set(newCar);

        }
        if(selectedRole.equals("Bicycle")){
            String bitype = bicycleTypeField.getText().toString();
            int biweight = Integer.parseInt(weightField.getText().toString());
            int biweightCapacity = Integer.parseInt(weightCapacityField.getText().toString());
            Bicycle newBicycle = new Bicycle(ownerString, modelString, 0, vehicleId, null, true, "Bicycle", priceString, bitype, biweight, biweightCapacity);
            firestore.collection("Vehicles").document(vehicleId).set(newBicycle);

        }
        if(selectedRole.equals("Helicopter")){
            int maxSpeed = Integer.parseInt(maxAirSpeedField.getText().toString());
            int maxAlt = Integer.parseInt(maxAltitudeField.getText().toString());
            HeliCopter newHelicopter = new HeliCopter(ownerString, modelString, 5, vehicleId, null, true, "helicopter", priceString, maxAlt, maxSpeed);
            firestore.collection("Vehicles").document(vehicleId).set(newHelicopter);

        }

        if (selectedRole.equals("Segway")){
            int range = Integer.parseInt(rangeField.getText().toString());
            int segweightCapacity = Integer.parseInt(weightCapacityField.getText().toString());
            Segway newSegway = new Segway(ownerString, modelString, 1, vehicleId, null, true, "segway", priceString, range, segweightCapacity);
            firestore.collection("Vehicles").document(vehicleId).set(newSegway);

        }
    }

    public void goBack(View V) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
    }
}