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
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDaoImp studentDaoImp=new StudentDaoImp();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Date date=null;
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
            student.setRollNo(rollNo);
            student.setName(name);
          
           student.setContact(contact);
           studentDaoImp.addStudent(student);
           response.sendRedirect("ViewAllStudent.jsp");
           System.out.println(rollNo);
           System.out.println(date);
           System.out.println(name);
           System.out.println(contact);
         
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
