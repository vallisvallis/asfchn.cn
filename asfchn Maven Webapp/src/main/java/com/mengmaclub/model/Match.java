package com.mengmaclub.model;

import java.util.Date;

public class Match {
    private Integer id;

    private String name;

    private Date starttime;

    private Date endtime;

    private Date addtime;

    private Date edittime;

    private Integer referee;

    private Date pushtime;

    private String address;

    private String supportlist;

    private String supportgroup;

    private String supportjob;

    private String introduce;
    

    @Override
	public String toString() {
		return "Match [id=" + id + ", name=" + name + ", starttime="
				+ starttime + ", endtime=" + endtime + ", addtime=" + addtime
				+ ", edittime=" + edittime + ", referee=" + referee
				+ ", pushtime=" + pushtime + ", address=" + address
				+ ", supportlist=" + supportlist + ", supportgroup="
				+ supportgroup + ", supportjob=" + supportjob + ", introduce="
				+ introduce + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getEdittime() {
        return edittime;
    }

    public void setEdittime(Date edittime) {
        this.edittime = edittime;
    }

    public Integer getReferee() {
        return referee;
    }

    public void setReferee(Integer referee) {
        this.referee = referee;
    }

    public Date getPushtime() {
        return pushtime;
    }

    public void setPushtime(Date pushtime) {
        this.pushtime = pushtime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getSupportlist() {
        return supportlist;
    }

    public void setSupportlist(String supportlist) {
        this.supportlist = supportlist == null ? null : supportlist.trim();
    }

    public String getSupportgroup() {
        return supportgroup;
    }

    public void setSupportgroup(String supportgroup) {
        this.supportgroup = supportgroup == null ? null : supportgroup.trim();
    }

    public String getSupportjob() {
        return supportjob;
    }

    public void setSupportjob(String supportjob) {
        this.supportjob = supportjob == null ? null : supportjob.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }
}