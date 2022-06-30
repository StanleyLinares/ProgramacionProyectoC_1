<%-- 
    Document   : sesiones
    Created on : 29 jun. 2022, 23:44:59
    Author     : moise
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="dao.LogUsrDAO"%>
<%@page import="modelo.LogUsr"%>
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
                <h3 class="text-center">Sesiones iniciadas</h3>
                <hr>
                <div class="container text-left">

                </div>
                <br>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Id Usuario</th>
                            <th>Login</th>
                            <th>LogOut</th>
                        </tr>
                    </thead>
                    <%
                        LogUsrDAO dao = new LogUsrDAO();
                        List<LogUsr> logUsrs = dao.listar();
                        Iterator<LogUsr> iterar = logUsrs.iterator();
                        LogUsr logUsr = null;
                        while (iterar.hasNext()) {
                            logUsr = iterar.next();
                    %>
                    <tbody>
                        <tr>
                            <td><%=logUsr.getId()%></td>
                            <td><%=logUsr.getIdUsr()%></td>
                            <td><%=logUsr.getHoraLogin()%></td>
                            <td><%=logUsr.getHoraLogout()%></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
