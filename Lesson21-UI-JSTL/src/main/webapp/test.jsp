<%@ page import="java.util.Arrays" %>
<%@ page import="domain.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="mystyle.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>

<c:if test="${toshow == true}">
    <div class="alert alert-danger alert-dismissible">
        <strong>Не все поля введены!</strong>
    </div>
</c:if>


<div class="content">
    <form action="/add" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1">Название</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="title" aria-describedby="emailHelp"
                   placeholder="Наименование продукта">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Вес</label>
            <input type="number" min="0" class="form-control" name="weight" id="exampleInputPassword1"
                   placeholder="Вес">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword12">Высота</label>
            <input type="number" min="0" class="form-control" name="height" id="exampleInputPassword12"
                   placeholder="Высота">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Название</th>
        <th scope="col">Вес</th>
        <th scope="col">Высота</th>
        <th scope="col">Удаление</th>
    </tr>
    </thead>
    <c:forEach items="${product}" var="product">
        <tbody>
        <tr>
            <form action="/delete" method="post">
                <th scope="row">${product.title}</th>
                <td>${product.weight}</td>
                <td>${product.height}</td>
                <input type="hidden" name="deleteId" value="${product.id}">
                <td><input type="submit" value="delete"></td>
            </form>
        </tr>
        </tbody>
    </c:forEach>
</table>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>
</html>
