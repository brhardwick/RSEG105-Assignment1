package com.rseg.assignment1.JDBC.Domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rseg.assignment1.JDBC.Models.Book;
import com.rseg.assignment1.JDBC.Models.Book_Pt2;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.rseg.assignment1.JDBC.DAO.DAO;

@Configuration
public class BookCRUD {
	private DAO dao;

	public void setDao(DAO dao) {
		this.dao = dao;
	}

	public List<Book_Pt2> GetBooks() {
		List<Book_Pt2> book = this.dao.getJdbcTemplate().query("select category_id, id, title, isbn,price from book", new BookMapper());
		return book;
	}

	public void UpdateBook(int BookID, Book_Pt2 newBook) {
		NamedParameterJdbcTemplate jdbc = this.dao.GetNamedParameterJdbcTemplate();
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("isbn", (String) newBook.getIsbn());
		namedParameters.put("price", (float) newBook.getPrice());
		namedParameters.put("title", newBook.getTitle());
		namedParameters.put("id", BookID);
		namedParameters.put("category_id", newBook.getCategoryid());

		jdbc.update(
				"update BOOK SET category_id = :category_id, title = :title, price = :price, isbn=:isbn WHERE id = :id",
				namedParameters);
	}
	public void DeleteBook(Long id) {
		NamedParameterJdbcTemplate jdbc = this.dao.GetNamedParameterJdbcTemplate();
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("id", id);


		jdbc.update(
				"DELETE FROM BOOK WHERE ID = :id",namedParameters);
	}
	public void InsertBook(Book_Pt2 newBook) {
		NamedParameterJdbcTemplate jdbc = this.dao.GetNamedParameterJdbcTemplate();
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("isbn", (String) newBook.getIsbn());
		namedParameters.put("price", (float) newBook.getPrice());
		namedParameters.put("title", newBook.getTitle());
		namedParameters.put("id", newBook.getId());
		namedParameters.put("category_id", newBook.getCategoryid());

		jdbc.update(
				"INSERT INTO BOOK (title, price, isbn,id,category_id) values (:title, :price, :isbn,:id,:category_id)",
				namedParameters);
	}

	public List<Book_Pt2> GetBooksByCategory(String name) {
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("name", name);
		NamedParameterJdbcTemplate jdbc = this.dao.GetNamedParameterJdbcTemplate();
		List<Book_Pt2> book = jdbc.query(
				"select * from book WHERE category_id = (SELECT id from category where name =:name)", namedParameters,
				new BookMapper());
		return book;
	}

	public void Print(List<Book_Pt2> c, Boolean NewLine) {
		String s = "";
		for (int x = 0; x < c.size(); x++) {
			s = s + c.get(x).toString();
			if (NewLine)
				s = s + "\n";
		}
		System.out.println(s);

	}

	private static final class BookMapper implements RowMapper<Book_Pt2> {
		@Override
		public Book_Pt2 mapRow(ResultSet rs, int rowNum) throws SQLException {
			Book_Pt2 book = new Book_Pt2();
			book.setId(rs.getLong("id"));
			book.setIsbn(rs.getString("isbn"));
			book.setPrice(rs.getFloat("price"));
			book.setTitle(rs.getString("title"));
			book.setCategoryid(rs.getInt("category_id"));
			return book;
		}
	}
}