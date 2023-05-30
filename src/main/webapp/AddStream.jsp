<%@page import="com.tarun.collegesoft.dto.Cources"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 style="color:green">${success}</h1>
	<h1 style="color:red">${fail}</h1>
	<h1>Enter Stream Details</h1>
	<br>
	
<form action="/admin/stream" method="post">

Stream Name : <input type="text" name="cname" placeholder="Course Name"  required="required">
<br>
Steam Fee : <input type="text" name="fee" placeholder="Cource Fee"  required="required">
<br>
Seats: <input type="number" name="seat" placeholder="Enter NUmber of Seats" required="required"> <br>
Select Course: <select
			name="courseName">
			<%
			List<Cources> list = (List<Cources>) request.getAttribute("list");
			for (Cources course : list) {
			%>
			<option><%=course.getCname()%></option>
			<%
			}
			%>
		</select>
<br>
<button type="reset">clear</button>
<button  type="submit">submit</button>

</form>
	<a href="/"><button>Home</button></a>

</body>
</html>