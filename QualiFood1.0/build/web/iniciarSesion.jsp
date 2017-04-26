<%-- 
    Document   : iniciarSesion
    Created on : 16/04/2017, 11:18:32 PM
    Author     : alinka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesión</title>
        <script src="js/validacion.js"></script>
    </head>
    <body>
        <h1>IniciarSesión</h1>
        <form id="forminicio">
            Nombre: <input type="text" name="nombre" id="txtnombre"/><br/>
            Contraseña: <input type="password" name="contrasenia" id="txtcontrasenia"/><br/>
            <input type="button" value="Iniciar Sesión" id="btninicio"/><br/>
        </form>
    </body>
</html>
