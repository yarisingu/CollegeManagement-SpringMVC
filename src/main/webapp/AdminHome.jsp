<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
	<h1 style="color: green">${success}</h1>
	<h1 style="color: red">${fail}</h1>
	<h1>Admin Home Page</h1>
	<a href="/AddCourse.jsp"><button>Add Course</button></a>
	<a href="/admin/stream"><button>Add Stream</button></a>
	<a href="/admin/admission"><button>Approve Admission</button></a>
	<a href="/logout"><button>Logout</button></a>
</body>
</html>