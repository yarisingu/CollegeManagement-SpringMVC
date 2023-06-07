<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Admission</title>
</head>
<body>
<h1>Hello ${name}</h1>
<h1>You have opted for ${course} course in ${stream} stream</h1>
<h1>You are eligible for ${quota} quota</h1>
<h1>Your fee will be &#8377 ${fee}</h1>
<a href="/student/accept"><button>Accept</button></a>
<a href="/student/reject"><button>Reject</button></a>
</body>
</html>