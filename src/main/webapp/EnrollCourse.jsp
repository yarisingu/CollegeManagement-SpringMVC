
<%@page import="com.tarun.collegesoft.dto.Stream"%>
<%@page import="com.tarun.collegesoft.dto.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enroll Course</title>
<script>
function updateStreams() {
    var courseDropdown = document.getElementById('courseDropdown');
    var streamDropdown = document.getElementById('streamDropdown');
    var selectedCourse = courseDropdown.value;

    streamDropdown.innerHTML = '';

    var streams = [];

    <%
    List<Course> list = (List<Course>) request.getAttribute("list");
    for (Course course : list) {
        %>
        if (selectedCourse === '<%= course.getName() %>') {
            <% for (Stream stream : course.getStreams()) { %>
                streams.push('<%= stream.getName() %>');
            <% } %>
        }
        <%
    }
    %>

    streams.forEach(function(stream) {
        var option = document.createElement('option');
        option.value = stream;
        option.textContent = stream;
        streamDropdown.appendChild(option);
    });
}
</script>
</head>
<body>
<form action="/student/enroll" method="post">
    <h1>Select Course and Stream</h1>
    <select id="courseDropdown" onchange="updateStreams()" name="course">
    <option>Select One Course</option>
        <%
        for (Course course : list) {
        %>
        <option><%= course.getName() %></option>
        <%
        }
        %>
    </select>
    <select id="streamDropdown" name="stream">
    </select>
    <button>Enroll</button><button type="reset">Cancel</button>
</form>
</body>
</html>