<%@page import="org.jsp.jesa5.dto.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Stream</title>
</head>
<body>
<h1 style="color:green">${success}</h1>
<h1 style="color:red">${fail}</h1>
	<h1>Enter Stream Details</h1>
	<br>
	<form action="/admin/stream" method="post">
		Stream Name: <input type="text" name="name"> <br> Stream
		Fee: <input type="text" name="fee"> <br>
		Seats: <input type="number" name="seat"> <br>
		 Select Course: <select
			name="courseName">
			<%
			List<Course> list = (List<Course>) request.getAttribute("list");
			for (Course course : list) {
			%>
			<option><%=course.getName()%></option>
			<%
			}
			%>
		</select>
		<button type="reset">Cancel</button>
		<button>Add</button>
	</form>
	<br>
	<a href="/AdminHome.jsp"><button>Back</button></a>
</body>
</html>