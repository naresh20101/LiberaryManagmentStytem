<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.DaoImp.StudentDaoImp"%>
<%@page import="com.Dao.StudentDao"%>
<%@page import="com.Model.Student"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
          <a class="nav-link active" aria-current="page" href="Student.jsp">ADD</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="ViewAllStudent.jsp">View All</a>
        </li>
       
       
       
      </ul>
    </div>
  </div>
</nav>

<jsp:useBean id="studentDaoImp" class="com.DaoImp.StudentDaoImp"></jsp:useBean>
<%List<Student> list=studentDaoImp.getStudents();
request.setAttribute("list", list);
%>

<table class="table">
  <thead>
    <tr>
     
      <th scope="col">Roll No</th>
      <th scope="col">Name</th>
      <th scope="col">Date Of Birth</th>
      <th scope="col">Contact</th>
      <th scope="col">Edit</th>
      <th scope="col">Delete</th>
    </tr>
   
    <c:forEach items="${list }" var="u">
     <tr>
    <td>${u.getRollNo() }</td>
    <td>${u.getName()}</td>
    <td>${u.getDateOfBirth() }</td>
    <td>${u.getContact() }</td>
    <td><a href='updateStudent.jsp?id=${u.getId()}'>Edit</a></td>  
    <td><a href='DeleteStudent?id=${u.getId()} '>Delete</a></td>
     </tr>
    
    </c:forEach>
    
  </thead>
  <tbody>
    
  </tbody>
</table>
</body>
</html>