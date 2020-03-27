package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Test_Data extends AppCompatActivity {
    ListView view_data_lv;
    List<Integer> list=new ArrayList<Integer>();
    List<Integer> window=new ArrayList<Integer>();
    //List<Integer> list_ints=new ArrayList<Integer>();
    //ArrayAdapter adapter;
    Algorithm alg =  new Algorithm();
    String dec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__data);
        final TextView text = (TextView) findViewById(R.id.decision_text);
        view_data_lv = findViewById(R.id.view_data_lv);

        Button test1 = findViewById(R.id.test1_btn);
        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream inputStream = getResources().openRawResource(R.raw.test1);
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
                RunAlg (list, 1);
                list.clear();
            }
        });
        Button test2 = findViewById(R.id.test2_btn);
        test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream inputStream = getResources().openRawResource(R.raw.test2);
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
                RunAlg (list, 2);
                list.clear();
                /*
                InputStream inputStream = getResources().openRawResource(R.raw.test2);
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
                RunAlg (list);
                list.clear();*/
            }
        });
        Button test3 = findViewById(R.id.test3_btn);
        test3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream inputStream = getResources().openRawResource(R.raw.test3);
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
                RunAlg (list, 3);
                list.clear();
            }
        });
    }

    private void RunAlg (List<Integer> RRintervals, int Test_Numb){
            long startTime = System.nanoTime();

            //*****This stuff changed to send windows over*****//
            int window_length = 100;
            String dec_array[] = new String [list.size()-window_length];
            for (int c = window_length; c < list.size(); c++ ){
                for (int d = 0; d < window_length; d++){
                    if (c == window_length){
                        window.add(list.get(d));
                    }
                    else {
                        window.set(d, list.get(d+(c-window_length)));
                    }
                }
                dec_array[c-window_length] = String.valueOf(alg.algorithmMM(window));
                Log.i("Out of Algorithm " + Test_Numb, "Window #: " + (c-window_length));
            }
            long endTime = System.nanoTime();
            //Log.i("Algorithm Done", "Runtime: " + (endTime-startTime));
            Log.i("Algorithm Done " + Test_Numb, "\nLength of List: " +list.size() +
                    "\nWindow Length: " + window_length + "\nRuntime:" + (endTime - startTime));

            //It won't let me log the full dec_array, probably because it's so large (~1500)



            //no longer sets text on screen because it is a lot of decisions lol, can change if wanted
            //*****New Stuff Ends Here*****//

                /*dec = String.valueOf(alg.algorithmMM(list));
                //////dec = String.valueOf(alg.decision);
                long endTime = System.nanoTime();
                Log.i("Algorithm done:", "Length of List: " + list.size() + "\nDecision: " + dec + "\nTime Elapsed:" + (endTime - startTime));

                if (dec == "true"){
                    text.setText("True");
                }
                else{
                    text.setText("False");
                }*/
            window.clear();
    }
}