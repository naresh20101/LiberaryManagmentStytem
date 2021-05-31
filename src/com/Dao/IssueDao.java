package com.Dao;

import java.util.List;

import com.Model.*;

public interface IssueDao {
	public Integer issueBook(Issue issue);
	public List<Issue> getAllIssuedBooks();
	public Integer deleteIssuedBook(Integer id);
	
    public Issue getIssuedBookById(int id);
    public Integer updateIssuedBook(Issue issue);

}
