package com.Dao;

import java.util.List;

import com.Model.*;

public interface BookDao {
	public Integer addBook(Book book);
	public List<Book> getAllBooks();
	public Integer deleteBook(Integer id);
	public Integer getIdByBook(String name);
    public Book getBookById(int id);
    public Integer updateBook(Book book);

}
