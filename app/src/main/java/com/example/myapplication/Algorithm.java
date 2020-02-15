package com.example.myapplication;

public class Algorithm {
    boolean decision;
    public boolean algorithmMM(double RRintervals[], double warn_min, double warn_max) {
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
        return decision;
    }
}
