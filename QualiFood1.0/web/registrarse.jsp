<%-- 
    Document   : index
    Created on : 15/04/2017, 12:52:25 PM
    Author     : alinka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Ejemplo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/validacion.js"></script>
    </head>
    <body>
        <form action="Registrar" method="POST">
            Nombre: <input type="text" name="nombre"/><br />
            Apellido: <input type="text" name="apellido"/><br />
            Nombre de usuario: <input type="text" name="nombreUsuario"/><br />
            Correo: <input type="text" name="correo"/><br />
            Contraseña: <input type="password" name="contrasenia"/><br />
            <input type="submit" value="Guardar"/><br />
        </form> 
        <form action="" method="POST">
            <input type="button" value="Consultar"/><br />
        </form>
    </body>
</html>
