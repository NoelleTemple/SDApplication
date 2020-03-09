package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Test_Data extends AppCompatActivity {
    ListView view_data_lv;
    List<Integer> list=new ArrayList<Integer>();
    List<Integer> list_ints=new ArrayList<Integer>();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__data);

        view_data_lv = findViewById(R.id.view_data_lv);

        Button test1 = findViewById(R.id.test1_btn);
        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream inputStream = getResources().openRawResource(R.raw.test);
                BufferedReader reader = new BufferedReader(new
                        InputStreamReader(inputStream, Charset.forName("UTF-8")));
                String line = "";
                try {
                    while ((line = reader.readLine()) != null) {
                        int result = Integer.parseInt(line);
                        list.add(result);
                    }
                } catch (IOException e) {
                    Log.wtf("TestData: Error reading datafile on line " + line, e);
                    e.printStackTrace();
                }
                int x = list.get(0)+list.get(1);
                list_ints.add(x);
                list_ints.add(list.get(0));
                list_ints.add(list.get(1));

                adapter = new ArrayAdapter(Test_Data.this, android.R.layout.simple_list_item_1, list_ints);
                view_data_lv.setAdapter(adapter);
            }
        });
    }
}