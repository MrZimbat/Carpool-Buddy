package com.example.carpoolbuddy.Controler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carpoolbuddy.Model.User.Alumni;
import com.example.carpoolbuddy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class AuthActivity extends AppCompatActivity {

    //private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;
    private EditText emailfield;
    private EditText passwordfield;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

       // db = FirebaseFirestore.getInstance();

        mAuth = FirebaseAuth.getInstance();
//        firestore = FirebaseFirestore.getInstance().getInstance();
        emailfield = findViewById(R.id.TBemail);
        passwordfield = findViewById(R.id.TBpassword);


    }

    public void signIn (View v){
        String emailString = emailfield.getText().toString();
        String passwordString = passwordfield.getText().toString();
        mAuth.signInWithEmailAndPassword(emailString, passwordString)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Log.d("LOG IN", "successfully loged in the user");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        }
                        else {
                            Log.d("LOG IN", "Log in:failure", task.getException());
                            Toast.makeText(AuthActivity.this,"Log in failed", Toast.LENGTH_LONG).show();
                            updateUI(null);
                        }
                    }
                });


//        System.out.println("LOG IN");
//
//        String emailString = emailfield.getText().toString();
//        String passwordString = passwordfield.getText().toString();
//
//        System.out.println(String.format("EMAIL AND PASSWORD:", emailString, passwordString));
//
//        FirebaseUser mUser = mAuth.getCurrentUser();


    }

    public void signUp (View v){

            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
    }
//        System.out.println("SIGN UP");
//        String emailString = emailfield.getText().toString();
//        String passwordString = passwordfield.getText().toString();
//
//        mAuth.createUserWithEmailAndPassword(emailString, passwordString).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()){
//                    Log.d("SIGN UP", "Successfully signed up");
//
//                    FirebaseUser user = mAuth.getCurrentUser();
//                    updateUI(user);
//                }
//                else{
//                    Log.w("SIGN UP", "createUserWithEmail:failure", task.getException());
////                    Toast.makeText(this, "Authentication failed.",
////                            Toast.LENGTH_SHORT).show();
//                    updateUI(null);
//                }
//            }
//        });
//    }

    public void updateUI(FirebaseUser currentuUser){
        if (currentuUser != null) {
            Intent intent = new Intent(this, AddVehicleActivity.class);
            startActivity(intent);
        }
    }

}