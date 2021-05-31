package com.DaoImp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Dao.*;
import com.DbManager.DbConnection;
import com.Model.Book;
import com.Model.Category;


public class BookDaoImp implements BookDao {
	Connection conn= DbConnection.getConnection();
	 
	@Override
	public Integer addBook(Book book) {
		 int row=0;
			
			PreparedStatement pst=null;
			try {
				
	        pst=(PreparedStatement)conn.prepareStatement("insert into book(title,author,no_of_copies,category) values(?,?,?,?) ");
			if(book.getTitle()!=null)
			pst.setString(1,book.getTitle());
			if(book.getAuthor()!=null)
			pst.setString(2,book.getAuthor());
		    if(book.getNoOfCopies()!=null)
			pst.setInt(3,book.getNoOfCopies());
			if(book.getCategory().getId()!=null)
			pst.setInt(4,book.getCategory().getId());
			
			row=pst.executeUpdate();
		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return row;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> list=new ArrayList<>(); 
		try
        {
            String query="select * from book"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
               Book book=new Book();
               book.setBook_id(rs.getInt("book_id"));
               book.setTitle(rs.getString("title"));
               book.setAuthor(rs.getString("author"));
               book.setNoOfCopies(rs.getInt("no_of_copies"));
               Category category=new Category();
               category.setId(rs.getInt("category"));
               book.setCategory(category);
               list.add(book);
               
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return list;
	}

	@Override
	public Integer deleteBook(Integer id) {
		Integer row=null;
        try {
            String delete = "delete from book where book_id=?";
            PreparedStatement smt = conn.prepareStatement(delete);
            smt.setInt(1, id);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return row;
		
	}

	@Override
	public Integer getIdByBook(String name) {
       Integer book_id=0;
		try
        {
            String query="select book_id from book where title=?"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
           ps.setString(1, name);
          
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
               book_id=  rs.getInt("book_id");
                 
            	
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return book_id;
		
	}

	@Override
	public Book getBookById(int id) {
		Book book=new Book();
		try
        {
            String query="select * from book where book_id=?"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
           ps.setInt(1, id);
          
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            	 book.setBook_id(rs.getInt("book_id"));
                 book.setTitle(rs.getString("title"));
                 book.setAuthor(rs.getString("author"));
                 book.setNoOfCopies(rs.getInt("no_of_copies"));
                 Category category=new Category();
                 category.setId(rs.getInt("category"));
                 book.setCategory(category);
               
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return book;
	}

	@Override
	public Integer updateBook(Book book) {
		int status=0;
		try{
				
		 PreparedStatement ps=conn.prepareStatement("update book set title=?, author=?,no_of_copies=?, category=? where book_id=?");
		        ps.setString(1, book.getTitle());
		        ps.setString(2, book.getAuthor());
		        ps.setInt(3, book.getNoOfCopies());
		        ps.setInt(4, book.getCategory().getId());
		        ps.setInt(5, book.getBook_id());
				status=ps.executeUpdate();
			}catch(Exception ex){
				ex.printStackTrace();
				}
			
			return status;
		
	}

}
