package com.rseg.assignment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



@SpringBootApplication
public class AssignmentOneApplication {

	public static void main(String[] args) {
		new AssignmentOneApplication();
		return;

		//SpringApplication.run(AssignmentOneApplication.class, args);
	}
	
	public AssignmentOneApplication()
	{		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("Beans.xml");
		ctx.refresh();
		Category b = (Category)ctx.getBean("Fiction");
		Category j = (Category)ctx.getBean("Java");
		Category h = (Category)ctx.getBean("History");
		b.Print();
		j.Print();
		h.Print();
		
		
		System.out.print("We started.");
		
	}
}
