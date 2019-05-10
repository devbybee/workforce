package com.example.demo.payload.revision;

public class RefInfo {
    private String ref_num;
    private String ac_reg;
    private String flt_num = "";
    private String flt_date;

    public RefInfo(String ref_num, String ac_reg, String flt_date) {
        this.ref_num = ref_num;
        this.ac_reg = ac_reg;
        this.flt_date =  flt_date;
    }

    public String getRef_num() {
        return ref_num;
    }

    public void setRef_num(String ref_num) {
        this.ref_num = ref_num;
    }

    public String getAc_reg() {
        return ac_reg;
    }

    public void setAc_reg(String ac_reg) {
        this.ac_reg = ac_reg;
    }

    public String getFlt_num() {
        return flt_num;
    }

    public String getFlt_date() {
        return flt_date;
    }

    public void setFlt_date(String flt_date) {
        this.flt_date = flt_date;
    }
}
