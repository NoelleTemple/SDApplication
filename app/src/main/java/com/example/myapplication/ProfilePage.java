package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;

public class ProfilePage extends AppCompatActivity {
    String name;
    int age;
    boolean sex;
    ProfileInfo profile = new ProfileInfo();

    EditText User_Name;
    EditText User_Age;
    Switch sex_switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        User_Name = findViewById(R.id.User_Name);
        User_Age = findViewById(R.id.User_Age);
        sex_switch = findViewById(R.id.sex_switch);
        Button save_user_button = findViewById(R.id.save_user_button);
        save_user_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = User_Name.getText().toString();
                age = Integer.valueOf(User_Age.getText().toString());
                sex = sex_switch.isChecked();
                profile.setProfileInfo(name, sex, age);
                goToViewInfo();
            }
        });
        ImageButton home_button = findViewById(R.id.home_button);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });
    }
    private void goToViewInfo() {
        Intent intent = new Intent(this, ViewInfoPage.class);
        intent.putExtra("profile_info", profile);
        startActivity(intent);
    }
    private void goHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}