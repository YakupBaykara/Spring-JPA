package com.proje.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "book")
public class Book {

	@Id
	private int id;
	
	private String name;
	
	private int pageCount;
	
	private String topic;
	
	private String authorName;
	
	@Temporal(TemporalType.DATE)
	private Date publishDate;

	public Book() {}

	public Book(int id, String name, int pageCount, String topic, String authorName, Date publishDate) {
		this.id = id;
		this.name = name;
		this.pageCount = pageCount;
		this.topic = topic;
		this.authorName = authorName;
		this.publishDate = publishDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", pageCount=" + pageCount + ", topic=" + topic + ", authorName="
				+ authorName + ", publishDate=" + publishDate + "]";
	}			
	
}
