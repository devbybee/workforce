package com.example.demo.payload;

public class StationResource {
    private String station = "";
    private String term = "";
    private String hostbelt = "";
    private String hostcheck_in = "";
    private String hostgat = "";
    private String hostpos = "N/A";

    public StationResource() {}

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getTerm() {
        return term;
    }

    public String getHostbelt() {
        return hostbelt;
    }

    public String getHostcheck_in() {
        return hostcheck_in;
    }

    public String getHostgat() {
        return hostgat;
    }

    public String getHostpos() {
        return hostpos;
    }
}
