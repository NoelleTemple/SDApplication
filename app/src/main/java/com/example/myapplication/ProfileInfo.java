package com.example.myapplication;

import java.io.Serializable;

public class ProfileInfo implements Serializable {
    String name;
    boolean sex;
        //false = male, true = female
    int age;
    double min;
    double max;

    public void setProfileInfo(String name, boolean sex, int age){
        this.name = String.valueOf(name);
        this.sex = sex; //false == male, true == female
        this.age = age;
        double[][] ranges = {{78,75}, {58,55}, {75,72},
                {55,50}, {70,69}, {50,48}, {66.5,68},{46.5,47},
                {64,64}, {42,43}, {65,60.5},{40,39},{69,65.5},{38.5,33}};

        if (age > 74){
            this.min = ranges[13][sex ? 1 : 0];
            this.max = ranges[12][sex ? 1 : 0];
        } else if (age > 64 ){
            this.min = ranges[11][sex ? 1 : 0];
            this.max = ranges[10][sex ? 1 : 0];
            } else if (age > 54){
            this.min = ranges[9][sex ? 1 : 0];
            this.max = ranges[8][sex ? 1 : 0];
            } else if (age > 44){
            this.min = ranges[7][sex ? 1 : 0];
            this.max = ranges[6][sex ? 1 : 0];
            } else if (age > 34){
            this.min = ranges[5][sex ? 1 : 0];
            this.max = ranges[4][sex ? 1 : 0];
            } else if (age >24){
            this.min = ranges[3][sex ? 1 : 0];
            this.max = ranges[2][sex ? 1 : 0];
            } else if (age>17){
            this.min = ranges[1][sex ? 1 : 0];
            this.max = ranges[0][sex ? 1 : 0];
            } else{
            this.min = 0;
            this.max = 0;
            }
    }
}
