<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.11.2023
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<div class="main-content" style="width: 500px; height: 500px; margin: auto">
<sf:form action="/mainPage" method="post" modelAttribute="per">
    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <sf:input path="p_email" name="p_email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"/><sf:errors path="p_email"/>
    </div>
    <div class="form-group">
        <label for="nameOfPotentialUser">Put Name</label>
        <sf:input path="p_name" name="p_name" type="text" class="form-control" id="nameOfPotentialUser" placeholder="Enter Name"/><sf:errors path="p_name"/>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <sf:input path="p_password" name="p_password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"/><sf:errors path="p_password"/>
    </div>
    <sf:select path="p_title" name="p_title" class="form-control">
        <sf:option name="p_title" selected ="true" value="WORKER">Worker</sf:option>
        <sf:option name="p_title" value="MANAGER">Manager</sf:option>
        <sf:option name="p_title" value="DIRECTOR">Director</sf:option>
    </sf:select>
    <sf:button type="submit" class="btn btn-primary">Submit</sf:button>
</sf:form>
</div>


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
    <jstl:forEach var="p" items="${saved}">
        <tbody>
        <tr>
            <sf:form action="/mainPage/delete" method="post">
                <th scope="row">${p.id}</th>
                <td>${p.p_name}</td>
                <td>${p.p_email}</td>
                <td>${p.p_title}</td>
                <input type="hidden" name="deleteById" value="${p.id}">
                <td><input type="submit" name="delete_person" value="DELETE"></td>
            </sf:form>
        </tr>
        </tbody>
    </jstl:forEach>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
