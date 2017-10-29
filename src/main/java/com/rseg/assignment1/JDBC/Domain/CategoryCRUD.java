package com.rseg.assignment1.JDBC.Domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.rseg.assignment1.JDBC.Models.Category;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import com.rseg.assignment1.JDBC.DAO.DAO;

@Configuration
public class CategoryCRUD {
	private DAO dao;

	public void setDao(DAO dao) {
		this.dao = dao;
	}

	public List<Category> GetCategories() {
		List<Category> category = this.dao.getJdbcTemplate().query("select id, name from category",
				new CategoryMapper());
		return category;
	}

	public void Print(List<Category> c, Boolean NewLine) 
	{
		String s = "";
		for(int x = 0 ; x < c.size(); x++)
		{
			s = s + c.get(x).toString();
			if (NewLine)
				s = s + "\n";
		}
		System.out.println(s);
		
	}
	
	private static final class CategoryMapper implements RowMapper<Category> {
		@Override
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category category = new Category();
			category.setId(rs.getLong("id"));
			category.setName(rs.getString("name"));
			return category;
		}
	}
	

}