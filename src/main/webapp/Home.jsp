<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	
	<h1>Well come to home page</h1>
	<h1>${msg}</h1>
	<%if(session.getAttribute("admin")==null){%>
	<a href="/admin/login"><button>Click hear to Login as a Admin</button></a>
	<% }else{%>
	<a href="/admin/course"><button>Add course</button></a><br>
	<a href="/admin/course"><button>Add course</button></a><br>
	<a href="/logout"><button>Logout</button></a>
	<%} %>
</body>
</html>