<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14.10.2023
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/styleInfoPage.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<a href="/info?lang=ru">RUS</a>
<a href="/info?lang=en">ENG</a>

<sp:message code="label.title"/>

<div class="scene" style="width: 500px; height: 230px; margin: auto;">
<sf:form action="/info" method="post" modelAttribute="user">
    <label for="nameOfUser">Your name : </label>
    <sf:input path="name" name="name" class="form-control" type="text" placeholder="Default input" id="nameOfUser"/> <sf:errors path="name"/>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <sf:input path="password" type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password"/> <sf:errors path="password"/>
    </div>
    <div class="form-group">
        <label for="exampleFormControlSelect2">Select your post : </label>
        <sf:select path="jobTitle" name="jobTitle" class="form-select" aria-label="Default select example" id="exampleFormControlSelect2">
            <sf:option selected="true" value="WORKER">Worker</sf:option>
            <sf:option value="MANAGER">Manager</sf:option>
            <sf:option value="DIRECTOR">Director</sf:option>
            <sf:option value="ADMINISTRATOR">Administrator</sf:option>
        </sf:select>
    </div>
    <div class="form-group">
        <label for="exampleFormControlInput1">Email address</label>
        <sf:input path="email" type="email" name="email" class="form-control" id="exampleFormControlInput1"
               placeholder="name@example.com"/> <sf:errors path="email"/>
    </div>
    <sf:button type="submit" class="btn btn-primary">Submit</sf:button>
</sf:form>
</div>
<table class="table" style="margin-top: 100px">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Post</th>
        <th scope="col">Email</th>
    </tr>
    </thead>
    <c:forEach var="user" items="${users}">
    <tbody>
    <tr>
        <td>${user.name}</td>
        <td>${user.jobTitle}</td>
        <td>${user.email}</td>
    </tr>
    </tbody>
    </c:forEach>

</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
