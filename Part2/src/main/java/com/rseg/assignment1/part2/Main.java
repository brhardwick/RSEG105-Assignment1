package com.rseg.assignment1.part2;


import org.springframework.context.support.GenericXmlApplicationContext;

import com.rseg.assignment1.JDBC.DAO.BookCRUD;
import com.rseg.assignment1.JDBC.DAO.CategoryCRUD;
import com.rseg.assignment1.JDBC.Models.Book;


public class Main {

	private static void TestGetAllBooks()
	{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context.xml");
		ctx.refresh();
		
		BookCRUD BookOperations = ctx.getBean("BookCRUD", BookCRUD.class);
		BookOperations.Print(BookOperations.GetAll(), true, "-------------------------------Getting All Books---------------------");
		ctx.close();
	}
	
	private static void TestGetAllCategories()
	{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context.xml");
		ctx.refresh();

		CategoryCRUD CategoryOperations = ctx.getBean("CategoryCRUD", CategoryCRUD.class);
		
		CategoryOperations.Print(CategoryOperations.GetAll(), true, "-------------------------------Getting All Categories---------------------");
		ctx.close();
	}
	private static void TestDeleteBook()
	{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context.xml");
		ctx.refresh();

		BookCRUD BookOperations = ctx.getBean("BookCRUD", BookCRUD.class);
		
		BookOperations.Print(BookOperations.GetAll(), true, "-------------------------------Getting Books Before Deletion---------------------");
		BookOperations.Delete((long)1);
		BookOperations.Print(BookOperations.GetAll(), true, "-------------------------------Getting Books After Deletion---------------------");
		ctx.close();
	}
	private static void TestUpdateBook()
	{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context.xml");
		ctx.refresh();

		Book b = new Book();
		b.setCategoryid(1);
		b.setId((long)1);
		b.setIsbn("0374715718");
		b.setPrice((float)20.00);
		b.setTitle("The Zoomable Universe: Sequel");
		
		BookCRUD BookOperations = ctx.getBean("BookCRUD", BookCRUD.class);
		
		BookOperations.Print(BookOperations.GetAll(), true, "-------------------------------Getting Books Before Update---------------------");
		BookOperations.Update((long)1, b);
		BookOperations.Print(BookOperations.GetAll(), true, "-------------------------------Getting Books After Update---------------------");
		ctx.close();
	}
	
	private static void TestInsertBook()
	{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context.xml");
		ctx.refresh();

		Book b = new Book();
		b.setCategoryid(1);
		b.setId((long)1);
		b.setIsbn("0374715718");
		b.setPrice((float)18.50);
		b.setTitle("The Zoomable Universe");
		
		BookCRUD BookOperations = ctx.getBean("BookCRUD", BookCRUD.class);
		
		BookOperations.Print(BookOperations.GetAll(), true, "-------------------------------Getting Books Before Insert---------------------");
		BookOperations.Insert(b);
		BookOperations.Print(BookOperations.GetAll(), true, "-------------------------------Getting Books After Insert---------------------");
		ctx.close();
	}
	
	public static void main(String[] args) {
		TestGetAllBooks();
		TestGetAllCategories();
		TestUpdateBook();
		TestDeleteBook();
		TestInsertBook();
		return;
	}
	

	 

}
