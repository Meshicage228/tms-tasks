<%@ page import="java.util.Arrays" %>
<%@ page import="domain.Fridge" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
Hello!
    <form action="/add" method="post">
        <label>Название</label>><input type="text" name="title"><br>
        <label>Вес</label>><input type="number" name="weight"><br>
        <label>Высота</label>><input type="number" name="height"><br>
        <input type="submit" name="Add">
    </form>

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
    Object fridges = request.getAttribute("fridges");

    if(fridges != null){
        List<Fridge> fridgeList = (List<Fridge>) request.getAttribute("fridges");
        for(Fridge fridge : fridgeList){
            out.println("<tbody>");
            out.println("<tr>");
            out.println("<form action ='/delete' method = 'post'>");
            out.println("<th scope='row'>" + fridge.getTitle() + "</th>");
            out.println("<td>" + fridge.getWeight() + "</td>");
            out.println("<td>" + fridge.getHeight() + "</td>");
            out.println("<input type ='hidden' name = 'deleteId' value = '" + fridge.getId() + "'>");
            out.println("<td><input type ='submit' value = 'delete'></td>");
            out.println("</li>");
            out.println("</form>");
            out.println("</tr>");
            out.println("</tbody>");
        }
    }
%>
    </table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>
