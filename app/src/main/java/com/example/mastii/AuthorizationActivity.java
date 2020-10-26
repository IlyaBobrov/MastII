package com.example.mastii;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;

import android.app.FragmentTransaction;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;

import com.example.mastii.Auth.AuthFragment;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;


public class AuthorizationActivity extends AppCompatActivity {

    final String TAG = "lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        /*Fragment frag = new Fragment();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragmentTest, frag);
        ft.commit();*/

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

    public void onClickPause(View view) {
        boolean on = ((ToggleButton) view).isChecked();
        if (on) {
            Snackbar.make(view, "start", Snackbar.LENGTH_LONG).show();
        } else {
            Snackbar.make(view, "stop", Snackbar.LENGTH_LONG).show();
        }
    }
}