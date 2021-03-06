package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ViewInfoPage extends AppCompatActivity {
    ProfileInfo profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        profile = (ProfileInfo) intent.getSerializableExtra("profile_info");

        setContentView(R.layout.activity_view_info_page);
        String name = profile.name;
        int a = profile.age;
        boolean s = profile.sex;
        String sex = "";
        if (s == true){
            sex = "Female";
        }
        if (s == false){
            sex = "Male";
        }
        double mn = profile.min;
        double mx = profile.max;
        String age = String.valueOf(a);
        String mini = String.valueOf(mn);
        String maxi = String.valueOf(mx);

        TextView Name = findViewById(R.id.name);
        Name.setText(name);
        TextView Age = findViewById(R.id.age);
        Age.setText(age);
        TextView Sex = findViewById(R.id.sex);
        Sex.setText(sex);
        TextView min = findViewById(R.id.min);
        min.setText(mini);
        TextView max = findViewById(R.id.max);
        max.setText(maxi);

        ImageButton home_button2 = findViewById(R.id.home_button2);
        home_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });
        Button confirm_button = findViewById(R.id.confirm_button);
        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goConnect();
            }
        });
    }
    private void goHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void goConnect() {
        Intent intent = new Intent(this, ConnectToWheel.class);
        startActivity(intent);
        intent.putExtra("profile_info", profile);
        startActivity(intent);
    }
}
