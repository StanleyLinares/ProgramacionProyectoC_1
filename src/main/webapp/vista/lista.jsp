<%-- 
    Document   : lista
    Created on : 11 jun. 2022, 17:04:05
    Author     : moise
--%>

<%@page import="dao.RolesDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="dao.UsuariosDAO"%>
<%@page import="modelo.Usuarios"%>
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

                <ul class="navbar-nav">
                    <li><a href="sesiones.jsp" class="nav-link">Sesiones</a></li>
                </ul>

                <ul class="navbar-nav" >
                    <li><a href="/ProyectoPRN235/index.jsp?out=1" class="nav-link">Cerrar sesión</a></li>
                </ul>

            </nav>
        </header>
        <br>

        <div class="row">
            <div class="container">
                <h3 class="text-center">Listado de usuarios</h3>
                <hr>
                <div class="container text-left">

                    <a href="nuevoUsr.jsp" class="btn btn-success">Nuevo usuario</a>
                    <a href="actualizarUsr.jsp" class="btn btn-success">Actualizar usuario</a>
                    <a href="añadirRol.jsp" class="btn btn-success">Asignar rol</a>
                </div>
                <br>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Apellidos</th>
                            <th>Contraseña</th>
                            <th>Usuario Generado</th>
                            <th>Rol</th>
                        </tr>
                    </thead>
                    <%
                        UsuariosDAO dao = new UsuariosDAO();
                        RolesDAO roles = new RolesDAO();
                        List<Usuarios> usuarios = dao.listar();
                        Iterator<Usuarios> iterar = usuarios.iterator();
                        Usuarios usuario = null;
                        while (iterar.hasNext()) {
                            usuario = iterar.next();
                            String rol = "";
                            Integer value = roles.asignarRol(usuario);
                            if (value == 0) {
                                rol = "Recursos humanos";
                            } else if (value == 1) {
                                rol = "Administración de productos";
                            } else if (value == 2) {
                                rol = "Registro de ventas";
                            } else if (value == 3){
                                rol = "";
                        }
                    %>
                    <tbody>
                        <tr>
                            <td><%=usuario.getId()%></td>
                            <td><%=usuario.getNombre()%></td>
                            <td><%=usuario.getApellidos()%></td>
                            <td><%=usuario.getContrasena()%></td>
                            <td><%=usuario.getUsuarioGenerado()%></td>
                            <td><%=rol%></td>
                        </tr>
                        <%
                            rol = "";
                            }%>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
