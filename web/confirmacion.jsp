<%-- 
    Document   : confirmacion
    Created on : 14-11-2018, 15:07:06
    Author     : Alumno
--%>

<%@page import="Model.Administrador"%>
<%@page import="Model.UsuarioNormal"%>
<%@page import="Model.DAO.DAO_UsuarioNormal"%>
<%@page import="Model.DAO.DAO_Rol"%>
<%@page import="Model.DAO.DAO_Administrador"%>
<%@page pageEncoding="iso-8859-1" contentType="text/html; charset=iso-8859-1" session="true"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Confirmacion</title>
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
            int id=0;
            int tipo=0;
            if((request.getSession().getAttribute("idUsuarioABorrar")!=null)&&(request.getSession().getAttribute("tipoDeUsuarioABorrar")!=null)){
              id = Integer.parseInt( (String)request.getSession().getAttribute("idUsuarioABorrar"));
              tipo = Integer.parseInt((String)request.getSession().getAttribute("tipoDeUsuarioABorrar")) ;
            }
            
            
            String nombre = "";
            String rut = "";

            DAO_Administrador da = new DAO_Administrador();
            DAO_UsuarioNormal du = new DAO_UsuarioNormal();
            DAO_Rol dr = new DAO_Rol();

            if (tipo == 1) {
                //es usuarioNormal
                UsuarioNormal usu = du.findById(id);
                nombre = usu.getNombre();
                rut = usu.getRut();
            } else if (tipo == 2) {
                //es admin
                Administrador admin = da.findById(id);
                nombre = admin.getNombre();
                rut = admin.getRut();

            }

        %>

        <h3>¿Realmente desea eliminar a <%=nombre%> rut <%=rut%>?</h3>
        <a href="eliminarUsuario.do">Si</a>
        <a href="listarUsuarios.jsp">No</a>

    </body>
</html>
