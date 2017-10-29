package com.rseg.assignment1.part1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import com.rseg.assignment1.DAO.Category;


@SpringBootApplication
public class Part1App {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("Beans.xml");
		ctx.refresh();
		Category j = (Category)ctx.getBean("Java");
		Category b = (Category)ctx.getBean("Fiction");
		Category h = (Category)ctx.getBean("History");
		
		j.Print();
		b.Print();
		h.Print();
		
		return;
	}
	
}
