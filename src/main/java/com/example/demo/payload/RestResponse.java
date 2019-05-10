package com.example.demo.payload;

import java.util.List;

public class RestResponse {
    private int total;
    private List<String> success;
    private List<RestFailed> failed;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<String> getSuccess() {
        return success;
    }

    public void setSuccess(List<String> success) {
        this.success = success;
    }

    public List<RestFailed> getFailed() {
        return failed;
    }

    public void setFailed(List<RestFailed> failed) {
        this.failed = failed;
    }
}
