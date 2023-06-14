
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Faculty Login</title>
</head>
<body>
<%-- <h1 style="color:green">${success}</h1>
<h1 style="color:red">${fail}</h1> --%>


<div>
<form action="/alllogin" method="post">
    Email:<input type="text" name="id" placeholder="Enter The id " required="required">
    Password:<input type="text" name="password" placeholder="Enter password" required="required">
    <button>Login</button><button type="reset">Cancel</button>
</form>
<a href="/FacultySignup.jsp"><button>New? Click here to Create an Account For Faculty SignUP</button></a>
<a href="/StaffSignup.jsp"><button>New? Click here to Create an Account For Staff SignUP</button></a>
<a href="index.html"><button>Home</button></a>
</div>
</body>
</html>