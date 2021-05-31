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
     BookDaoImp bookDaoImp=new BookDaoImp();
    CategoryDaoImp categoryDaoImp=new CategoryDaoImp();
    List<Book> allbooks=bookDaoImp.getAllBooks();
    Category category=new Category();
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
          <a class="nav-link active" aria-current="page" href="Book.jsp">ADD</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="ViewAllBooks.jsp">View All</a>
        </li>
       
       
       
      </ul>
    </div>
  </div>
</nav>

<table class="table">
  <thead>
    <tr>
     
      <th scope="col">Title</th>
       <th scope="col">Author</th>
        <th scope="col">No Of Copies</th>
         <th scope="col">Category Name</th>
      <th scope="col">Edit</th>
      <th scope="col">Delete</th>
    </tr>
   <%for(Book book:allbooks){ %>
   
     <tr>
    <td><%=book.getTitle() %></td>
     <td><%=book.getAuthor() %></td>
      <td><%=book.getNoOfCopies() %></td>
     <%  category=categoryDaoImp.getCategoryById(book.getCategory().getId());%>
      <td><%=category.getCategory()%></td>
    <td><a href='updateBook.jsp?id=<%=book.getBook_id()%>'>Edit</a></td>  
    <td><a href='DeleteBook?id=<%=book.getBook_id()%> '>Delete</a></td>
    
     </tr>
     <%} %>
    
  
    
  </thead>
  <tbody>
    
  </tbody>
</table>
</body>
</html>