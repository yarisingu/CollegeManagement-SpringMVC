<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
<h1 style="color:green">${success}</h1>
<h1 style="color:red">${fail}</h1>
<form action="/admin/login" method="post">
Email:<input type="text" name="email" placeholder="Enter email" required="required">
Password:<input type="text" name="password" placeholder="Enter password" required="required">
<button>Login</button><button type="reset">Cancel</button>
</form>
<a href="/"><button>Home</button></a>
</body>	
</html>