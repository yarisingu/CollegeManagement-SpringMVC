<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Signup</title>
</head>
<body>
	<h1 style="color: green">${success}</h1>
	<h1 style="color: red">${fail}</h1>
	<form action="/student/signup" method="post" enctype="multipart/form-data">
		Name:<input type="text" name="name"><br> Email:<input
			type="email" name="email"><br> Mobile:<input type="text"
			name="mobile"><br> Gender:<input type="radio"
			name="gender" value="male">Male <input type="radio"
			name="gender" value="female">Female<br> Date of Birth: <input
			type="date" name="date"><br> Password:<input
			type="password" name="password"><br>10th Percentage:<input
			type="text" name="sslc"><br>PUC Percentage:<input
			type="text" name="puc"><br> Picture: <input type="file"
			name="pic" accept="image/png, image/gif, image/jpeg">
		<button type="reset">Cancel</button>
		<button>Signup</button>
	</form>
	<br>
	<a href="/StudentLogin.jsp"><button>Back</button></a>
</body>
</html>