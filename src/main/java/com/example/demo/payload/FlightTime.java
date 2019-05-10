package com.example.demo.payload;

public class FlightTime {
    private String st;
    private String et;
    private String at;

    public FlightTime(String st, String et, String at) {
        this.st = st;
        this.et = et;
        this.at = at;

    }

    public FlightTime() {}

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getEt() {
        return et;
    }

    public void setEt(String et) {
        this.et = et;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }
}
