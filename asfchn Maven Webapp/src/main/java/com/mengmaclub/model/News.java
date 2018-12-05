package com.mengmaclub.model;

import java.util.Date;

public class News {
	// id
	private Integer id;
	// 管理者
	private String manager;
	// 添加时间
	private Date addtime;
	// 编辑时间
	private Date edittime;
	// 内容
	private String content;
	private int type; 

	private String title;


	@Override
	public String toString() {
		return "News [id=" + id + ", manager=" + manager + ", addtime="
				+ addtime + ", edittime=" + edittime + ", content=" + content
				+ ", type=" + type + ", title=" + title + "]";
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}
}