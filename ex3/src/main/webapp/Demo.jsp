<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		String name = request.getParameter("name");
		String degree = request.getParameter("degree");
		
		if (name == null || degree == null )
		{
			
	%>
		
		<form action = "" method = "post">
		Name:
		<input type = "text" name = "name">
		Degree:
		<input type = "text" name = "degree">
		<input type = "submit" value = "submit">
		</form>
		
	<%
		}else{
				
	%>
	
		<h2>Education Details Received.</h2>
			Name: <%= name %> <br>
			Degree: <%= degree %> <br>
		
	<%
		}
	%>
	
	<a href = "Demo.jsp">Previous</a>
</body>
</html>