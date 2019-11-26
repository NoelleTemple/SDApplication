package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    }
}
