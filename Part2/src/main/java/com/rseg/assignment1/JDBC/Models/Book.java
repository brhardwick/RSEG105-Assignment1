package com.rseg.assignment1.JDBC.Models;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Book implements Model {
	private Long id;
	private String isbn;
	private String title;
	private float price;

	public Long getId() {
		return this.id;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public String getTitle() {
		return this.title;
	}

	public float getPrice() {
		return this.price;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String toString() {
		return Print();
	}

	private int categoryid;

	public int getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String Print() {
		String s = "";
		s = "(ID: " + this.id + ", ISBN: " + this.isbn + ", Title: '" + this.title + "', Price: " + this.price
				+ ", Category ID: " + this.categoryid + ") ";
		return s;
	}
}