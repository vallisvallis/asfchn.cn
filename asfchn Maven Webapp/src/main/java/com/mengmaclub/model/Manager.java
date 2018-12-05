package com.mengmaclub.model;

public class Manager {
	// 管理者id
	private Integer id;
	// 管理者姓名
	private String managername;
	// 管理者手机号
	private Integer managerphone;
	// 管理者用户名
	private String sn;
	// 密码
	private String password;

	
	@Override
	public String toString() {
		return "Manager [id=" + id + ", managername=" + managername
				+ ", managerphone=" + managerphone + ", sn=" + sn
				+ ", password=" + password + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername == null ? null : managername.trim();
	}

	public Integer getManagerphone() {
		return managerphone;
	}

	public void setManagerphone(Integer managerphone) {
		this.managerphone = managerphone;
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
}