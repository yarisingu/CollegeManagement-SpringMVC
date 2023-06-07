<%@page import="com.tarun.collegesoft.dto.Student"%>
<%@page import="java.util.Random"%>

<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<style type="text/css">
body {
    background: grey;
    margin-top: 120px;
    margin-bottom: 120px;
}
</style>
<title>Challan</title>
</head>
<body>
<%Student student=(Student)session.getAttribute("student"); %>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body p-0">
                    <div class="row p-5">
                        <div class="col-md-6">
                            <img src="data:image/jpeg;base64,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">
                        </div>

                        <div class="col-md-6 text-right">
                            <p class="font-weight-bold mb-1">Challan</p>
                            <p class="text-muted">Due to: <%=LocalDate.now() %></p>
                        </div>
                    </div>

                    <hr class="my-5">

                    <div class="row pb-5 p-5">
                        <div class="col-md-6">
                            <p class="font-weight-bold mb-4">Student Details</p>
                            <p class="mb-1"><%=student.getName() %></p>
                            <p></p>
                            <p class="mb-1"><%=student.getEmail() %></p>
                            <p class="mb-1"><%=student
                            .getMobile()%></p>
                        </div>

                        <div class="col-md-6 text-right">
                            <p class="font-weight-bold mb-4">Payment Details</p>
                            <p class="mb-1"><span class="text-muted">VAT: </span> 1425782</p>
                            <p class="mb-1"><span class="text-muted">VAT ID: </span> <%=new Random().nextInt(10000,100000) %></p>
                            <p class="mb-1"><span class="text-muted">Payment Type: </span> Offline/Bank</p>
                            <p class="mb-1"><span class="text-muted">Name: </span> <%=student.getName() %></p>
                        </div>
                    </div>

                    <div class="row p-5">
                        <div class="col-md-12">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th class="border-0 text-uppercase small font-weight-bold">ID</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">Course Name</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">Stream Name</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">Course Fee</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">Stream Fee</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><%=student.getId() %></td>
                                        <td><%=student.getCourse().getName() %></td>
                                        <td><%=student.getStream().getName() %></td>
                                        <td><%=student.getCourse().getFee() %></td>
                                        <td><%=student.getStream().getFee() %></td>
                                        <td><%=(student.getStream().getFee()+student.getCourse().getFee() )%></td>
                                    </tr>
                                  
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="d-flex flex-row-reverse bg-dark text-white p-4">
                        <div class="py-3 px-5 text-right">
                            <div class="mb-2">Grand Total</div>
                            <div class="h2 font-weight-light"><%=(student.getStream().getFee()+student.getCourse().getFee() )%></div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
<button onclick="window.print()">Print</button>
</div>
</body>
</html>