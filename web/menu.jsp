<%-- 
    Document   : menu
    Created on : 14-11-2018, 14:07:17
    Author     : Alumno
--%>

<%@page import="Model.UsuarioNormal"%>
<%@page import="Model.Administrador"%>
<%@page pageEncoding="iso-8859-1" contentType="text/html; charset=iso-8859-1" session="true"%>
<!DOCTYPE html>
<html>
    <head>
  
        <title>Menu admin</title>
    </head>
    <body>
        <%
            UsuarioNormal u = null;
            Administrador a = null;

            if ((request.getSession().getAttribute("usuario") == null) && (request.getSession().getAttribute("administrador") == null)) {
                request.getSession().setAttribute("error", "Debe iniciar sesión");
                response.sendRedirect("error.jsp");
            } else if (request.getSession().getAttribute("usuario") != null) {
                u = (UsuarioNormal) request.getSession().getAttribute("usuario");

            } else if (request.getSession().getAttribute("administrador") != null) {
                a = (Administrador) request.getSession().getAttribute("administrador");
            }
        %>


        <%
            Boolean esAdmin = false;
            Boolean SesionOk=false;

            if (a != null) {
                //es un admin
                esAdmin = true;
                SesionOk=true;
            } else if (u != null) {
                //es un usuario
                esAdmin = false;
                SesionOk=true;
            }else if((a!=null)&&(u!=null)){
                SesionOk=false;
            }
        %>

        <%if ((esAdmin == true)&&(SesionOk==true)) {%>
        <h1>Bienvenido <%=a.getNombre()%> </h1>
        <br>
        <a href="crearCasa.jsp">Crear casas</a>
        <br>
        <a href="listarCasas.jsp">Listar/Buscar casas</a>
        <br>
        <a href="crearUsuario.jsp">Crear usuarios</a>
        <br>
        <a href="listarUsuarios.jsp">List/Eliminar a un usuario</a>
        <br>
        <br>
        <a href="cerrarSesion.do">Cerrar Sesión</a>
        <%}%><%else if ((esAdmin == false)&&(SesionOk==true)) {%>
        <h1>Bienvenido <%=u.getNombre()%> </h1>
        <br>
        <a href="listarCasas.jsp">Listar/Buscar casas</a>
        <br>
        <a href="cerrarSesion.do">Cerrar Sesión</a>
        <% }%>


    </body>
</html>
