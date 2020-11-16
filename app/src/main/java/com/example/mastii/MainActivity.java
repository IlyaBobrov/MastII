package com.example.mastii;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button buttonStartStop;
    Button btnGoToForum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStartStop = findViewById(R.id.btnPause);
        btnGoToForum = findViewById(R.id.btnForum);

        buttonStartStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((ToggleButton) v).isChecked()) {
                    /*Intent intent = new Intent(this, ForumActivity.class);
                    startActivity(intent);*/
                } else {
                    Snackbar.make(v, "stop", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        btnGoToForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ForumActivity.class));
            }
        });
    }
}