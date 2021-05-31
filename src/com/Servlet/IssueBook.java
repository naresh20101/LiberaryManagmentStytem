package com.Servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.DaoImp.BookDaoImp;
import com.DaoImp.IssueDaoImp;
import com.DaoImp.StudentDaoImp;
import com.DaoImp.UserDaoImp;
import com.Model.Book;
import com.Model.Issue;
import com.Model.Student;
import com.Model.User;

/**
 * Servlet implementation class IssueBook
 */
@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDaoImp studentDaoImp=new StudentDaoImp();
	BookDaoImp bookDaoImp=new BookDaoImp();
	IssueDaoImp issueDaoImp=new IssueDaoImp();
	UserDaoImp userDaoImp=new UserDaoImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date=null;
		response.setContentType("text/html");
		String book=request.getParameter("book");
		String student=request.getParameter("student");
		String parameter=request.getParameter("date");
		User user=new User();
		
		Issue issue=new Issue();
		if(parameter!=null)
		{
		 date=Date.valueOf(parameter);
		 issue.setIssueDate(date);
		 
		}
		System.out.println(book);
		System.out.println(student);
		System.out.println(date);
		Student students=new Student();
		Integer stdId=studentDaoImp.getIdByStudent(student);
		students.setId(stdId);
		Book books=new Book();
		Integer bookId=bookDaoImp.getIdByBook(book);
		books.setBook_id(bookId);
		issue.setBook(books);
		issue.setStudent(students);
		issueDaoImp.issueBook(issue);
		
		
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
