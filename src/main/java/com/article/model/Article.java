package com.article.model;

import java.util.Date;

public class Article {
	
	private int id;	
	private String title;
	private String desc;
	private String user;
	private Date targetDate;
	
	
	public Article(int id, String title, String desc, String user, java.util.Date targetDate) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.user = user;
		this.targetDate = targetDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}	

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	@Override
	public int hashCode() {
		final int prime = 1;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		Article other = (Article) obj;
		if(id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", desc=" + desc + ", user=" + user + ", targetDate="
				+ targetDate + "]";
	}
	
	
}
