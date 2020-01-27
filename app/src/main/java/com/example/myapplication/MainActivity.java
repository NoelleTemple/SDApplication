package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    ProfileInfo profile;
    public static final String UUID = "f5f36c6e-0963-4e1a-80c7-b15b0f42a9e0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        profile = new ProfileInfo();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button add_user_button = findViewById(R.id.add_user_button);
        add_user_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToProfiles();
            }
        });
        Button connect_button = findViewById(R.id.connect_button);
        connect_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToConnect();
            }
        });
        Button about_button = findViewById(R.id.about_button);
        about_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAbout();
            }
        });
        Button start_driving_button = findViewById(R.id.start_driving_button);
        start_driving_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDriving();
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
    private void goToDriving() {
        Intent intent = new Intent(this, DrivingPage.class);
        startActivity(intent);
    }
}
