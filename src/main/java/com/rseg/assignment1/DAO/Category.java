package com.rseg.assignment1.DAO;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Category {
    private Long id;
    private String name;
    private Set<Book> booksSet;
    private List<Book> booksList; 
    private Map<String, Book> booksMap;

    
    public void setId(Long id)
    {
    	this.id=id;
    }
    
    public void setName(String name)
    {
    	this.name=name;
    }
    
    public void setBooksSet(Set booksSet)
    {
    	this.booksSet=booksSet;
    }
    
    public void setBooksList(List booksList)
    {
    	this.booksList = booksList;
    }
    
    public void setBooksMap(Map booksMap)
    {
    	this.booksMap = booksMap;
    }
    
    private String printMap(Map<String, Book> mp) {
        Iterator it = mp.entrySet().iterator();
        String s = "";
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            String Name = (String) pair.getKey();
            Book CurrentBook = (Book)pair.getValue();
            s =s + CurrentBook.Print();
            
            it.remove(); // avoids a ConcurrentModificationException
        }
        return s;
    }
    

    private String printList(List<Book> lst) {
        
        String s = "";
        for(int x = 0; x < lst.size(); x++)
        {
        	
            s =s + lst.get(x).Print();
        	
        }
        return s;
    }
    
private String printSet(Set<Book> st) {
        
        String s = "";
        Iterator it = st.iterator();
        
        while (it.hasNext()) {
        	Book CurrentBook = (Book)it.next();
            s =s + CurrentBook.Print();
            
            it.remove(); // avoids a ConcurrentModificationException
        }
        
        return s;
    }
    
    
    private void PrintStructure(Map map)
    {
    	System.out.println("-----------------Books Map Output Start------------------------------------");
    	String s = "ID: " + this.id + ", Category: " + this.name + " " + this.printMap(map);
    	System.out.println(s);  	
    	System.out.println("---------------------------------------------------------------------------");
    	
    }
    private void PrintStructure(List list)
    {
    	System.out.println("-----------------Books List Output Start------------------------------------");
    	String s = "ID: " + this.id + ", Category: " + this.name + " " + this.printList(list);
    	System.out.println(s);  	
    	System.out.println("---------------------------------------------------------------------------");
    }
    
    
    private void PrintStructure(Set set)
    {
    	System.out.println("-----------------Books Set Output Start------------------------------------");
    	String s = "ID: " + this.id + ", Category: " + this.name + " " + this.printSet(set);
    	System.out.println(s);  	
    	System.out.println("---------------------------------------------------------------------------");
    }
    
    public  void Print()
    {
    	if(this.booksSet!= null)
    		PrintStructure(this.booksSet);
    	if(this.booksMap!= null)
    		PrintStructure(this.booksMap);
    	if(this.booksList!= null)
    		PrintStructure(this.booksList);
    }
}