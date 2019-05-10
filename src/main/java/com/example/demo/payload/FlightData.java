package com.example.demo.payload;

import java.sql.Date;

public class FlightData {
    private String flight_date;
    private String airline;
    private String trip;
    private String addition = "";
    private String rou;
    private String aircraft_type = "NNN";
    private String bound = "";
    private Object flight_time;
    private String blockTime;
    private String linkedFlightId = "";
    private String handling_type;
    private String faa = "";
    private String reg;
    private String rotation = "";
    private String leg;
    private String btprev = "";
    private Object delay;
    private String return_counter = "";

    public FlightData() {}

    public String getFlight_date() {
        return flight_date;
    }

    public void setFlight_date(String flight_Date) {
        this.flight_date = flight_Date;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getTrip() {
        return trip;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public String getRou() {
        return rou;
    }

    public void setRou(String rou) {
        this.rou = rou;
    }

    public String getAircraft_type() {
        return aircraft_type;
    }

    public void setAircraft_type(String aircraft_type) {
        this.aircraft_type = aircraft_type;
    }

    public String getBound() {
        return bound;
    }

    public void setBound(String bound) {
        this.bound = bound;
    }

    public Object getFlight_time() {
        return flight_time;
    }

    public void setFlight_time(Object flight_time) {
        this.flight_time = flight_time;
    }

    public String getBlockTime() {
        return blockTime;
    }

    public void setBlockTime(String blockTime) {
        this.blockTime = blockTime;
    }

    public String getLinkedFlightId() {
        return linkedFlightId;
    }

    public void setLinkedFlightId(String linkedFlightId) {
        this.linkedFlightId = linkedFlightId;
    }

    public String getHandling_type() {
        return handling_type;
    }

    public void setHandling_type(String handling_type) {
        this.handling_type = handling_type;
    }

    public String getFaa() {
        return faa;
    }

    public void setFaa(String faa) {
        this.faa = faa;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getRotation() {
        return rotation;
    }

    public void setRotation(String rotation) {
        this.rotation = rotation;
    }

    public String getLeg() {
        return leg;
    }

    public void setLeg(String leg) {
        this.leg = leg;
    }

    public String getBtprev() {
        return btprev;
    }

    public Object getDelay() {
        return delay;
    }

    public void setDelay(Object delay) {
        this.delay = delay;
    }

    public String getReturn_counter() {
        return return_counter;
    }
}
