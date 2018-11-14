<%-- 
    Document   : error
    Created on : 14-11-2018, 13:30:58
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
