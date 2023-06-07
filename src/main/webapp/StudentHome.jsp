
<%@page import="com.tarun.collegesoft.dto.Student"%>
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
	else{%>
<%if(!student.isStatus()){%>
<a href="/student/course"><button>Enroll for course</button></a>
<%}else{
if(student.getDoj()==null){%>
<a href="/PrintChallan.jsp"><button>Print Challan</button></a>
<%}}%>
<a><button>View Id Card</button></a>
<a><button>View Library Card</button></a>
<a><button>View TimeTable</button></a>
<a href="/logout"><button>Logout</button></a>
<%} %>
</body>
</html>