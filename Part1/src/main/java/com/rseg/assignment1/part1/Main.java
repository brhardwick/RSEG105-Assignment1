package com.rseg.assignment1.part1;

import org.springframework.context.support.GenericXmlApplicationContext;
import com.rseg.assignment1.Models.Category;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/app-context.xml");
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
