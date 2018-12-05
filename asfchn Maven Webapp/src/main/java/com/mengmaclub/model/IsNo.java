package com.mengmaclub.model;

public class IsNo {
    private Integer id;

    private String isno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsno() {
        return isno;
    }

    public void setIsno(String isno) {
        this.isno = isno == null ? null : isno.trim();
    }
}