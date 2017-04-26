/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validarRegistro() {
    var nombre = document.getElementById("nombre").value;
    var apellido = document.getElementById("apellido").value;
    var nombre_usuario = document.getElementById("nombreUsuario").value;
    var correo = document.getElementById("correo").value;
    var contrasenia = document.getElementById("contrasenia").value;
    var expresion = /^([a-zA-Z0-9_.-])+@ciencias.unam.mx$/;

    if (nombre === "" || apellido === "" || nombre_usuario === ""
            || correo === "" || contrasenia === "") {
        alert("Debes completar todos los campos.");

    }else
    if (expresion.test(correo) === false) {
        alert("Debes introducir un correo de dominio @ciencias.unam.mx");

    }else
    if (contrasenia.length <= 3) {
        alert("La contraseña debe contener al menos 4 caracteres.");

    }


    document.getElementById("enviar").submit();
}


function validarInicio() {
    var nombre2 = document.getElementById("exampleInputEmail3").value;
    var contrasenia2 = document.getElementById("exampleInputPassword3").value;

    if (nombre2 === "" || contrasenia2 === "") {
        alert("Debes completar todos los campos.");
        return;
    }
    if (contrasenia2.length <= 3) {
        alert("La contraseña debe contener al menos 4 caracteres.");
        return;
    }

    document.getElementById("enviar2").submit();
}