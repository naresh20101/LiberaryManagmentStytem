package com.Servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DaoImp.StudentDaoImp;
import com.Model.Student;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDaoImp studentDaoImp=new StudentDaoImp();

	Date date=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
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
		String rollNo=request.getParameter("rollNo");
        String name=request.getParameter("name");
        String contact=request.getParameter("contact");
        String parameter=request.getParameter("date");
        Student student=new Student();
        if(parameter!=null)
        {
     	date=Date.valueOf(parameter);
         student.setDateOfBirth(date);
        }
	   
		student.setId(id);
		student.setRollNo(rollNo);
		student.setName(name);
		student.setContact(contact);

		int result =studentDaoImp.updateStudent(student);
		System.out.println(rollNo);
		System.out.println(id);
		System.out.println(name);
		System.out.println(contact);
		System.out.println(date);

		if (result > 0) {
			response.sendRedirect("ViewAllStudent.jsp");
		} else {
			response.getWriter().print("<h1>Error</h1>");
		}
	}

}
