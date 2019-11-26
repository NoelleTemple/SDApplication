package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ViewInfoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_info_page);
        String name = new ProfileInfo().getName();
        int a = new ProfileInfo().getAge();
        boolean s = new ProfileInfo().getSex();
        String sex = "";
        if (s == true){
            sex = "Female";
        }
        if (s == false){
            sex = "Male";
        }
        String age = String.valueOf(a);

        TextView Name = findViewById(R.id.name);
        Name.setText(name);
        TextView Age = findViewById(R.id.age);
        Age.setText(age);
        TextView Sex = findViewById(R.id.sex);
        Sex.setText(sex);

        ImageButton home_button2 = (ImageButton) findViewById(R.id.home_button2);
        home_button2.setOnClickListener(new View.OnClickListener() {
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
