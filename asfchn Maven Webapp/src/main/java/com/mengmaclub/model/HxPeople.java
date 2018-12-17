package com.mengmaclub.model;

import java.util.Date;

public class HxPeople {
	// 会员id
	private Integer id;
	// 会员名称
	private String name;
	// 会员号
	private String sn;
	// 密码（默认123456）
	private String password;
	// 所属会员单位
	private Integer belongteam;
	// 性别
	private String gender;
	// 城市
	private String city;
	// 生日
	private Date birthday;
	// 年龄
	private Integer age;
	// 照片
	private String photo;
	// 身份证号
	private String certnumber;
	// 会费到期时间
	private Date eligibledat;
	// 身份
	private String occupation;
	// 个人简介
	private String personintro;
	// 会费状态
	private Integer yearfeestatus;
	// 赛事报名费状态
	private Integer matchfeestatus;
	// 驾照考务费状态
	private Integer examfeestatus;
	// 添加人
	private String adduser;
	// 添加时间
	private Date addtime;
	// 备注1
	private String prop1;
	// 备注2
	private String prop2;
	// 备注3
	private String prop3;
	// 备注4
	private String prop4;
	// 会费缴纳日期
	private Date yearfeepaydate;
	// 赛事报名费缴纳日期
	private Date matchfeepaydate;
	// 考试报名费缴纳日期
	private Date examfeepaydate;
	private String teamname;
	

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public Date getEligibledat() {
		return eligibledat;
	}

	public void setEligibledat(Date eligibledat) {
		this.eligibledat = eligibledat;
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

	public Integer getBelongteam() {
		return belongteam;
	}

	public void setBelongteam(Integer belongteam) {
		this.belongteam = belongteam;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender == null ? null : gender.trim();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo == null ? null : photo.trim();
	}

	public String getCertnumber() {
		return certnumber;
	}

	public void setCertnumber(String certnumber) {
		this.certnumber = certnumber == null ? null : certnumber.trim();
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation == null ? null : occupation.trim();
	}

	public String getPersonintro() {
		return personintro;
	}

	public void setPersonintro(String personintro) {
		this.personintro = personintro == null ? null : personintro.trim();
	}

	public Integer getYearfeestatus() {
		return yearfeestatus;
	}

	public void setYearfeestatus(Integer yearfeestatus) {
		this.yearfeestatus = yearfeestatus;
	}

	public Integer getMatchfeestatus() {
		return matchfeestatus;
	}

	public void setMatchfeestatus(Integer matchfeestatus) {
		this.matchfeestatus = matchfeestatus;
	}

	public Integer getExamfeestatus() {
		return examfeestatus;
	}

	public void setExamfeestatus(Integer examfeestatus) {
		this.examfeestatus = examfeestatus;
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

	public String getProp3() {
		return prop3;
	}

	public void setProp3(String prop3) {
		this.prop3 = prop3 == null ? null : prop3.trim();
	}

	public String getProp4() {
		return prop4;
	}

	public void setProp4(String prop4) {
		this.prop4 = prop4 == null ? null : prop4.trim();
	}

	public Date getYearfeepaydate() {
		return yearfeepaydate;
	}

	public void setYearfeepaydate(Date yearfeepaydate) {
		this.yearfeepaydate = yearfeepaydate;
	}

	public Date getMatchfeepaydate() {
		return matchfeepaydate;
	}

	public void setMatchfeepaydate(Date matchfeepaydate) {
		this.matchfeepaydate = matchfeepaydate;
	}

	public Date getExamfeepaydate() {
		return examfeepaydate;
	}

	public void setExamfeepaydate(Date examfeepaydate) {
		this.examfeepaydate = examfeepaydate;
	}

	@Override
	public String toString() {
		return "HxPeople [id=" + id + ", name=" + name + ", sn=" + sn
				+ ", password=" + password + ", belongteam=" + belongteam
				+ ", gender=" + gender + ", city=" + city + ", birthday="
				+ birthday + ", age=" + age + ", photo=" + photo
				+ ", certnumber=" + certnumber + ", eligibledat=" + eligibledat
				+ ", occupation=" + occupation + ", personintro=" + personintro
				+ ", yearfeestatus=" + yearfeestatus + ", matchfeestatus="
				+ matchfeestatus + ", examfeestatus=" + examfeestatus
				+ ", adduser=" + adduser + ", addtime=" + addtime + ", prop1="
				+ prop1 + ", prop2=" + prop2 + ", prop3=" + prop3 + ", prop4="
				+ prop4 + ", yearfeepaydate=" + yearfeepaydate
				+ ", matchfeepaydate=" + matchfeepaydate + ", examfeepaydate="
				+ examfeepaydate + ", teamname=" + teamname + "]";
	}

	

}