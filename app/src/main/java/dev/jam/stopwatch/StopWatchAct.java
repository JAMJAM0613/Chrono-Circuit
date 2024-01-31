package dev.jam.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

import java.lang.reflect.Type;

public class StopWatchAct extends AppCompatActivity {

    Button btnstart, btnstop;
    ImageView icanchor, exit;
    Animation roundingalone;
    Chronometer timerHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnstart = findViewById(R.id.btnstart);
        btnstop = findViewById(R.id.btnstop);
        exit = findViewById(R.id.exit);
        icanchor = findViewById(R.id.icanchor);
        timerHere = findViewById(R.id.timerHere);

        btnstop.setAlpha(0);

        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                icanchor.startAnimation(roundingalone);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();

                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.start();
            }
        });

         btnstop.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 icanchor.clearAnimation();
                 btnstop.animate().alpha(0).translationY(-80).setDuration(300).start();
                 btnstart.animate().alpha(1).setDuration(300).start();

                 timerHere.stop();
             }
         });

         exit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 finishAffinity();
             }
         });

    }
}