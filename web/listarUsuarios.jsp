<%-- 
    Document   : listarUsuarios
    Created on : 14-11-2018, 14:43:45
    Author     : Alumno
--%>

<%@page import="Model.UsuarioNormal"%>
<%@page import="java.util.List"%>
<%@page import="Model.DAO.DAO_Administrador"%>
<%@page import="Model.DAO.DAO_UsuarioNormal"%>
<%@page import="Model.Administrador"%>
<%@page pageEncoding="iso-8859-1" contentType="text/html; charset=iso-8859-1" session="true"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Listado de usuarios</title>
    </head>
    <body>
        <%
            UsuarioNormal usu = null;
            Administrador a = null;

            if ((request.getSession().getAttribute("usuario") == null) && (request.getSession().getAttribute("administrador") == null)) {
                request.getSession().setAttribute("error", "Debe iniciar sesi�n");
                response.sendRedirect("error.jsp");
            } else if (request.getSession().getAttribute("usuario") != null) {
                usu = (UsuarioNormal) request.getSession().getAttribute("usuario");

            } else if (request.getSession().getAttribute("administrador") != null) {
                a = (Administrador) request.getSession().getAttribute("administrador");
            }
        %>



        <%
            if ((request.getSession().getAttribute("idUsuarioABorrar") != null) && (request.getSession().getAttribute("tipoDeUsuarioABorrar") != null)) {
                request.getSession().removeAttribute("idUsuarioABorrar");
                request.getSession().removeAttribute("tipoDeUsuarioABorrar");
            }
        %>


        <h1>Listado de usuarios</h1>
        <br>

        <%
            DAO_UsuarioNormal du = new DAO_UsuarioNormal();
            DAO_Administrador da = new DAO_Administrador();

            List<UsuarioNormal> usuariosNormales = du.read();
            List<Administrador> usuariosAdministradores = da.read();

            int idAdministradorActual=0;
            if(a!=null){
                idAdministradorActual = a.getId();
            }
            

            for (int i = 0; i < usuariosAdministradores.size(); i++) {
                Administrador adminDelCiclo = usuariosAdministradores.get(i);
                if (adminDelCiclo.getId() == idAdministradorActual) {
                    usuariosAdministradores.remove(i);
                }
            }

        %>

        <table border="1">
            <thead>
                <tr>
                    <th>Rut</th>
                    <th>Nombre</th>
                    <th>Rol</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <%for (Administrador admin : usuariosAdministradores) {%>
                <tr>
                    <td><%=admin.getRut()%></td>
                    <td><%=admin.getNombre()%></td>
                    <td><%=admin.getRol().getTipo()%></td>
                    <td>
                        <form action="prepararEliminacion.do" method="POST">
                            <input type="hidden" name="idAEliminar" value=<%=admin.getId()%>>
                            <input type="hidden" name="tipo" value=<%=admin.getRol().getId()%>>
                            <input type="submit" value="Eliminar">
                        </form>
                    </td>
                </tr>
                <%}
                %>

                <%for (UsuarioNormal u : usuariosNormales) {%>
                <tr>
                    <td><%=u.getRut()%></td>
                    <td><%=u.getNombre()%></td>
                    <td><%=u.getRol().getTipo()%></td>
                    <td>
                        <form action="prepararEliminacion.do" method="POST">
                            <input type="hidden" name="idAEliminar" value=<%=u.getId()%>>
                            <input type="hidden" name="tipo" value=<%=u.getRol().getId()%>>
                            <input type="submit" value="Eliminar">
                        </form>
                    </td>
                </tr>
                <%}
                %>


            </tbody>
        </table>



        <br>
        <a href="menu.jsp">Volver</a>


    </body>
</html>
