package com.example.demo.payload.revision;

public class TaskData {
    private String task_desc;
    private String task_setup = "";
    private String task_cleanup = "";
    private String start_date;
    private String start_time;
    private String end_date;
    private String end_time;
    private String location;
    private Object qual_info;

    public String getTask_desc() {
        return task_desc;
    }

    public void setTask_desc(String task_desc) {
        this.task_desc = task_desc;
    }

    public String getTask_setup() {
        return task_setup;
    }

    public void setTask_setup(String task_setup) {
        this.task_setup = task_setup;
    }

    public String getTask_cleanup() {
        return task_cleanup;
    }

    public void setTask_cleanup(String task_cleanup) {
        this.task_cleanup = task_cleanup;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Object getQual_info() {
        return qual_info;
    }

    public void setQual_info(Object qual_info) {
        this.qual_info = qual_info;
    }
}
