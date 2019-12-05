package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import java.lang.Math;

public class DrivingPage extends AppCompatActivity {
    ProfileInfo profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving_page);
        Intent intent = getIntent();
        profile = (ProfileInfo) intent.getSerializableExtra("profile_info");

        ImageButton home_button5 = findViewById(R.id.home_button5);
        home_button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });

        final boolean[] i = {false};
        final MediaPlayer alarm = MediaPlayer.create(DrivingPage.this, R.raw.alarm);
        Button alarm_button = findViewById(R.id.alarm_button);
        alarm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i[0] = !i[0];
                if (i[0]) {
                    alarm.start();
                    alarm.setLooping(true);
                } else {
                    alarm.pause();
                    //alarm.stop(); //to completely stop
                }
            }
        });
        double data[]= {985, 875, 655, 792, 823};
        algorithmMM(data, profile.min, profile.max);
    }

    private void goHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
//will data be in ints or doubles?
    //return bool or nothing and just set text/alarm from here?
    private boolean algorithmMM(double RRintervals[], double warn_min, double warn_max) {
        if (RRintervals[0] < 1) {
            for(int i=0; i<RRintervals.length; i++) {
                RRintervals[i] = RRintervals[i] * 1000;
            }
        }
        double temp = 0;
        for (int i = 1; i<RRintervals.length; i++ ){
            double diff = RRintervals[i] - RRintervals[i - 1];
            double diff2 = Math.pow(diff, 2);
            temp = temp + diff2;
        }
//    print(temp)
        double average_diff = temp / (RRintervals.length - 1);
        double RMSSD = Math.sqrt(average_diff);

        //natural or base 10?
        double logRMSSD = Math.log(RMSSD);
        double score = (logRMSSD / 6.5) * 100;
        //    print(score, warn_min, warn_max)
        boolean decision;
        if ((warn_min < score) && (warn_max > score)) {
            //print("Pull over, you are drowsy!");
            decision = true;
        } else {
            //print("Continue driving, you super star~");
            decision = false;
        }
        return decision;
    }
}


