package com.mengmaclub.model;

import java.util.Date;

public class Exam {
	// 驾照考试ID
	private Integer id;
	// 驾照考试名字
	private String name;
	// 驾照考试开始时间
	private Date addtime;
	// 驾照考试结束时间
	private Date endtime;
	// 裁判
	private Integer referee;
	// 驾照考试地址
	private String address;
	// 发布时间
	private Date pushtime;
	// 飞行器规格
	private String airport;

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

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Integer getReferee() {
		return referee;
	}

	public void setReferee(Integer referee) {
		this.referee = referee;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public Date getPushtime() {
		return pushtime;
	}

	public void setPushtime(Date pushtime) {
		this.pushtime = pushtime;
	}

	public String getAirport() {
		return airport;
	}

	public void setAirport(String airport) {
		this.airport = airport == null ? null : airport.trim();
	}
}