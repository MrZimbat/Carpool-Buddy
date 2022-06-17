package com.example.carpoolbuddy.Controler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.carpoolbuddy.Controler.Constants;
import com.example.carpoolbuddy.Controler.UserProfileActivity;
import com.example.carpoolbuddy.Model.Vehicle.Vehicle;
//import com.example.carpoolbuddy.Model.Vehicle;
import com.example.carpoolbuddy.R;
//import com.example.carpoolbuddy.Utils.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class VehicleInfoActivity extends AppCompatActivity implements FISbookAdapter.OnNoteListener, AdapterView.OnItemSelectedListener {
    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;

    //added for testing
    private ArrayList<Vehicle> vehiclesList;

    private Spinner spinner;


    RecyclerView recView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_info);
        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        //added for testing
        vehiclesList = new ArrayList<Vehicle>();

        recView = findViewById(R.id.recView);
        //creating the spinner
        spinner = this.findViewById(R.id.spinner);

        ArrayList<String> spinnerOptions = new ArrayList<>();
        spinnerOptions.add("No Filter");
        spinnerOptions.add("Car");
        spinnerOptions.add("Segway");
        spinnerOptions.add("Bicycle");
        spinnerOptions.add("Helicopter");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerOptions);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(this);

    }

    public void testDB(View v) {
        vehiclesList.clear();
        TaskCompletionSource<String> getAllRidesTask = new TaskCompletionSource<>();
        firestore.collection(Constants.VEHICLE_CONSTANT).whereEqualTo("open", true)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful() && task.getResult() != null) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        vehiclesList.add(document.toObject(Vehicle.class));
                    }
                    getAllRidesTask.setResult(null);
                }
                else {
                    Log.d("VehiclesInfoActivity", "Error getting documents from db: ", task.getException());
                }
            }
        });
        // when all rides have been retrieved, update RecyclerView
        getAllRidesTask.getTask().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                recView.setAdapter(new FISbookAdapter(vehiclesList, VehicleInfoActivity.this));
                recView.setLayoutManager(new LinearLayoutManager(VehicleInfoActivity.this));
            }
        });
    }

    public void gotoUserProfile(View v) {
        Intent intent = new Intent(this, UserProfileActivity.class);
        startActivity(intent);
    }
    public void goBack(View V) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onNoteClick(int position) {
        vehiclesList.get(position);

        Intent intent = new Intent(this, VehicleProfileActivity.class);
        intent.putExtra("id", vehiclesList.get(position).getVehicleID());
        startActivity(intent);
    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ArrayList<Vehicle> filtered = new ArrayList<>();

        String selected = spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();
        System.out.println("Spinner selected = " + selected);

        if(selected.equals("No Filter")){
            recView.setAdapter(new FISbookAdapter(filtered, VehicleInfoActivity.this));
            recView.setLayoutManager(new LinearLayoutManager(this));

        }
        else if(selected.equals("Car")){
            for(Vehicle v : vehiclesList){
                if(v.getVehicleType().equals("car")){
                    filtered.add(v);
                }
            }
            recView.setAdapter(new FISbookAdapter(filtered, VehicleInfoActivity.this));
            recView.setLayoutManager(new LinearLayoutManager(this));

        }
        else if(selected.equals("Bicycle")){
            for(Vehicle v : vehiclesList){
                if(v.getVehicleType().equals("Bicycle")){
                    filtered.add(v);
                }
            }
            recView.setAdapter(new FISbookAdapter(filtered, VehicleInfoActivity.this));
            recView.setLayoutManager(new LinearLayoutManager(this));

        }
        else if(selected.equals("Helicopter")){
            for(Vehicle v : vehiclesList){
                if(v.getVehicleType().equals("helicopter")){
                    filtered.add(v);
                }
            }
            recView.setAdapter(new FISbookAdapter(filtered, VehicleInfoActivity.this));
            recView.setLayoutManager(new LinearLayoutManager(this));

        }
        else if(selected.equals("Segway")){
            for(Vehicle v : vehiclesList){
                if(v.getVehicleType().equals("segway")){
                    filtered.add(v);
                }
            }
            recView.setAdapter(new FISbookAdapter(filtered, VehicleInfoActivity.this));
            recView.setLayoutManager(new LinearLayoutManager(this));

        }

    }


    public void onNothingSelected(AdapterView<?> parent) {

    }

}