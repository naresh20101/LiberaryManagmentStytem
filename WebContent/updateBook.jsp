<%@page import="com.Dao.CategoryDao"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.DaoImp.BookDaoImp"%>
<%@page import="com.DaoImp.CategoryDaoImp"%>
<%@page import="com.Dao.BookDao"%>
<%@page import="com.Model.Book"%>
<%@page import="com.Model.Category"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%
    	Integer id = Integer.parseInt(request.getParameter("id"));
      System.out.println("id is "+ id);
      BookDaoImp bookDaoImp=new BookDaoImp();
      Book book=bookDaoImp.getBookById(id);
      CategoryDaoImp categoryDaoImp=new CategoryDaoImp();
      List<Category> allCategories=categoryDaoImp.getCategory();
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<style>
 .form{
        width: 382px;  
        overflow: hidden;  
        margin: auto;  
        margin: 20 0 0 450px;  
        padding: 80px;  
        background-color:rgb(105,105,105);
        border-radius: 30px ;
        margin-top: 100px;
 }
 
 </style>
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
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="dashboard.jsp?">Home</a>
        </li>
          <a class="nav-link active" aria-current="page" href="Student.jsp?">ADD</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="ViewAllStudent.jsp">View All</a>
        </li>
       
       
       
      </ul>
    </div>
  </div>
</nav>
<div class="form" >
<form id="category" action="UpdateBook" method="post">
  <table>
  <tr>
    <td> <input type="hidden" name="id" value="<%=book.getBook_id()%>"><td>
	
	</tr>
		<tr>
			
			<td><input type="text" name="title" value="<%=book.getTitle() %>"></td>
		
		</tr>
		<tr>
			
			<td><input type="text" name="author" value="<%=book.getAuthor()%>"></td>
		
		</tr>
		<tr>
			
			<td><input type="number" name="NoOfCopies" value="<%=book.getNoOfCopies()%>"></td>
		
		</tr>
		<td>
	      	    <select name="category">
		 <%  Category category=categoryDaoImp.getCategoryById(book.getCategory().getId());%>
		     
		           <option><%=category.getCategory()%></option>
		     <%for(Category c1:allCategories){ %>
		        <option><%=c1.getCategory()%></option>
		       <%} %>
		      
		</select>
		</td>
		
		
        <tr>
		<td><button type="submit" class="btn btn-dark" id="log">UPDATE</button></td>
		</tr>
		
		
	</table>
</form>


</div>
</body>
</html>