package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "TBL_AC_MOVEMENT_PROD1")

public class AircraftMovement {

    @Id
    @Column(name = "COL_IDX")
    private Long idx;


    @Column(name = "COL_CARRIER_CODE")
    @NotNull
    private String carrierCode;

    @Column(name = "COL_FLIGHT_NUMBER")
    private String flightNumber;

    @Column(name = "COL_AIRCRAFT_REGISTRATION")
    private String aircraftRegistration;

    /*@Column(name = "COL_DEPARTURE_NUMBER")
    private String departureNumber;*/

    @Column(name = "COL_DEPARTURE_STATION")
    @NotNull
    private String departureStation;

    @Column(name = "COL_PLAN_DEPARTURE_DATE")
    private Date planDate;

    @Column(name = "COL_CHOX_OFF_DATE")
    private Date choxOff;

    @Column(name = "COL_CHOX_OFF_TIME")
    private Time choxOffTime;

    /*
    @Column(name = "COL_WHEELS_OFF_DATE")
    private Date wheelsOff;

    @Column(name = "COL_WHEELS_OFF_TIME")
    private Time wheelsOffTime;
    */
    @Column(name = "COL_EST_DEP_DATE")
    private Date estChoxOff;

    @Column(name = "COL_EST_DEP_TIME")
    private Time estChoxOffTime;

    /*@Column(name = "COL_EST_WHEELS_OFF_DATE")
    private Date estWheelsOff;

    @Column(name = "COL_EST_WHEELS_OFF_TIME")
    private Time estWheelsOffTime;*/

    @Column(name = "COL_CHOX_ON_DATE")
    private Date choxOn;

    @Column(name = "COL_CHOX_ON_TIME")
    private Time choxOnTime;

    /*@Column(name = "COL_WHEELS_ON_DATE")
    private Date wheelsOn;

    @Column(name = "COL_WHEELS_ON_TIME")
    private Time wheelsOnTime;

    @Column(name = "COL_EST_ARR_DATE")
    private Date estChoxOn;

    @Column(name = "COL_EST_ARR_TIME")
    private Time estChoxOnTime;

    @Column(name = "COL_EST_WHEELS_ON_DATE")
    private Date estWheelsOn;

    @Column(name = "COL_EST_WHEELS_ON_TIME")
    private Time estWheelsOnTime;*/

    @Column(name = "COL_ARR_STATION")
    private String arrivalStation;

    @Column(name = "COL_FLIGHT_TYPE")
    private String flightType;


    public AircraftMovement() {}

    public AircraftMovement(Long idx, @NotNull String carrierCode, String flightNumber, @NotNull String departureStation, Date planDate, Date choxOff, Time choxOffTime, Date estChoxOff, Time estChoxOffTime, Date choxOn, Time choxOnTime, String arrivalStation, String flightType) {
        this.idx = idx;
        this.carrierCode = carrierCode;
        this.flightNumber = flightNumber;
        this.departureStation = departureStation;
        this.planDate = planDate;
        this.choxOff = choxOff;
        this.choxOffTime = choxOffTime;
        this.estChoxOff = estChoxOff;
        this.estChoxOffTime = estChoxOffTime;
        this.choxOn = choxOn;
        this.choxOnTime = choxOnTime;
        this.arrivalStation = arrivalStation;
        this.flightType = flightType;
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Date getEstChoxOff() {
        return estChoxOff;
    }

    public void setEstChoxOff(Date estChoxOff) {
        this.estChoxOff = estChoxOff;
    }

    public Time getEstChoxOffTime() {
        return estChoxOffTime;
    }

    public void setEstChoxOffTime(Time estChoxOffTime) {
        this.estChoxOffTime = estChoxOffTime;
    }

    public Date getChoxOn() {
        return choxOn;
    }

    public void setChoxOn(Date choxOn) {
        this.choxOn = choxOn;
    }

    public Time getChoxOnTime() {
        return choxOnTime;
    }

    public void setChoxOnTime(Time choxOnTime) {
        this.choxOnTime = choxOnTime;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public Date getChoxOff() {
        return choxOff;
    }

    public void setChoxOff(Date choxOff) {
        this.choxOff = choxOff;
    }

    public Time getChoxOffTime() {
        return choxOffTime;
    }

    public void setChoxOffTime(Time choxOffTime) {
        this.choxOffTime = choxOffTime;
    }

    public String getAircraftRegistration() {
        return aircraftRegistration;
    }

    public void setAircraftRegistration(String aircraftRegistration) {
        this.aircraftRegistration = aircraftRegistration;
    }
}
