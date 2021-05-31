<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.DaoImp.BookDaoImp"%>
<%@page import="com.DaoImp.IssueDaoImp"%>
<%@page import="com.DaoImp.StudentDaoImp"%>
<%@page import="com.Dao.BookDao"%>
<%@page import="com.Model.Book"%>
<%@page import="com.Model.Issue"%>
<%@page import="com.Model.Student"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
     BookDaoImp bookDaoImp=new BookDaoImp();
     StudentDaoImp studentDaoImp=new StudentDaoImp();
     IssueDaoImp issueDaoImp=new IssueDaoImp();
    List<Issue> allbooks=issueDaoImp.getAllIssuedBooks();
     Student student=new Student();
     Book book=new Book();
     Issue issue=new Issue();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
       <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="dashboard.jsp?">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="IssueBook.jsp">Issue Book</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="ViewAllIssedBooks.jsp">View All</a>
        </li>
       
       
       
      </ul>
    </div>
  </div>
</nav>
<table class="table">
  <thead>
    <tr>
     
      <th scope="col">Book</th>
       <th scope="col">Student</th>
        <th scope="col">Issue Date</th>
         
      <th scope="col">Actions</th>
      
    </tr>
   <%for(Issue issued:allbooks){ %>
   
     <tr>
         <%book=bookDaoImp.getBookById(issued.getBook().getBook_id());%>
    <td><%=book.getTitle() %></td>
    <%student=studentDaoImp.getStudentById(issued.getStudent().getId());%>
     <td><%=student.getName() %></td>
      <td><%=issued.getIssueDate()%></td>

     
    <td><a href='DeleteIssuedBook?id=<%=issued.getId()%> '>Return Book</a></td>
    
     </tr>
     <%} %>
    
  
    
  </thead>
  <tbody>
    
  </tbody>
</table>
</body>
</html>