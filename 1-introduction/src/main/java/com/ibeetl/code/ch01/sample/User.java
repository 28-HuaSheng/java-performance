package com.ibeetl.code.ch01.sample;

public class User {
    private Long  id ;
    private Long departId ;
    private String name;
    //忽略getter和setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepartId() {
        return departId;
    }

    public void setDepartId(Long departId) {
        this.departId = departId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
