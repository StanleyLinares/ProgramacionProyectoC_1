<%-- 
    Document   : ventas
    Created on : 26 jun. 2022, 20:11:51
    Author     : moise
--%>

<%@page import="modelo.Productos"%>
<%@page import="dao.ProductosDAO"%>
<%@page import="modelo.Ventas"%>
<%@page import="dao.VentasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="dao.UsuariosDAO"%>
<%@page import="modelo.Usuarios"%>
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
                <h3 class="text-center">Ventas efectuadas</h3>
                <hr>
                <div class="container text-left">

                    <a href="nuevaVenta.jsp" class="btn btn-success">Generar venta</a>

                </div>
                <br>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Id venta</th>
                            <th>Id producto</th>
                            <th>Nombre del producto</th>
                            <th>Cantidad vendida</th>
                            <th>Total de venta</th>
                        </tr>
                    </thead>
                    <%
                        VentasDAO dao = new VentasDAO();
                        List<Ventas> ventas = dao.listar();
                        Iterator<Ventas> iterar = ventas.iterator();
                        Ventas venta = null;
                        ProductosDAO pdao = new ProductosDAO();
                        List<Productos> productos = pdao.listar();
                        while (iterar.hasNext()) {
                            venta = iterar.next();
                            String nombre = productos.get(venta.getIdProducto()-1).getNombre();
                    %>
                    <tbody>
                        <tr>
                            <td><%=venta.getId()%></td>
                            <td><%=venta.getIdProducto()%></td>
                            <td><%=nombre%></td>
                            <td><%=venta.getCantidad()%></td>
                            <td>$<%=venta.getTotalVenta()%></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
