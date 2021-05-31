package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DaoImp.CategoryDaoImp;
import com.Model.Category;

/**
 * Servlet implementation class UpdateCategory
 */
@WebServlet("/UpdateCategory")
public class UpdateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryDaoImp cDao=new CategoryDaoImp();
	 Category c=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCategory() {
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
    String category=request.getParameter("category");
	
   
	c = cDao.getCategoryById(id);
	 c.setId(id);
	c.setCategory(category);

	int result =cDao.updateCategory(c);

	if (result > 0) {
		response.sendRedirect("ViewAllCategory.jsp");
	} else {
		response.getWriter().print("<h1>Error</h1>");
	}
	}

}
