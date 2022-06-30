<%-- 
    Document   : actualizarUsr
    Created on : 12 jun. 2022, 17:51:11
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
                    <li><a href="lista.jsp" class="nav-link">Usuarios</a></li>
                </ul>

                <ul class="navbar-nav" >
                    <li><a href="/ProyectoPRN235/index.jsp?out=1" class="nav-link">Cerrar sesión</a></li>
                </ul>
        </header>
        <br>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <form action="/ProyectoPRN235/UpdateUsr" method="post">
                        <h2>
                            Actualizar un usuario
                        </h2>
                        
                        <fieldset class="form-group">
                            <label>Id del usuario a actualizar</label> <input type="text" placeholder="Inserte Id" class="form-control" name="id" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Nombre</label> <input type="text" placeholder="Inserte nombre" class="form-control" name="nombre">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Apellidos</label> <input type="text" placeholder="Inserte apellidos" class="form-control" name="apellidos">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Contraseña</label> <input type="text" placeholder="Inserte contraseña" class="form-control" name="pass">
                        </fieldset>

                        <button type="submit" class="btn btn-success" name="new">Guardar</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
