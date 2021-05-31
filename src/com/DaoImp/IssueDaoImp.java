package com.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.Dao.IssueDao;
import com.DbManager.DbConnection;
import com.Model.Book;
import com.Model.Issue;
import com.Model.Student;

public class IssueDaoImp implements IssueDao{
	Connection conn= DbConnection.getConnection();
	@Override
	public Integer issueBook(Issue issue) {
		 int row=0;
	     PreparedStatement pst=null;
	try {
			java.sql.Date issueDate = new java.sql.Date(issue.getIssueDate().getTime());
			//java.sql.Date returnDate = new java.sql.Date(issue.getReturnDate().getTime());
	            
	            
		   	pst=(PreparedStatement)conn.prepareStatement("insert into issue(book_id,std_id,issue_date) values(?,?,?) ");
			if(issue.getBook().getBook_id()!=null)
			pst.setInt(1, issue.getBook().getBook_id());
			if(issue.getStudent().getId()!=null)
			pst.setInt(2, issue.getStudent().getId());
			if(issue.getIssueDate()!=null)
			pst.setDate(3, issueDate);
			
			/*if(issue.getIssuedBy()!=null)
			pst.setString(4, issue.getIssuedBy());
			if(issue.getStatus()!=null)
			pst.setInt(5, issue.getStatus());*/
			
			row=pst.executeUpdate();
		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return row;
		
	}

	@Override
	public List<Issue> getAllIssuedBooks() {
		List<Issue> list=new ArrayList<>(); 
		try
        {
            String query="select * from issue"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
               Issue issue=new Issue();
            issue.setId(rs.getInt("id"));
            Book book=new Book();
            book.setBook_id(rs.getInt("book_id"));
            issue.setBook(book);
            Student student=new Student();
            student.setId(rs.getInt("std_id"));
            issue.setStudent(student);
            issue.setIssueDate(rs.getDate("issue_date"));
            issue.setReturnDate(rs.getDate("return_date"));
            issue.setIssuedBy(rs.getString("issued_by"));
            issue.setStatus(rs.getInt("status"));
            list.add(issue);
            
            
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return list;
	}

	@Override
	public Integer deleteIssuedBook(Integer id) {
		Integer row=null;
        try {
            String delete = "delete from issue where id=?";
            PreparedStatement smt = conn.prepareStatement(delete);
            smt.setInt(1, id);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return row;
	}	

	@Override
	public Issue getIssuedBookById(int id) {
		Issue issue=new Issue();
		try
        {
            String query="select * from issue where id=?"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
           ps.setInt(1, id);
          
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            	issue.setId(rs.getInt("id"));
                Book book=new Book();
                book.setBook_id(rs.getInt("book_id"));
                issue.setBook(book);
                Student student=new Student();
                student.setId(rs.getInt("std_id"));
                issue.setStudent(student);
                issue.setIssueDate(rs.getDate("issue_date"));
                issue.setReturnDate(rs.getDate("return_date"));
                issue.setIssuedBy(rs.getString("issued_by"));
                issue.setStatus(rs.getInt("status"));
               
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return issue;
	}

	@Override
	public Integer updateIssuedBook(Issue issue) {
		int status=0;
	/*	try{
				
		 PreparedStatement ps=conn.prepareStatement("update issue set  book_id=?, std_id=?, issue_date=?,return_date=?, issued_by=?,status=? where id=?");
		       ps.setInt(1, issue.getBook().getBook_id());
		       ps.setInt(2, issue.getStudent().getId());
		       ps.setDate(3, issue.getIssueDate());
		       ps.setDate(4, issue.getReturnDate());
		       ps.setString(5, issue.getIssuedBy());
		       ps.setInt(5, issue.getStatus());
		       ps.setInt(7, issue.getId());
			   status=ps.executeUpdate();
			}catch(Exception ex){
				ex.printStackTrace();
				}*/
			
			return status;
	}

}
