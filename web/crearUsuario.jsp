<%-- 
    Document   : crearUsuario
    Created on : 14-11-2018, 14:21:12
    Author     : Alumno
--%>

<%@page import="Model.Administrador"%>
<%@page pageEncoding="iso-8859-1" contentType="text/html; charset=iso-8859-1" session="true"%>
<!DOCTYPE html>
<html>
    <head>
       
        <title>Crear usuarios</title>
    </head>
    <body>
        <h1>Crear usuarios</h1>


        <%
            Administrador a = null;
            if (request.getSession().getAttribute("administrador") != null) {
                a = (Administrador) request.getSession().getAttribute("administrador");
            } else if (request.getSession().getAttribute("administrador") == null) {
                request.getSession().setAttribute("error", "Debe iniciar sesión");
                response.sendRedirect("error.jsp");
            }
        %>

        <form action="crearUsuario.do" method="post">
            <input type="text" name="rut"  placeholder="Rut:" required>
            <br>
            <input type="text" name="nombre"  placeholder="Nombre:" required>
            <br>
            <input type="password" name="contrasenia"  placeholder="Contraseña:" required>
            <br>
            <input type="radio" name="tipo" value="2">Administrador
            <br>
            <input type="radio" name="tipo" value="1" placeholder="Usuario Normal">Usuario Normal
            <br>
            <input type="submit" value="Crear Usuario">
        </form>

        <br>
        <a href="menu.jsp">Volver al menú</a>
    </body>
</html>
