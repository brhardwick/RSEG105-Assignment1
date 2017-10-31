package com.rseg.assignment1.JDBC.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import com.rseg.assignment1.JDBC.Models.Category;

@Configuration
public class CategoryCRUD implements CRUDInterface<Category>{
	private Context dao;

	public void setDao(Context dao) {
		this.dao = dao;
	}

	@Override
	public List<Category> GetAll() {
		List<Category> category = this.dao.getJdbcTemplate().query("select id, name from category",
				new CategoryMapper());
		return category;
	}
	
	@Override
	public void Print(List<Category> c, Boolean NewLine, String Header) {
		String s = Header + "\n";
		for (int x = 0; x < c.size(); x++) {
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

	

	@Override
	public void Insert(Category NewItem) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void Update(Long ID, Category UpdatedInformation) {
		throw new UnsupportedOperationException();		
	}

	@Override
	public void Delete(Long ID) {
		throw new UnsupportedOperationException();		
	}

	
	

}