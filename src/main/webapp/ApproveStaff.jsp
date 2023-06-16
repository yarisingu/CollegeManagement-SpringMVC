
<%@page import="com.tarun.collegesoft.dto.Staff"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Approve Staff</title>
</head>
<body>
	<%
	List<Staff> list = (List<Staff>) request.getAttribute("list");
	%>
	<table border="1">
		<tr>
			<th>Staff Id</th>
			<th>Staff Name</th>
			<th>Staff Mobile</th>
			<th>Age</th>
			<th>Status</th>
			<th>Change Status</th>
		</tr>
		<%
		for (Staff staff : list) {
		%>
		<tr>
			<th><%=staff.getId()%></th>
			<th><%=staff.getName()%></th>
			<th><%=staff.getMobile()%></th>
			<th><%=staff.getAge()%></th>
			<th><%=staff.isStatus()%></th>
			<th><a href="/staff/change/<%=staff.getId()%>"><button>Change</button></a></th>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>