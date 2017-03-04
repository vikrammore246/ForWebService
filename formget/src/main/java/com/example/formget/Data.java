package com.example.formget;

/**
 * Created by vikram on 8/2/17.
 */

public class Data {

    private String name;
    private String college;
    private String number;

    public Data(String name, String college, String number) {
        this.name = name;
        this.college = college;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
