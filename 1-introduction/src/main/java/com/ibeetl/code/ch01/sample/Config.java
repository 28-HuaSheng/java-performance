package com.ibeetl.code.ch01.sample;

public class Config {
    private int max =100;
    private int sleep = 10;
    private String message = ">";
    //忽略getter和setter

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
