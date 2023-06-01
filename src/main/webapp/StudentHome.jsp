<%@page import="org.jsp.jesa5.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Home</title>
</head>
<body>
	<h1 style="color: green">${success}</h1>
	<h1 style="color: red">${fail}</h1>
	<% 
	Student student=(Student)session.getAttribute("student");
	if(student==null)
	{
	request.setAttribute("fail","Invalid Session Login Again");
	request.getRequestDispatcher("StudentLogin.jsp").forward(request,response);
	}
	else{
		if(student.getStream()==null)
		{
	%>
	<a href="/student/course"><button>Enroll for course</button></a>
	<%}%>
	
	<a href="/logout"><button>Logout</button></a>
	<%} %>
</body>
</html>