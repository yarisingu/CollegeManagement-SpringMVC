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

<h1>Enter Course Details</h1>
	<br>
<form action="/admin/course" method="post">

Cource Name : <input type="text" name="cname" placeholder="Course Name"  required="required">
<br>
Cource Fee : <input type="text" name="fee" placeholder="Cource Fee"  required="required">
<br>
Cource Duration: <input type="number" name="duration" placeholder="Cource Duration"  required="required">
<br>
<button type="reset">clear</button>
<button  type="submit">submit</button>

</form>
	<a href="/"><button>Home</button></a>
</body>
</html>