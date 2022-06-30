<%-- 
    Document   : nuevaVenta
    Created on : 27 jun. 2022, 16:40:12
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
                    <li><a href="productos.jsp" class="nav-link">Productos</a></li>
                </ul>    

                <ul class="navbar-nav">
                    <li><a href="ventas.jsp" class="nav-link">Ventas</a></li>
                </ul>
                
                <ul class="navbar-nav" >
                    <li><a href="/ProyectoPRN235/index.jsp?out=1" class="nav-link">Cerrar sesión</a></li>
                </ul>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <form action="/ProyectoPRN235/NuevaVenta" method="post">
                            <h2>
                                Generar nueva venta
                            </h2>   

                        <fieldset class="form-group">
                            <label>Id del producto a vender</label> <input type="text" placeholder="Inserte id" class="form-control" name="id" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Cantidad a vender</label> <input type="text" placeholder="Inserte cantidad" class="form-control" name="cantidad">
                        </fieldset>

                        <button type="submit" class="btn btn-success" name="new">Guardar</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
</html>
