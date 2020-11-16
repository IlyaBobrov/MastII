package com.example.mastii;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AuthorizationActivity extends AppCompatActivity {

    final String TAG = "lifecycle";
    NavController navController;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    /*public void onClickRePass(View view) {
        navController.navigate(R.id.action_loginFragment_to_repassFragment);
    }

    public void onClickLogUp(View view) {
        navController.navigate(R.id.action_loginFragment_to_logupFragment);
    }

    public void onClickLogIn(View view) {
        navController.navigate(R.id.mainActivity);
    }*/

    @SuppressLint("NonConstantResourceId")
    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.btnRePass:
                navController.navigate(R.id.action_loginFragment_to_repassFragment);
                break;
            case R.id.btnLogIn:
                navController.navigate(R.id.mainActivity);
                break;
            case R.id.btnLogUp:
                navController.navigate(R.id.action_loginFragment_to_logupFragment);
                break;
            default:
                navController.navigate(R.id.loginFragment);
                break;
        }
    }
}