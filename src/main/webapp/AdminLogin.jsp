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


<form action="/admin/login" method="post"  >
Enter email : <input type="text" name="email" placeholder="Enter your email"  required="required"><br>
Enter Password : <input type="text" name="passcode" placeholder="Enter your passcode"  required="required"><br>
<button  type="reset">Clear</button>
<button  type="submit">submit</button>
</form>

<br>
<a href="/"><button>Home</button></a>
</body>
</html> 