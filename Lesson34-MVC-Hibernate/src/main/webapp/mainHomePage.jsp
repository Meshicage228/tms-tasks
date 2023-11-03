<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.11.2023
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<div class="main-content" style="width: 500px; height: 500px; margin: auto;">
<sf:form action="/mainPage" method="post">
    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"/>
    </div>
    <div class="form-group">
        <label for="nameOfPotentialUser">Put Name</label>
        <input name="name" type="text" class="form-control" id="nameOfPotentialUser" placeholder="Enter Name"/>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"/>
    </div>
    <select name="title" class="form-control">
        <option name="title" selected ="true" value="WORKER">Worker</option>
        <option name="title" value="MANAGER">Manager</option>
        <option name="title" value="DIRECTOR">Director</option>
    </select>
    <button type="submit" class="btn btn-primary">Submit</button>
</sf:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
