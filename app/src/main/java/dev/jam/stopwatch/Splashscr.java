package dev.jam.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splashscr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscr);

        int splashScreenDuration = 4000;
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(Splashscr.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, splashScreenDuration);
    }
}