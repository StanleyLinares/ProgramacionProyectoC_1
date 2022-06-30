<%@page import="dao.LogUsrDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <%
        String rpta = "";
        if(request.getParameter("rpta")!=null){
            int value = Integer.parseInt(request.getParameter("rpta"));
            if(value==0){
                rpta="Error en los datos introducidos";
            } else if (value == 1){
                rpta="Aún no se te ha asignado un rol";
            }
        }
    %>
    
    <%
        if(request.getParameter("out")!=null){
            int value = Integer.parseInt(request.getParameter("out"));
            if(value==1){
                LogUsrDAO dao = new LogUsrDAO();
                dao.horaLogout();
            }
        }
    %>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <center>
            <div class="contenedor" style="margin-top: 150px">
                <form method="post" action="Login">
                <div class="card" style="width: 30rem;">
                <div class="card-body">
                    <h2>Inicio de Sesión</h2>
                    <input type="text" name="txtusr" class="form-control mt-2" placeholder="Ingrese usuario">
                    <input type="password" name="txtpass" class="form-control mt-2" placeholder="Ingrese su contraseña">
                    <p style="color: red"><%=rpta%></p>
                    <input type="submit" name="btn-login" class="btn btn-primary btn-block mt-2">
                </div>
                </div>
                </form>
            </div>
        </center>
    </body>
</html>
