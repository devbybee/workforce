package com.example.demo.payload;

public class MovementData {
    private Object flight_data;
    private Object station_resource;
    private Object pax;
    private String bag_local = "";
    private String bag_total = "";
    private String bag_transit = "";
    private String bag_xfer = "";
    private String bulk_cargo = "";
    private String nbr_container = "";
    private String total_cargo = "";

    public MovementData() {}

    public MovementData(Object flight_data) {
        this.flight_data = flight_data;
    }

    public Object getFlight_data() {
        return flight_data;
    }

    public void setFlight_data(Object flight_data) {
        this.flight_data = flight_data;
    }

    public String getBag_local() {
        return bag_local;
    }

    public String getBag_total() {
        return bag_total;
    }

    public String getBag_transit() {
        return bag_transit;
    }

    public String getBag_xfer() {
        return bag_xfer;
    }

    public String getBulk_cargo() {
        return bulk_cargo;
    }

    public String getNbr_container() {
        return nbr_container;
    }

    public String getTotal_cargo() {
        return total_cargo;
    }

    public Object getStation_resource() {
        return station_resource;
    }

    public void setStation_resource(Object station_resource) {
        this.station_resource = station_resource;
    }

    public Object getPax() {
        return pax;
    }

    public void setPax(Object pax) {
        this.pax = pax;
    }
}
