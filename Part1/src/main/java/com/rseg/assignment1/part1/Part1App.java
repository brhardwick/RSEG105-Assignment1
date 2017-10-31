package com.rseg.assignment1.part1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.rseg.assignment1.JDBC.Models.Category;


@SpringBootApplication
public class Part1App {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/Beans.xml");
		ctx.refresh();
		Category j = (Category)ctx.getBean("Java");
		Category b = (Category)ctx.getBean("Fiction");
		Category h = (Category)ctx.getBean("History");
		
		j.Print();
		b.Print();
		h.Print();
		ctx.close();
		return;
	}
	
}
