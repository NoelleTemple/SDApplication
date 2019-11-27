package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.IOException;

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

    }

    private void goHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
