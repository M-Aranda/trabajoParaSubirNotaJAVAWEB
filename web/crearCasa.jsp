<%-- 
    Document   : crearCasa
    Created on : 14-11-2018, 15:36:36
    Author     : Alumno
--%>

<%@page import="Model.Administrador"%>
<%@page import="Model.UsuarioNormal"%>
<%@page pageEncoding="iso-8859-1" contentType="text/html; charset=iso-8859-1" session="true"%>

<!DOCTYPE html>
<html>
    <head>


        <title>Crear casa</title>
    </head>
    <body>
        <%
            UsuarioNormal u = null;
            Administrador a = null;
            
            if ((request.getSession().getAttribute("usuario") == null) && (request.getSession().getAttribute("administrador") == null)) {
                request.getSession().setAttribute("error", "Debe iniciar sesi�n");
                response.sendRedirect("error.jsp");
            } else if (request.getSession().getAttribute("usuario") != null) {
                u = (UsuarioNormal) request.getSession().getAttribute("usuario");

            } else if (request.getSession().getAttribute("administrador") != null) {
                a = (Administrador) request.getSession().getAttribute("administrador");
            }
        %>
        
        
        <h1>Crear casas</h1>
        <br>
        <form action="crearCasa.do" method="POST">
            <input type="text" name="rol" placeholder="Rol" required>
            <br>
            <input type="text" name="direccion" placeholder="Direcci�n" required>
            <br>
            <input type="number" name="metrosCuadrados" placeholder="Metros cuadrados" required>
            <br>
            <input type="number" name="avaluoFiscal" placeholder="Avaluo fiscal" required>
            <br>
            <br>
            <h3>Datos Propietario</h3>
            <br>
            <br>
            <input type="text" name="rutPropietario" placeholder="Rut propietario" required>
            <br>
            <input type="text" name="nombrePropietario" placeholder="Nombre propietario" required>
            <br>
            <input type="submit" value="Crear casa">
        </form>
        <br>
        <a href="menu.jsp">Volver</a>
    </body>
</html>
