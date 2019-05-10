package com.example.demo.payload.revision;

public class RevisionData {
    private Object taskdata;
    private Object resc_info;
    private Object ref_info;
    private String base_loc;
    private String org = "GMF";

    public Object getTaskdata() {
        return taskdata;
    }

    public void setTaskdata(Object taskdata) {
        this.taskdata = taskdata;
    }

    public Object getResc_info() {
        return resc_info;
    }

    public void setResc_info(Object resc_info) {
        this.resc_info = resc_info;
    }

    public Object getRef_info() {
        return ref_info;
    }

    public void setRef_info(Object ref_info) {
        this.ref_info = ref_info;
    }

    public String getBase_loc() {
        return base_loc;
    }

    public void setBase_loc(String base_loc) {
        this.base_loc = base_loc;
    }

    public String getOrg() {
        return org;
    }
}
