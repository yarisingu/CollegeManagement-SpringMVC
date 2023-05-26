<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="x" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>${msg}</h1>
<x:form action="/admin/login" method="post" modelAttribute="login" >
Enter email : <input type="text" name="email" placeholder="Enter your email"  required="required">
Enter passcode : <input type="text" name="passcode" placeholder="Enter your passcode"  required="required">
<button  type="submit">submit</button>
</x:form>

<br>
<a href="/"><button>Home</button></a>
</body>
</html> 