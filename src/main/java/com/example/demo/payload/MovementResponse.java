package com.example.demo.payload;

import com.example.demo.model.AircraftMovement;

import java.sql.Date;
import java.util.List;

public class MovementResponse {
    private String service;
    private Object data;

    public MovementResponse() {}

    public MovementResponse(String service, Object data) {
        this.service = service;
        this.data = data;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return service + data;
    }
}
