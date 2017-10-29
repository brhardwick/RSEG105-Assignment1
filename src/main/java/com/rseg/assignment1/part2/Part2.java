package com.rseg.assignment1.part2;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.rseg.assignment1.JDBC.Domain.BookCRUD;
import com.rseg.assignment1.JDBC.Domain.CategoryCRUD;
import com.rseg.assignment1.JDBC.Models.Book;
import com.rseg.assignment1.JDBC.Models.Book_Pt2;
import com.rseg.assignment1.JDBC.Models.Category;
@SpringBootApplication
public class Part2 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("JDBC.xml");
		ctx.refresh();

		CategoryCRUD CategoryOperations = ctx.getBean("CategoryCRUD", CategoryCRUD.class);
		BookCRUD BookOperations = ctx.getBean("BookCRUD", BookCRUD.class);
		
		System.out.println("Getting all the Books:");
		BookOperations.Print(BookOperations.GetBooks(), true);
		
		System.out.println("Getting all Fiction Books:");
		BookOperations.Print(BookOperations.GetBooksByCategory("Fiction"), true);
		
		System.out.println("Updating catcher in the rye:");
		Book_Pt2 b = new Book_Pt2();
		b.setIsbn("123456789");
		b.setPrice((float)13.32);
		b.setTitle("The Catcher in the Rye2");
		b.setCategoryid(1);
		b.setId((long)901);
		System.out.println(b.Print());
		BookOperations.InsertBook(b );
		BookOperations.Print(BookOperations.GetBooks(), true);
		BookOperations.DeleteBook(b.getId() );
		BookOperations.Print(BookOperations.GetBooks(), true);
		
		
		CategoryOperations.Print(CategoryOperations.GetCategories(),true);
		
		ctx.close();
		return;
	}
	


}
