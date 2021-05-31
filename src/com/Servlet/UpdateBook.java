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
 * Servlet implementation class UpdateBook
 */
@WebServlet("/UpdateBook")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Integer id=Integer.parseInt(request.getParameter("id"));
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String noOfCopies=request.getParameter("NoOfCopies");
		String category=request.getParameter("category");
	 Integer copies=Integer.parseInt(noOfCopies);
		BookDaoImp bookDaoImp=new BookDaoImp();
		CategoryDaoImp categoryDaoImp=new CategoryDaoImp();
		Category c=new Category();
		Book book =new Book();
		 Integer categId=categoryDaoImp.getIdByCategory(category);
		 c.setId(categId);
		 book.setBook_id(id);
		 book.setTitle(title);
		 book.setAuthor(author);
		 book.setNoOfCopies(copies);
		 book.setCategory(c);
		 
		 int result=bookDaoImp.updateBook(book);
		 if (result > 0) {
				response.sendRedirect("ViewAllBooks.jsp");
			} else {
				response.getWriter().print("<h1>Error</h1>");
			}
		 
		
		
		
		
	}

}
