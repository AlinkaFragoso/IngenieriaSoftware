/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.addEventListener('load', function(){
    document.getElementById('btninicio').addEventListener('click', function (){
        var nombre = document.getElementById('txtnombre').value;
        var contrasenia = document.getElementById('txtcontrasenia').value;
        
        var bandera = false;
        
        if(nombre.length > 0 && contrasenia.length > 0){
            bandera = true;
        }
        
        if(bandera){
            document.getElementById('forminicio').submit();
        }else{
            alert('Por favor llene todos los campos'); 
            
        }
    });
    
});


window.onload = function(){
            if(document.getElementById('btncerrar').value == 'Cerrar Sesión'){
                document.getElementById('btncerrar').style.display = 'none';
            }
}

//function mostrarOcultar(id){
//    var elemento = document.getElementById(id);
//    
//    if(!elemento) {
//        return true;
//    }
//    if (elemento.style.display == "none") {
//        elemento.style.display = "block"
//    } else {
//        elemento.style.display = "none"
//    };
//    return true;
//};


/**function validarEmail() {
    var servidor = ciencias.unam.mx("@")[1];
  if (/^\w+([\.-]?\w+)$/.test(servidor)){
   alert("La dirección de email " + servidor + " es correcta.");
  } else {
   alert("La dirección de email es incorrecta.");
  }
}*/

function validarEmail(valor) {
  if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3,4})+$/.test(valor)){
   alert("La dirección de email " + valor + " es correcta.");
  } else {
   alert("La dirección de email es incorrecta.");
  }
}
 