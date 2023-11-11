<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.11.2023
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="jc" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="mainScene" style="margin: auto; width: 300px; height: 300px;">
<sf:form action="/home/save" method="post" modelAttribute="film">
    <div class="form-group">
        <label for="exampleInputEmail1">Title of film</label>
        <sf:input path="title" name="title" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter film-title"/><sf:errors path="title"/>
    </div>
    <div class="form-group">
        <label for="exampleFormControlSelect1">Choose genre for film : </label>
        <sf:select path="genre" class="form-control" id="exampleFormControlSelect1">
            <sf:option value="HORROR">Horror</sf:option>
            <sf:option value="COMEDY">Comedy</sf:option>
            <sf:option value="DRAMA">Drama</sf:option>
        </sf:select>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Write date of film creation</label>
        <sf:input path="dateOfCreation" name="dateOfCreation" type="text" class="form-control" id="exampleInputPassword1" placeholder="Date of creation"/><sf:errors path="dateOfCreation"/>
    </div>
    <div class="form-group">
        <label for="exampleNumber">Write date of film creation</label>
        <sf:input path="rating" name="rating" type="number" class="form-control" id="exampleNumber" placeholder="Rating from 0 to 10"/><sf:errors path="rating"/>
    </div>
    <sf:button type="submit" class="btn btn-primary">Submit</sf:button>
</sf:form>
</div>

<jc:forEach items="${films}" var ="myFilm">
    ${myFilm.title}
    ${myFilm.rating}
    ${myFilm.genre}
    ${myFilm.dateOfCreation}
</jc:forEach>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
