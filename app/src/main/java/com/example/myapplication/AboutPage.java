package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class AboutPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);
        TextView t = findViewById(R.id.about_paragraph);
        t.setText("Heads Up Driving, or HUD, wants to make the world a safer place!\n\n \t \u2022 " +
                "Sensors in the wheel detect heart rate variability \n \t \u2022 Bluetooth " +
                "Pairing between the wheel and app \n \t \u2022 Calculations in app to detect your alertness \n " +
                "\t \u2022 An alarm to wake you up \n \nThe alarm is your cue to pull over, take a nap, or grab a cup of coffee!");
        ImageButton home_button4 = findViewById(R.id.home_button4);
        home_button4.setOnClickListener(new View.OnClickListener() {
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
