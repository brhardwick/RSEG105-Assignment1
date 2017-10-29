package com.rseg.assignment1.JDBC.Models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Book_Pt2 extends Book{

    private int categoryid;
    
    public int getCategoryid()
    {
    	return this.categoryid;
    }
    public void setCategoryid(int categoryid)
    {
    	this.categoryid=categoryid;
    }
    
    @Override
    public String Print()
    {
    	String s = "";
    	s = "(ID: "+this.id + ", ISBN: " + this.isbn + ", Title: '" + this.title + "', Price: "+ this.price + ", Category ID: " + this.categoryid + ") ";
    	return s;
    }
    
}