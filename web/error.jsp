<%-- 
    Document   : error
    Created on : 14-11-2018, 13:30:58
    Author     : Alumno
--%>

<%@page pageEncoding="iso-8859-1" contentType="text/html; charset=iso-8859-1" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Error</title>
    </head>
    <body>
        <h1>Error!</h1>
        <br>
        <br>
        <%if(request.getSession().getAttribute("error")!=null){
         %>
         <h3><%=request.getSession().getAttribute("error")%></h3>
       <% }

       request.getSession().removeAttribute("error");
        %>
        <a href="index.jsp">Volver</a>
    </body>
</html>
