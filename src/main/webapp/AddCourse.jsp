<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Course</title>
</head>
<body>
	<h1 style="color: green">${success}</h1>
	<h1 style="color: red">${fail}</h1>
	<h1>Enter Course Details</h1>
	<form action="/admin/course" method="post">
		Course Name: <input type="text" name="name"> Course Fee: <input
			type="text" name="fee"> Course Duration: <input type="number"
			name="duration">
		<button type="reset">Cancel</button>
		<button>Add</button>
	</form>
	<a href="/jsp/AdminHome.jsp">Back</a>
</body>
</html>