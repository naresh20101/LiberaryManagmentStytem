package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.CategoryDao;
import com.DaoImp.CategoryDaoImp;
import com.Model.Category;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 CategoryDaoImp cDao=new CategoryDaoImp();
	 Category c=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		   
		   String category=request.getParameter("category");
			Category ct=new Category();
            ct.setCategory(category);

				int result =cDao.addCategory(ct);

				if (result > 0) {
					response.sendRedirect("ViewAllCategory.jsp");
				} else {
					response.getWriter().print("<h1>Error</h1>");
				}
			}
			
		  // c.setCategory(category);
		  
		  // cDao.addCategory(c);
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
