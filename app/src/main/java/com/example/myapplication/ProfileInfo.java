package com.example.myapplication;

public class ProfileInfo {
    String name;
    boolean sex;
        //false = male, true = female
    int age;

    public void setProfileInfo(String name, boolean sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
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
