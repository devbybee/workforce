package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SABRE_REVISION")
public class Revision {
    @Id
    @Column(name = "REV_NO")
    private String revisionNumber;

    @Column(name = "AC_REG")
    private  String registration;

    @Column(name = "REV_DESC")
    private  String description;

    @Column(name = "TIMESTAMP_PI")
    private String updatedAt;

    @Column(name = "PLAN_START_DATE")
    private String planDate;

    @Column(name = "PLAN_START_TIME")
    private String planTime;

    @Column(name = "SCHED_SRV_DATE")
    private String schedServiceDate;

    @Column(name = "SCHED_SRV_TIME")
    private String schedSerViceTime;

    @Column(name = "REV_TYP")
    private String revisionType;

    @Column(name = "WRKCTR_CODE")
    private String workCtrCode;

    @Column(name = "ASSGN_AIRPORT_CODE")
    private String assignedAirportCode;

    public Revision() {}

    public String getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(String revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public String getPlanTime() {
        return planTime;
    }

    public void setPlanTime(String planTime) {
        this.planTime = planTime;
    }

    public String getSchedServiceDate() {
        return schedServiceDate;
    }

    public void setSchedServiceDate(String schedServiceDate) {
        this.schedServiceDate = schedServiceDate;
    }

    public String getSchedSerViceTime() {
        return schedSerViceTime;
    }

    public void setSchedSerViceTime(String schedSerViceTime) {
        this.schedSerViceTime = schedSerViceTime;
    }

    public String getRevisionType() {
        return revisionType;
    }

    public void setRevisionType(String revisionType) {
        this.revisionType = revisionType;
    }

    public String getWorkCtrCode() {
        return workCtrCode;
    }

    public void setWorkCtrCode(String workCtrCode) {
        this.workCtrCode = workCtrCode;
    }

    public String getAssignedAirportCode() {
        return assignedAirportCode;
    }

    public void setAssignedAirportCode(String assignedAirportCode) {
        this.assignedAirportCode = assignedAirportCode;
    }
}
