<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Course</title>
</head>
<body>
<h1 style="color:green">${success}</h1>
<h1 style="color:red">${fail}</h1>
	<h1>Enter Course Details</h1>
	<br>
	<form action="/admin/course" method="post">
Course Name: <input type="text" name="name">
		<br>
Course Fee: <input type="text" name="fee">
		<br>
Course Duration: <input type="number" name="duration">
		<br>
		<button type="reset">Cancel</button>
		<button>Add</button>
	</form>
	<br>
	<a href="/AdminHome.jsp"><button>Back</button></a>
</body>
</html>