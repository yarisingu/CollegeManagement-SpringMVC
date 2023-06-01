<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
    </head>
    <body>
        <h1 style="color: green">${success}</h1>
        <h1 style="color: red">${fail}</h1>
        <h1>Admin Home Page</h1>
        <a href="/AddCourse.jsp"><button>Add Course</button></a>
        <a href="/admin/stream"><button>Add Stream</button></a>
        <a href="/logout"><button>Logout</button></a>
            
    </body>
    </html>