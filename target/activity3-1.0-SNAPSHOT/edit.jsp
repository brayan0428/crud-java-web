<%-- 
    Document   : edit
    Created on : 10/02/2023, 11:57:48 AM
    Author     : braya
--%>
<%@page import="com.models.Libro"%>
<% 
    Libro libro = (Libro)request.getAttribute("libro");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Libro</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-4">
            <h1>Editar Libro</h1>
            <form method="POST" action="MainController">
                <input name="id" type="hidden" value="${libro.id}" />
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>Titulo</label>
                            <input type="text" class="form-control" name="titulo" value="${libro.titulo}"/>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>ISBN</label>
                            <input type="text" class="form-control" name="isbn" value="${libro.isbn}"/>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>Categoria</label>
                            <input type="text" class="form-control" name="categoria" value="${libro.categoria}"/>
                        </div>
                    </div>   
                    <div class="col-md-12 d-flex mt-3 justify-content-end">
                        <button type="submit" class="btn btn-primary me-2">Guardar</button>
                        <a href="MainController" class="btn btn-warning">Cancelar</a>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
