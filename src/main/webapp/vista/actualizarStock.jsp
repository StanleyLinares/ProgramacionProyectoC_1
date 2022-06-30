<%-- 
    Document   : actualizarStock
    Created on : 26 jun. 2022, 18:03:14
    Author     : moise
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: darkcyan">
                <div>
                    <p class="navbar-brand">Zapatería</p>
                </div>

                <ul class="navbar-nav">
                    <li><a href="admin.jsp" class="nav-link">Productos</a></li>
                </ul>
                
                <ul class="navbar-nav" >
                    <li><a href="/ProyectoPRN235/index.jsp?out=1" class="nav-link">Cerrar sesión</a></li>
                </ul>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <form action="/ProyectoPRN235/UpdateStock" method="post">
                            <h2>
                                Actualizar stock
                            </h2>   

                        <fieldset class="form-group">
                            <label>Id del producto a actualizar</label> <input type="text" placeholder="Inserte id" class="form-control" name="id" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Stock</label> <input type="text" placeholder="Inserte stock" class="form-control" name="stock">
                        </fieldset>

                        <button type="submit" class="btn btn-success" name="new">Guardar</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
</html>
