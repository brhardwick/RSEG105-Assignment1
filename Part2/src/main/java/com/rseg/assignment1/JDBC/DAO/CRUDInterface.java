package com.rseg.assignment1.JDBC.DAO;

import java.util.List;

public interface CRUDInterface<T> {
	
	public List<T> GetAll();
	public void Insert(T NewItem);
	public void Update(Long ID, T UpdatedInformation);
	public void Delete(Long ID);
	public void Print(List<T> c, Boolean NewLine, String Header);
	
}
