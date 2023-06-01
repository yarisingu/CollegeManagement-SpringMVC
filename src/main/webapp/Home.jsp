<%@page import="org.jsp.jesa5.dto.Course"%>
<%@page import="java.util.List"%>
<%@page import="org.jsp.jesa5.dao.CourseDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1 style="color: green">${success}</h1>
	<h1 style="color: red">${fail}</h1>
	<h1>Welcome to Home page</h1>
	<br>
	<a href="/AdminLogin.jsp"><button>Click here to Login as
			Admin</button></a>
	<a href="/StudentLogin.jsp"><button>Click here to Login as
			Student</button></a>
	<a href="/FacultyLogin.jsp"><button>Click here to Login as
			Faculty</button></a>
	<a href="/StaffLogin.jsp"><button>Click here to Login as
			Staff</button></a>

</body>
</html>