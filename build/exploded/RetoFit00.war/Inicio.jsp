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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Identificación:</h1>
        <!--Todo esto servira para poder consultar que error esta surgiendo en nuestra pagina-->
        <%
            String error=(String) request.getAttribute("error");
            if (error!=null){
        %>
        <h2 class="error"><%=error %></h2>
        <%}%>
        <form action="/ControladorXYZXYZ" method="post">
            Email:
            <input type="text" name="email" value="u@u.com">
            Perfil:
            <select name="perfil">
                <option value="usuario">Usuario/a</option>
                <option value="entrenador">Entrenador/a</option>
            </select>
            <input type="submit" value="ACEPTAR">
            <input type="reset" value="LIMPIAR">

        </form>
    </body>
</html>
