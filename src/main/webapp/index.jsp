<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : 10/02/2023, 10:15:07 AM
    Author     : braya
--%>

<%@page import="java.util.List"%>
<%@page import="com.models.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Libro> libros = (List<Libro>)request.getAttribute("libros");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Libros</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-4">
            <h1>Listado de Libros</h1>
            <a href="MainController?op=new" class="btn btn-primary">Crear nuevo</a>
            <table class="table table-bordered mt-3">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Titulo</th>
                        <th>ISBN</th>
                        <th>Categoria</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="libro" items="${libros}">
                        <tr>
                            <td>${libro.id}</td>
                            <td>${libro.titulo}</td>
                            <td>${libro.isbn}</td>
                            <td>${libro.categoria}</td>
                            <td>
                                <a href="MainController?op=edit&id=${libro.id}" class="btn btn-info">Editar</a>
                                <a href="MainController?op=delete&id=${libro.id}" class="btn btn-danger" onclick="return confirm('¿Esta seguro que desea eliminar el libro?')">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>