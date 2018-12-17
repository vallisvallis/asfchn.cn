package com.mengmaclub.model;

public class Hx {
	// 管理者
	private Integer manager;
	// 新闻
	private Integer news;
	// 公告（可忽略）
	private Integer report;
	// 赛事
	private Integer match;
	// 驾照考试
	private Integer exam;
	// 费用
	private Integer fee;
	// 用户名
	private String name;
	// 密码
	private String password;

	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

	public Integer getNews() {
		return news;
	}

	public void setNews(Integer news) {
		this.news = news;
	}

	public Integer getReport() {
		return report;
	}

	public void setReport(Integer report) {
		this.report = report;
	}

	public Integer getMatch() {
		return match;
	}

	public void setMatch(Integer match) {
		this.match = match;
	}

	public Integer getExam() {
		return exam;
	}

	public void setExam(Integer exam) {
		this.exam = exam;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}
}