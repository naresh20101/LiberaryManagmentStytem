<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
 body{
  background-color:rgb(64, 61, 61);  

 }
  
</style>
</head>
<body>
<div class="form" >
<form id="login" action="TestServlet" method="post">
  <table>
	
		<tr>
			
			<td><input type="email" placeholder="Enter your email address" id="mail" name="email"/></td>
		
		</tr>
		

		
		<tr>
			
			<td><input type="password" placeholder="Enter your password"  id="pass" name="password" /></td>
		</tr>
		
		
        <tr>
		<td><button type="submit" class="btn btn-dark" id="log">Login</button></td>
		</tr>
		
		
	</table>
</form>


</div>

</body>
</html>