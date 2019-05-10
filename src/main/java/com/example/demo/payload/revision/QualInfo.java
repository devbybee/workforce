package com.example.demo.payload.revision;

public class QualInfo {
    private String task_qual1;
    private String task_qual2 = "";
    private String task_qual3 = "";

    public QualInfo() {}

    public QualInfo(String task_qual1) {
        this.task_qual1 = task_qual1;
    }

    public String getTask_qual1() {
        return task_qual1;
    }

    public void setTask_qual1(String task_qual1) {
        this.task_qual1 = task_qual1;
    }

    public String getTask_qual2() {
        return task_qual2;
    }

    public String getTask_qual3() {
        return task_qual3;
    }

}
