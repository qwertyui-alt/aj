<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Education Information</title>
</head>
<body>
	<%
	String degree = request.getParameter("degree");
	String university = request.getParameter("university");
	
	if (degree==null || university==null) {
	%>
	
	<h2> Enter Education Details </h2>
	<form action = "" method = "post">
		Degree: <input type = "text" name = "degree">
		University: <input type = "text" name = "university">
		<input type = "submit" value = "Submit">
	</form>
	
	<%
	} else {
	%>
	
	<p> Student details received </p>
	<p><b>Degree: </b> <%= degree %> </p>
	<p><b>University: </b> <%= university %></p>
	
	<a href = "hello.jsp">Go Back</a>
	
	<%
	}
	%>
</body>
</html>