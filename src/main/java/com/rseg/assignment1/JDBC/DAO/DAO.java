package com.rseg.assignment1.JDBC.DAO;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class DAO {

	private DriverManagerDataSource dataSource;
	public NamedParameterJdbcTemplate GetNamedParameterJdbcTemplate()
	{
		return new NamedParameterJdbcTemplate(this.jdbcTemplate);
	}
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate()
	{
		return this.jdbcTemplate;
	}
	public void setDataSource(DriverManagerDataSource dataSource) {
		this.dataSource = dataSource;
		JdbcTemplate j = new JdbcTemplate();
		j.setDataSource(dataSource);
		this.jdbcTemplate = j;
	}

	public String TEST() {
		return jdbcTemplate.queryForObject("select 1+1", String.class);
	}
	 
	public DAO() {
		
	}
}