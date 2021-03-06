package com.example.myapplication;


import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.abs;

public class Algorithm {
    String decision;
    //window
    public String algorithmMM(List<Integer> RRintervals, int pNNx, double LP, double threshold) {
        List<Integer> filteredRR = new ArrayList<Integer>();
        int NN50 = 0;
        double pNN50;

        for (int i = 0; i < RRintervals.size(); i++) {
            if (RRintervals.get(i) > 0) {
                if (filteredRR.size() > 0) {
                    if ((abs(RRintervals.get(i) - filteredRR.get(filteredRR.size() - 1)) / filteredRR.get(filteredRR.size() - 1)) <= LP) {
                        filteredRR.add(RRintervals.get(i));
                    }
                } else {
                    filteredRR.add(RRintervals.get(i));
                }
            }
        }

        for (int i = 1; i < filteredRR.size(); i++) {
            if (abs(filteredRR.get(i) - filteredRR.get(i - 1)) >= pNNx) {
                NN50++;
            }
        }
        //think this should be divided by size - 1 because you have 49 'differences' from 50 values
        String x;
        if (filteredRR.size() <= 1) {
            x = "ND";
            this.decision = "ND";
        } else {
            pNN50 = (NN50 / (filteredRR.size() - 1)) * 100;
            if (pNN50 > threshold) {
                this.decision = "Asleep";
                x = "Asleep";
            } else {
                x = "Awake";
                this.decision = "Awake";
            }
        }
        filteredRR.clear();
        Log.i("Inside Algorithm: ", "Decision: " + x);
        return x;
    }
}

    /*public boolean algorithmMM(double RRintervals[], double warn_min, double warn_max) {
        if (RRintervals[0] < 1) {
            for(int i=0; i<RRintervals.length; i++) {
                RRintervals[i] = RRintervals[i] * 1000;
            }
        }
        double temp = 0;
        for (int i = 1; i<RRintervals.length; i++ ){
            double diff = RRintervals[i] - RRintervals[i - 1];
            double diff2 = Math.pow(diff, 2);
            temp = temp + diff2;
        }
//    print(temp)
        double average_diff = temp / (RRintervals.length - 1);
        double RMSSD = Math.sqrt(average_diff);

        //natural or base 10?
        double logRMSSD = Math.log(RMSSD);
        double score = (logRMSSD / 6.5) * 100;
        //    print(score, warn_min, warn_max)

        if ((warn_min < score) && (warn_max > score)) {
            //print("Pull over, you are drowsy!");
            decision = true;
        } else {
            //print("Continue driving, you super star~");
            decision = false;
        }
        return decision;*/
