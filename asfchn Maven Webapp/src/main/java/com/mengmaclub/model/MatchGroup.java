package com.mengmaclub.model;

public class MatchGroup {
    private Integer id;

    private String groupage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupage() {
        return groupage;
    }

    public void setGroupage(String groupage) {
        this.groupage = groupage == null ? null : groupage.trim();
    }
}