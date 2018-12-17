package com.mengmaclub.model;

import java.util.Date;

public class HxTeam {
	@Override
	public String toString() {
		return "HxTeam [id=" + id + ", fullname=" + fullname + ", sn=" + sn
				+ ", password=" + password + ", homepage=" + homepage
				+ ", eligibledat=" + eligibledat + ", address=" + address
				+ ", orgtype=" + orgtype + ", managername=" + managername
				+ ", managermoblie=" + managermoblie + ", city=" + city
				+ ", trainingcenter=" + trainingcenter + ", flyingcamp="
				+ flyingcamp + ", prop1=" + prop1 + ", prop2=" + prop2
				+ ", adduser=" + adduser + ", addtime=" + addtime + ", email="
				+ email + ", phone=" + phone + ", introduce=" + introduce + "]";
	}

	// 会员单位id
	private Integer id;
	// 会员单位全称
	private String fullname;
	// 会员单位号
	private String sn;
	// 密码
	private String password;
	// 主页
	private String homepage;
	// 会费到期时间
	private Date eligibledat;
	// 地址
	private String address;
	// 会员单位类型（Q.X.H）
	private String orgtype;
	// 负责人姓名
	private String managername;
	// 负责人手机号
	private Integer managermoblie;
	// 城市
	private String city;
	// 训练中心
	private String trainingcenter;
	// 飞行营地
	private String flyingcamp;
	// 备注1
	private String prop1;
	// 备注2
	private String prop2;
	// 添加人
	private String adduser;
	// 添加时间
	private Date addtime;
	// 邮箱
	private String email;
	// 手机号
	private String phone;
	// 简介
	private String introduce;
	
	private Integer status;
	
	

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname == null ? null : fullname.trim();
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn == null ? null : sn.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage == null ? null : homepage.trim();
	}

	public Date getEligibledat() {
		return eligibledat;
	}

	public void setEligibledat(Date eligibledat) {
		this.eligibledat = eligibledat;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getOrgtype() {
		return orgtype;
	}

	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype == null ? null : orgtype.trim();
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername == null ? null : managername.trim();
	}

	public Integer getManagermoblie() {
		return managermoblie;
	}

	public void setManagermoblie(Integer managermoblie) {
		this.managermoblie = managermoblie;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	public String getTrainingcenter() {
		return trainingcenter;
	}

	public void setTrainingcenter(String trainingcenter) {
		this.trainingcenter = trainingcenter == null ? null : trainingcenter
				.trim();
	}

	public String getFlyingcamp() {
		return flyingcamp;
	}

	public void setFlyingcamp(String flyingcamp) {
		this.flyingcamp = flyingcamp == null ? null : flyingcamp.trim();
	}

	public String getProp1() {
		return prop1;
	}

	public void setProp1(String prop1) {
		this.prop1 = prop1 == null ? null : prop1.trim();
	}

	public String getProp2() {
		return prop2;
	}

	public void setProp2(String prop2) {
		this.prop2 = prop2 == null ? null : prop2.trim();
	}

	public String getAdduser() {
		return adduser;
	}

	public void setAdduser(String adduser) {
		this.adduser = adduser == null ? null : adduser.trim();
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce == null ? null : introduce.trim();
	}
}