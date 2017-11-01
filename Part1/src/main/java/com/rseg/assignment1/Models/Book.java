package com.rseg.assignment1.Models;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Book {
    protected Long id;
    protected String isbn;
    protected String title;
    protected float price;
    
    public Long getId()
    {
    	return this.id;
    }
    
    public String getIsbn()
    {
    	return this.isbn;
    }
    
    public String getTitle()
    {
    	return this.title;
    }
    
    public float getPrice()
    {
    	return this.price;
    }
    
    public void setId(Long id)
    {
    	this.id=id;
    }
    
    public void setIsbn(String isbn)
    {
    	this.isbn=isbn;
    }
    
    public void setTitle(String title)
    {
    	this.title=title;
    }
    
    public void setPrice(float price)
    {
    	this.price = price;
    }
    public String toString()
    {
    	return Print();
    }
    public String Print()
    {
    	String s = "";
    	s = "(ID: "+this.id + ", ISBN: " + this.isbn + ", Title: '" + this.title + "', Price: "+ this.price + ") ";
    	return s;
    }
}