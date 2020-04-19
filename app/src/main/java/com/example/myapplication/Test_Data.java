package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
        //final TextView text = (TextView) findViewById(R.id.decision_text);
        //view_data_lv = findViewById(R.id.view_data_lv);

        //default values
        int pNNx = 50;
        double LP = 0.2;
        double threshold = 20;
        int window_length = 100;
        int[] pNNx_a= new int[] {30,50};
        double[] LP_a = new double[] {0.2, 0.25, 0.3};
        double [] threshold_a = new double[] {5, 10, 15, 20, 25};
        int[] window_length_a = new int [] {50, 100, 200};


        System.out.println("Hello Testing!");

        Button test1 = findViewById(R.id.test1_btn);
        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream inputStream = getResources().openRawResource(R.raw.slp01a_test_na);
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
                try {
                    RunAlg (list, 1, pNNx, LP, threshold, window_length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                list.clear();
            }
        });
        Button test2 = findViewById(R.id.test2_btn);
        test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream inputStream = getResources().openRawResource(R.raw.slp01a_test_na);
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
                try {
                    for (int a = 0; a < window_length_a.length; a++){
                        for (int e = 0; e < threshold_a.length; e++){
                            for (int i = 0; i < LP_a.length; i++){
                                for (int o = 0; o < pNNx_a.length; o++) {
                                    RunAlg(list, 1, pNNx, LP, threshold, window_length);
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                list.clear();
            }
        });
        Button test3 = findViewById(R.id.test3_btn);
        test3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream inputStream = getResources().openRawResource(R.raw.slp02a_test_na);
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
                try {
                    RunAlg (list, 3, pNNx, LP, threshold, window_length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                list.clear();
            }
        });
        Button overalltest = findViewById(R.id.testall_btn);
        overalltest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputStream inputStream = getResources().openRawResource(R.raw.slp01a_test_na);
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
                try {
                    for (int a = 0; a < window_length_a.length; a++){
                        for (int e = 0; e < threshold_a.length; e++){
                            for (int i = 0; i < LP_a.length; i++){
                                for (int o = 0; o < pNNx_a.length; o++) {
                                    RunAlg(list, 1, pNNx_a[o], LP_a[i], threshold_a[e], window_length_a[a]);
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                list.clear();
                InputStream inputStream2 = getResources().openRawResource(R.raw.slp01b_test_na);
                BufferedReader reader2 = new BufferedReader(new
                        InputStreamReader(inputStream2, Charset.forName("UTF-8")));
                try {
                    while ((line = reader2.readLine()) != null) {
                        int result = Integer.parseInt(line);
                        list.add(result);
                    }
                } catch (IOException e) {
                    Log.wtf("TestData: Error reading datafile on line " + line, e);
                    e.printStackTrace();
                }
                try {
                    for (int a = 0; a < window_length_a.length; a++){
                        for (int e = 0; e < threshold_a.length; e++){
                            for (int i = 0; i < LP_a.length; i++){
                                for (int o = 0; o < pNNx_a.length; o++) {
                                    RunAlg(list, 2, pNNx_a[o], LP_a[i], threshold_a[e], window_length_a[a]);
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                list.clear();
                InputStream inputStream3 = getResources().openRawResource(R.raw.slp02a_test_na);
                BufferedReader reader3 = new BufferedReader(new
                        InputStreamReader(inputStream3, Charset.forName("UTF-8")));
                try {
                    while ((line = reader3.readLine()) != null) {
                        int result = Integer.parseInt(line);
                        list.add(result);
                    }
                } catch (IOException e) {
                    Log.wtf("TestData: Error reading datafile on line " + line, e);
                    e.printStackTrace();
                }
                try {
                    for (int a = 0; a < window_length_a.length; a++){
                        for (int e = 0; e < threshold_a.length; e++){
                            for (int i = 0; i < LP_a.length; i++){
                                for (int o = 0; o < pNNx_a.length; o++) {
                                    RunAlg(list, 3, pNNx_a[o], LP_a[i], threshold_a[e], window_length_a[a]);
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                list.clear();
            }
        });
    }

    private void RunAlg (List<Integer> RRintervals, int Test_Numb, int pNNx, double LP, double threshold, int window_length) throws IOException {
            long startTime = System.nanoTime();

            //int window_length = 100;
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
                dec_array[c-window_length] = alg.algorithmMM(window, pNNx, LP, threshold);
                Log.i("Out of Algorithm " + Test_Numb, "Window #: " + (c-window_length));
            }
            long endTime = System.nanoTime();
            //Log.i("Algorithm Done", "Runtime: " + (endTime-startTime));
            Log.i("Algorithm Done " + Test_Numb, "\nLength of List: " +list.size() +
                    "\nWindow Length: " + window_length + "\nRuntime:" + (endTime - startTime) + "\nArray Length: " + dec_array.length);

            String filename = "Test" + Test_Numb + "pNN" +  pNNx + "_LP" + (int) LP*100 + "window" + window_length + "_threshold" + (int) threshold + ".csv";
            WriteCSV(dec_array, Test_Numb, filename);
            window.clear();
    }

    private void WriteCSV(String[] decisions, int Test_Numb, String name) throws IOException {
        /*String name;
        if (Test_Numb == 1){
            name = "slp01a";
        } else if (Test_Numb == 2){
            name = "slp01b";
        } else {
            name = "slp02a";
        }
        String filename = "Test_" + name + "_Results.csv";
        */
        String filename = name;
        File file = new File(android.os.Environment.getExternalStorageDirectory(), filename);
        try {
            FileOutputStream os = new FileOutputStream(file, true);
            OutputStreamWriter out = new OutputStreamWriter(os);
            for (int i = 0; i < decisions.length; i++) {
                out.write(decisions[i] + "\n");
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("CSVWrite:", "Filepath: " + android.os.Environment.getExternalStorageDirectory() + filename);
    }
}