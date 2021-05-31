package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DaoImp.BookDaoImp;
import com.DaoImp.CategoryDaoImp;
import com.Model.Book;
import com.Model.Category;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookDaoImp bookDaoImp=new BookDaoImp();

	CategoryDaoImp categoryDaoImp=new CategoryDaoImp();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String noOfCopies=request.getParameter("NoOfCopies");
		 Integer copies=Integer.parseInt(noOfCopies);
		String category=request.getParameter("category");
		Book book=new Book();
		Category c=new Category();
		Integer catgId=categoryDaoImp.getIdByCategory(category);
		c.setId(catgId);
		book.setTitle(title);
        book.setAuthor(author);
        book.setNoOfCopies(copies);		
        book.setCategory(c);
        bookDaoImp.addBook(book);
        response.sendRedirect("ViewAllBooks.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
