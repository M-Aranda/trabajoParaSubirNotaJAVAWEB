<%-- 
    Document   : listarCasas
    Created on : 14-11-2018, 13:57:25
    Author     : Alumno
--%>

<%@page import="Model.Casa"%>
<%@page import="java.util.List"%>
<%@page import="Model.DAO.DAO_Casa"%>
<%@page import="Model.UsuarioNormal"%>
<%@page import="Model.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de casas</title>
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

        <h1>Listado de casas</h1>

        <%
            DAO_Casa dc = new DAO_Casa();
            List<Casa> casas = dc.read();
        %>


        <form action="buscarPorRol.do" method="POST">
            <input type="number" name="buscarPorRol" placeholder="N de rol">
            <input type="submit" value="Buscar por rol">
        </form>
        <br>
        <form action="buscarPorRut.do" method="POST">
            <input type="text" name="buscarPorRut" placeholder="Rut propietario">
            <input type="submit" value="Buscar por rut propietario">
        </form>
        <br>
        <form action="cargarTodasLasCasas.do" method="post">
            <input type="submit" value="Cargar todas las casas">
        </form>
        <br>
        <%
            if (request.getSession().getAttribute("casaProp") != null) {
                Casa ejDeCasa = (Casa) request.getSession().getAttribute("casaProp");
                
                List<Casa>unaListaDeCasas=(List<Casa>)request.getSession().getAttribute("listaDeCasas");
                int cantCasas=unaListaDeCasas.size();
              %>
              <h3>Casas de <%=ejDeCasa.getNomPropietario()%> [<%=ejDeCasa.getRutPropietario()%>] (<%=cantCasas%>)</h3> 
            <%}
        %>
        <br>
        <table border="1">
            <thead>
                <tr>
                    <th>N de rol</th>
                    <th>Dirección</th>
                    <th>Metros cuadrados</th>
                    <th>Propietario</th>
                    <th>Avaluo Fiscal</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (request.getSession().getAttribute("listaDeCasas") != null) {
                        casas = (List<Casa>) request.getSession().getAttribute("listaDeCasas");
                    }

                    for (Casa c : casas) {%>
                <tr>
                    <td><%=c.getId()%></td>
                    <td><%=c.getDireccion()%></td>
                    <td><%=c.getMetrosCuadrados()%></td>
                    <td><%=c.getNomPropietario()%></td>
                    <td>$ <%=c.getAvaluoFiscal()%></td>
                </tr>
                <%}
                %>

            </tbody>
        </table>





        <%
            if (request.getSession().getAttribute("listaDeCasas") != null) {
                request.getSession().removeAttribute("listaDeCasas");
            }

        %>

        
        if(){
        }
        <a href="menu.jsp">Volver</a>
        
    </body>
</html>
