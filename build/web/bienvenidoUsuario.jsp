<%-- 
    Document   : bienvenidoUsuario
    Created on : 14-11-2018, 13:46:36
    Author     : Alumno
--%>

<%@page import="Model.UsuarioNormal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de inicio usuario</title>
    </head>
    <body>
        <%
            UsuarioNormal u=null;
            if(request.getSession().getAttribute("usuario")!=null){
            u=(UsuarioNormal)request.getSession().getAttribute("usuario");
            
        }else if(request.getSession().getAttribute("usuario")==null){
            request.getSession().setAttribute("error", "Debe iniciar sesión");
            response.sendRedirect("error.jsp");
        }
        
       
        %>
        
        <h1>Bienvenido  <%=u.getNombre()%></h1>
        <br>
        <a href="listarCasas.jsp">Listar/Buscar casas</a>
        <br>
        <a href="cerrarSesion.do">Cerrar Sesión</a>
    </body>
</html>
