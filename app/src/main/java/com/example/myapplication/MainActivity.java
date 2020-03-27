package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    ProfileInfo profile;
    public static final String UUID = "f5f36c6e-0963-4e1a-80c7-b15b0f42a9e0";
    Button alarm_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        profile = new ProfileInfo();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarm_btn = findViewById(R.id.alarm_button);

        Button add_user_button = findViewById(R.id.add_user_button);
        add_user_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToProfiles();
            }
        });
        /*Button connect_button = findViewById(R.id.connect_button);
        connect_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToConnect();
            }
        });*/
        final boolean[] i = {false};
        final MediaPlayer alarm_test = MediaPlayer.create(MainActivity.this, R.raw.alarm);
        alarm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i[0] = !i[0];
                if (i[0]) {
                    alarm_test.start();
                    alarm_test.setLooping(true);
                } else {
                    alarm_test.pause();
                    //alarm_test.stop(); //to completely stop
                }
            }
        });

        Button about_button = findViewById(R.id.about_button);
        about_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAbout();
            }
        });
        /*Button start_driving_button = findViewById(R.id.start_driving_button);
        start_driving_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDriving();
            }
        });*/
        Button test_btn = findViewById(R.id.tst_button);
        test_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTesting();
            }
        });
    }
    private void goToProfiles() {
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }
    private void goToConnect() {
        Intent intent = new Intent(this, ConnectToWheel.class);
        startActivity(intent);
    }
    private void goToAbout() {
        Intent intent = new Intent(this, AboutPage.class);
        startActivity(intent);
    }
    /*private void goToDriving() {
        Intent intent = new Intent(this, DrivingPage.class);
        startActivity(intent);
    }*/
    private void goToTesting() {
        Intent intent = new Intent(this, Test_Data.class);
        startActivity(intent);
    }

}
