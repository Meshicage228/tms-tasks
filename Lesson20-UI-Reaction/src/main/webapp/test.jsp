<%@ page import="java.util.Arrays" %>
<%@ page import="domain.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<div class="content">
    <form action="/add" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1">Название</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="title" aria-describedby="emailHelp"
                   placeholder="Наименование продукта">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Вес</label>
            <input type="number" class="form-control" name="weight" id="exampleInputPassword1" placeholder="Вес">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword12">Высота</label>
            <input type="number" class="form-control" name="height" id="exampleInputPassword12" placeholder="Высота">
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
    <%
        Object product = request.getAttribute("product");

        if (product != null) {
            List<Product> productList = (List<Product>) request.getAttribute("product");
            for (Product products : productList) {
                out.println("<tbody>");
                out.println("<tr>");
                out.println("<form action ='/delete' method = 'post'>");
                out.println("<th scope='row'>" + products.getTitle() + "</th>");
                out.println("<td>" + products.getWeight() + "</td>");
                out.println("<td>" + products.getHeight() + "</td>");
                out.println("<input type ='hidden' name = 'deleteId' value = '" + products.getId() + "'>");
                out.println("<td><input type ='submit' value = 'delete'></td>");
                out.println("</li>");
                out.println("</form>");
                out.println("</tr>");
                out.println("</tbody>");
            }
        }
    %>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>
</html>
