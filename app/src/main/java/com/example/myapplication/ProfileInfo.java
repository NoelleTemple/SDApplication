package com.example.myapplication;

import java.io.Serializable;

public class ProfileInfo implements Serializable {
    String name;
    boolean sex;
        //false = male, true = female
    int age;

    public void setProfileInfo(String name, boolean sex, int age){
        this.name = String.valueOf(name);
        this.sex = sex;
        this.age = age;
        float[] ranges = new float[14][2];
        ranges [0][0] =
        ranges [0][1] = 65.5; //75+ 

        if (age > 74){

        } else if (age > 64 ){

            } else if (age > 54){

            } else if (age > 44){

            } else if (age > 34){

            } else if (age >24){

            } else if (age>17){

            } else{

            }

    }

    public String getName()
    {
        return this.name;
    }
    public int getAge()
    {
        return this.age;
    }
    public boolean getSex() {
        return this.sex;
    }
        //false = male, true = female
}
