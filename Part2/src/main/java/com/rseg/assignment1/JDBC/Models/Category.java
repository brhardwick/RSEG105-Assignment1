package com.rseg.assignment1.JDBC.Models;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Category  implements Model{
    private Long id;
    private String name;
   
    public String toString()
    {
    	return Print();
    }
    public String Print()
    {
    	String s = "";
    	s = "(ID: "+this.id + ", Name: " + this.name + ") ";
    	return s;
    }
    public void setId(Long id)
    {
    	this.id=id;
    }
    
    public void setName(String name)
    {
    	this.name=name;
    }   
    
}