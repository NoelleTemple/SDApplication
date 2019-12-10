package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ConnectToWheel extends AppCompatActivity {
    ProfileInfo profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_to_wheel);
        Intent intent = getIntent();
        profile = (ProfileInfo) intent.getSerializableExtra("profile_info");

        //control switch if bluetooth connection successful
        int i = 1;
        if (i == 1){
            Button drive_button = findViewById(R.id.drive_button );
            drive_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goDriving();
                }
            });
        }

        ImageButton home_button3 = findViewById(R.id.home_button3);
        home_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });
    }
    private void goHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void goDriving() {
        Intent intent = new Intent(this, DrivingPage.class);
        startActivity(intent);
        intent.putExtra("profile_info", profile);
        startActivity(intent);
    }
}
