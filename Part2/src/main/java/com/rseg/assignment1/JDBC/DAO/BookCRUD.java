package com.rseg.assignment1.JDBC.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.rseg.assignment1.JDBC.Models.Book;

@Configuration
public class BookCRUD implements CRUDInterface<Book>{
	private Context dao;

	public void setDao(Context dao) {
		this.dao = dao;
	}

	@Override
	public List<Book> GetAll() {
		List<Book> book = this.dao.getJdbcTemplate().query("select category_id, id, title, isbn,price from book", new BookMapper());
		return book;
	}

	@Override
	public void Update(Long ID,  Book newBook) {
		
		NamedParameterJdbcTemplate jdbc = this.dao.GetNamedParameterJdbcTemplate();
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("isbn", (String) newBook.getIsbn());
		namedParameters.put("price", (float) newBook.getPrice());
		namedParameters.put("title", newBook.getTitle());
		namedParameters.put("id", ID);
		namedParameters.put("category_id", newBook.getCategoryid());

		jdbc.update(
				"update BOOK SET category_id = :category_id, title = :title, price = :price, isbn=:isbn WHERE id = :id",
				namedParameters);
	}
	@Override
	public void Delete(Long ID) {
		NamedParameterJdbcTemplate jdbc = this.dao.GetNamedParameterJdbcTemplate();
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("id", ID);


		jdbc.update(
				"DELETE FROM BOOK WHERE ID = :id",namedParameters);
	}
	public void Insert(Book newBook) {
		
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

	public List<Book> GetAllByCategory(String name) {
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("name", name);
		NamedParameterJdbcTemplate jdbc = this.dao.GetNamedParameterJdbcTemplate();
		List<Book> book = jdbc.query(
				"select * from book WHERE category_id = (SELECT id from category where name =:name)", namedParameters,
				new BookMapper());
		return book;
	}

	public void Print(List<Book> c, Boolean NewLine, String Header) {
		String s = Header + "\n";
		for (int x = 0; x < c.size(); x++) {
			s = s + c.get(x).toString();
			if (NewLine)
				s = s + "\n";
		}
		System.out.println(s);

	}

	private static final class BookMapper implements RowMapper<Book> {
		@Override
		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			Book book = new Book();
			book.setId(rs.getLong("id"));
			book.setIsbn(rs.getString("isbn"));
			book.setPrice(rs.getFloat("price"));
			book.setTitle(rs.getString("title"));
			book.setCategoryid(rs.getInt("category_id"));
			return book;
		}
	}

	
}