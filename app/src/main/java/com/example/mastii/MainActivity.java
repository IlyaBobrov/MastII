package com.example.mastii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    Button buttonStartStop;
    boolean on;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStartStop = (Button) findViewById(R.id.btnPause);
        buttonStartStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                on = ((ToggleButton) v).isChecked();
                if (on) {
                    Snackbar.make(v, "start", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(v, "stop", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}