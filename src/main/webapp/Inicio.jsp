<%-- 
    Document   : Inicio
    Created on : 23 jun 2026, 17:58:35
    Author     : Nerea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de entrenamientos</title>
    </head>
    <body>
        <!--Todo esto servira para poder consultar que error esta surgiendo en nuestra pagina-->
        <style>
            .error{
                color:red;
            }
        </style>
        <h1>Identificación:</h1>
        <%
            String error=request.getParameter("error");
            if(error!=null){
        %>
        <h2 class="error"><%= error%></h2>
        <%
            }
        %>
        
        <form action="ControladorXYZXYZ" method="get">
            Email:
            <input type="email" name="txtEmail" requiered>
            Perfil:
            <select name="sPerfil">
                <option value="usuario">Usuario/a</option>
                <option value="entrenador">Entrenador/a</option>
            </select>
            <input type="submit" value="ACEPTAR">
            <input type="reset" value="LIMPIAR">

        </form>
    </body>
</html>
