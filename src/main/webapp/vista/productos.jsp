<%-- 
    Document   : productos
    Created on : 29 jun. 2022, 23:40:24
    Author     : moise
--%>

<%@page import="modelo.Productos"%>
<%@page import="dao.ProductosDAO"%>
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
                    <li><a href="ventas.jsp" class="nav-link">Ventas</a></li>
                </ul>
                
                <ul class="navbar-nav">
                    <li><a href="productos.jsp" class="nav-link">Productos</a></li>
                </ul>
                
                <ul class="navbar-nav" >
                    <li><a href="/ProyectoPRN235/index.jsp?out=1" class="nav-link">Cerrar sesión</a></li>
                </ul>
                
            </nav>
        </header>
        <br>

        <div class="row">
            <div class="container">
                <h3 class="text-center">Listado de productos</h3>
                <hr>
                <div class="container text-left">

                </div>
                <br>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Descripción</th>
                            <th>Precio</th>
                            <th>Stock</th>
                        </tr>
                    </thead>
                    <%
                        ProductosDAO dao = new ProductosDAO();
                        List<Productos> productos = dao.listar();
                        Iterator<Productos> iterar = productos.iterator();
                        Productos producto = null;
                        while (iterar.hasNext()) {
                            producto = iterar.next();
                    %>
                    <tbody>
                        <tr>
                            <td><%=producto.getId()%></td>
                            <td><%=producto.getNombre()%></td>
                            <td><%=producto.getDescripcion()%></td>
                            <td>$<%=producto.getPrecio()%></td>
                            <td><%=producto.getStock()%></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
