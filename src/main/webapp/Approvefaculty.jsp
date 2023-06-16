<%@page import="com.tarun.collegesoft.dto.Faculty"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Approve Faculty</title>
</head>
<body>
	<%
	List<Faculty> list = (List<Faculty>) request.getAttribute("list");
	%>
	<table border="1">
		<tr>
			<th>Faculty Id</th>
			<th>Faculty Name</th>
			<th>Faculty Mobile</th>
			<th>Subject</th>
			<th>Age</th>
			<th>Education</th>
			<th>Experience</th>
			<th>Status</th>
			<th>Change Status</th>
		</tr>
		<%
		for (Faculty faculty : list) {
		%>
		<tr>
			<th><%=faculty.getId()%></th>
			<th><%=faculty.getName()%></th>
			<th><%=faculty.getMobile()%></th>
			<th><%=faculty.getSubject()%></th>
			<th><%=faculty.getAge()%></th>
			<th><%=faculty.getEducation()%></th>
			<th><%=faculty.getExperience()%></th>
			<th><%=faculty.isStatus()%></th>
			<th><a href="/faculty/change/<%=faculty.getId()%>"><button>Change</button></a></th>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>