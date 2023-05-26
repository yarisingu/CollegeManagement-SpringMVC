<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<x:form action="/admin/course" method="post">

Cource Name : <input type="text" name="cname" placeholder="Course Name"  required="required">
<br>
Cource Fee : <input type="text" name="fee" placeholder="Cource Fee"  required="required">
<br>
Cource Duration: <input type="number" name="duration" placeholder="Cource Duration"  required="required">
<br>
<button type="reset">clear</button>
<button  type="submit">submit</button>

</x:form>
	<a href="/"><button>Home</button></a>

</body>
</html>