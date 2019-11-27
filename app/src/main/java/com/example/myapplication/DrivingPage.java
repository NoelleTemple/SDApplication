package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

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
    }
    private void goHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
