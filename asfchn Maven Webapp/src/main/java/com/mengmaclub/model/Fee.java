package com.mengmaclub.model;

import java.util.Date;

public class Fee {
	// 费用ID
	private Integer id;
	 private Double price;
	// 会员ID
	private Integer people;
	// 会员单位ID
	private Integer team;
	// 费用类型
	private Integer feetype;
	// 费用缴费截至日期
	private String feedieline;
	// 添加时间
	private Date addtime;
	// 费用状态（1.已申请2.已审核3.已缴费4.未申请）
	private Integer feestatus;
	// 管理者
	private String manager;

	private String peoplename;
	
	private String teamname;
	
	
	
	@Override
	public String toString() {
		return "Fee [id=" + id + ", price=" + price + ", people=" + people
				+ ", team=" + team + ", feetype=" + feetype + ", feedieline="
				+ feedieline + ", addtime=" + addtime + ", feestatus="
				+ feestatus + ", manager=" + manager + ", peoplename="
				+ peoplename + ", teamname=" + teamname + "]";
	}

	public String getPeoplename() {
		return peoplename;
	}

	public void setPeoplename(String peoplename) {
		this.peoplename = peoplename;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPeople() {
		return people;
	}

	public void setPeople(Integer people) {
		this.people = people;
	}

	public Integer getTeam() {
		return team;
	}

	public void setTeam(Integer team) {
		this.team = team;
	}

	public Integer getFeetype() {
		return feetype;
	}

	public void setFeetype(Integer feetype) {
		this.feetype = feetype;
	}

	public String getFeedieline() {
		return feedieline;
	}

	public void setFeedieline(String feedieline) {
		this.feedieline = feedieline;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Integer getFeestatus() {
		return feestatus;
	}

	public void setFeestatus(Integer feestatus) {
		this.feestatus = feestatus;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
}