<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.11.2023
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Title</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <j:forEach var="person" items="${saved}">
    <tbody>
    <tr>
        <sf:form action="/delete" method="post">
        <th scope="row">${person.id}</th>
        <td>${person.name}</td>
        <td>${person.email}</td>
        <td>${person.title}</td>
        <input type="hidden" name="deleteById" value="${person.id}">
        <td><input type="submit" name="delete_person" value="DELETE"></td>
        </sf:form>
    </tr>
    </tbody>
    </j:forEach>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
