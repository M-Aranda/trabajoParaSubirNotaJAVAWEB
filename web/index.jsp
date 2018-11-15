<%-- 
    Document   : index
    Created on : 14-11-2018, 11:52:34
    Author     : Alumno
--%>

<%@page pageEncoding="iso-8859-1" contentType="text/html; charset=iso-8859-1" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
        <title>Inicio de sesion</title>
    </head>
    <body>
        <h2>Inicio de sesión</h2>
        <br>
        <form action="iniciarSesion.do" method="post">
            <input type="text" name="nombre" placeholder="Rut:" required>
            <br>
            <input type="passsword" name="contrasenia" placeholder="Contraseña" required>
            <br>
            <input type="submit" value="Iniciar Sesión">  
        </form>
 
    </body>
</html>
