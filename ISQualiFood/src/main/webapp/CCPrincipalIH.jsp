<%-- 
    Document   : PrincipalIH
    Created on : 14/04/2017, 09:24:50 PM
    Author     : giss_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
author: diana_hidalgo
-->
<%
//    HttpSession objsesion = request.getSession(false);
//    String nombre_usuario = (String) objsesion.getAttribute("nombre");
//    if (nombre_usuario.equals("")) {
//        response.sendRedirect("PrincipalIH.jsp");
//    }
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Quali-Food</title>
        <!-- for-mobile-apps -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- //for-mobile-apps -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" property="" />
        <!-- js -->
        <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
        <!-- //js -->
        <!-- font-awesome icons -->
        <link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all" /> 
        <!-- //font-awesome icons -->
        <link href="//fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
        <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
        <!-- start-smoth-scrolling -->
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script>
        <style>
            #map {

                height: 40em;
                width:  60%;
            }
        </style>

    </head>

    <body>
        <!-- banner -->
        <div class="banner">
            <div class="container">
                <div class="agile-header">
                    <div class="agileits-contact-info text-right">
                        <ul>
                            <li><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span><a href="mailto:info@example.com">qualifood@vatunisaa.com</a></li>
                            <li><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>01 55 55 55 55 55</li>
                        </ul>
                    </div>
                    <div class="w3_agileits_social_media">
                        <ul>
                            <li class="agileinfo_share">Compartir en</li>
                            <li><a href="#" class="wthree_facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                            <li><a href="#" class="wthree_twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>


                        </ul>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <nav class="navbar navbar-default">
                    <div class="navbar-header navbar-left">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Menú</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <h1><a class="navbar-brand"></a></h1>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    
                    <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
                        <nav class="menu menu--iris">
                            <ul class="nav navbar-nav menu__list">
                                <form action="Control" method="POST">
                                    <li class="menu__item"><a href="IndexIH.jsp" class="menu__link">CERRAR SESIÓN</a></li>
                                </form>
                            </ul>
                        </nav>
                    </div>
                    
                    <div class="collapse navbar-collapse navbar-left" id="bs-example-navbar-collapse-1">
                        <nav class="menu menu--iris">
                            <ul class="nav navbar-nav menu__list">
                                <li class="menu__item menu__item--current"><a href="IndexIH.jsp" class="menu__link">Inicio</a></li>                                
                            </ul>
                        </nav>
                    </div>
                    
<!--                    <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
                        <nav class="menu menu--iris">
                            <ul class="nav navbar-nav menu__list">
                                <li class="menu__item menu__item--current"><a href="IndexIH.jsp" class="menu__link">Inicio</a></li>
                                <li class="menu__item"><a href="RegistroUsuarioIH.jsp" class="menu__link">Regístrate</a></li>
                                <li class="dropdown menu__item">
                                    <a href="#" class="dropdown-toggle menu__link" data-toggle="dropdown">Inicia sesión <b class="caret"></b></a>
                                    <ul class="dropdown-menu agile_short_dropdown" action="ControlSesion" method="POST">
                                        <form action="ControlSesion" method="POST">
                                            <li><div class="form-group">
                                                    <label class="sr-only"  for="exampleInputEmail3">Nombre de usuario</label>
                                                    <label class="control-label col-sm-3" for="email">Nombre de Usuario:</label>
                                                    <div class="col-sm-4">
                                                        <input type="text" name="nombre" class="form-control" id="exampleInputEmail3" placeholder="Nombre de usuario.."/>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li><div class="form-group">
                                                    <label class="sr-only" for="exampleInputPassword3">Contraseña</label>
                                                    <label class="control-label col-sm-4" for="email">Contraseña:</label>
                                                    <div class="col-sm-6">
                                                        <input type="password" name="contrasenia" class="form-control" id="exampleInputPassword3" placeholder="contraseña"/>
                                                    </div>
                                                </div>
                                            </li>
                                            <li><a><input type="submit" value="Iniciar sesión"></a></li>
                                        </form>
                                        </ul>
                                </li>
                            </ul>
                        </nav>
                    </div>-->

                    <!-- //banner -->

                    <div class="welcome">
                        <div class="row">

                            <div >
                                <img align="left" height="20%" src="images/escudociencias.png" title="Logo Ciencias" width="20%">

                                <img alt="" height="20%" src="images/logo.png" title="Logo Vatuni" width="20%">

                                <img align="right" alt="" height="20%" src="images/escudounam.png" title="Logo UNAM" width="20%">
                            </div>

                        </div>

                        <div class="container">
                            <h1 class="w3ls_head">Bienvenido a Quali-Food</h1>
                            <div align="right"></div>
                            <div id="map"> <!--cambie el estilo que tenia por uno definido aqui (hasta arriba, tambien se llama map)-->
                                <script>
                                    function initMap() {
                                        var map = new google.maps.Map(document.getElementById('map'), {
                                            zoom: 18,
                                            center: {lat: 19.323350, lng: -99.180781}
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.323332, lng: -99.180766},
                                            map: map,
                                            title: "Ensaladas Y Baguettes"
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.323350, lng: -99.180781},
                                            map: map,
                                            title: "Ballena 2"
                                        });

                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.323383, lng: -99.180812},
                                            map: map,
                                            title: "Pizzas & Más"
                                        });

                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.323413, lng: -99.180804},
                                            map: map,
                                            title: "Quesadillas & Tacos"
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.323428, lng: -99.180787},
                                            map: map,
                                            title: "Ballena 5"
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.323446, lng: -99.180789},
                                            map: map,
                                            title: "Ballena 6"
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.323461, lng: -99.180773},
                                            map: map,
                                            title: "Ballena 7"
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.323473, lng: -99.180765},
                                            map: map,
                                            title: "Ballena 8"
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.323484, lng: -99.180741},
                                            map: map,
                                            title: "Taquitos de guisado"
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.323721, lng: -99.180330},
                                            map: map,
                                            title: "Estacionamiento 1"
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.323744, lng: -99.180137},
                                            map: map,
                                            title: "Estacionamiento 2"
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.324319, lng: -99.179225},
                                            map: map,
                                            title: "Tienda 1"
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.324323, lng: -99.179206},
                                            map: map,
                                            title: "Tía Ali"
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.324320, lng: -99.179163},
                                            map: map,
                                            title: "Helados"
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.324324, lng: -99.179142},
                                            map: map,
                                            title: "Ensaladas"
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.324327, lng: -99.179122},
                                            map: map,
                                            title: "Tienda 2"
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.324371, lng: -99.179160},
                                            map: map,
                                            title: "Harry"
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.324408, lng: -99.179168},
                                            map: map,
                                            title: "Sushi"
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.324404, lng: -99.179198},
                                            map: map,
                                            title: "Quesadillas"
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.324523, lng: -99.179384},
                                            map: map,
                                            title: "Cafetería Ciencias"
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.324947, lng: -99.182157},
                                            map: map,
                                            title: "Cafesín"
                                        });
                                        var marker = new google.maps.Marker({
                                            position: {lat: 19.324865, lng: -99.180121},
                                            map: map,
                                            title: "Café Zapatista"
                                        });

                                    }

                                </script>
                                <script async defer
                                        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCzxaJibRabLf-8ANmQDLtc_07yolIvKWY&amp;callback=initMap">
                                </script>
                                <div align="right">holasnjiwjn</div>
                            </div>	

                        </div>
                    </div>
                    <!-- //welcome -->
                </nav>
            </div>
        </div>


        <div class="footer">
            <div class="container">
                <nav class="navbar navbar-default">
                    <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
                        <nav class="menu menu--iris">
                            <ul class="nav navbar-nav menu__list">
                                <li class="menu__item"><a href="AcercaDeIH.jsp" class="menu__link">¿Quienes somos?</a></li>
                                <li class="menu__item"><a href="MetaIH.jsp" class="menu__link">Nuestra meta</a></li>
                                <li class="menu__item"><a href="PreguntasIH.jsp" class="menu__link">Preguntas frecuentes</a></li>
                                <li class="menu__item"><a href="ContactoIH.jsp" class="menu__link">Contáctanos</a></li>


                            </ul>
                        </nav>

                    </div>
                </nav>
                <div class="footer-w3-agile">

                    <div class="col-md-6 w3ls-social-icons">
                        <h3>Síguenos</h3>
                        <a class="facebook" href="#"><i class="fa fa-facebook"></i></a>
                        <a class="twitter" href="#"><i class="fa fa-twitter"></i></a>
                        <a class="pinterest" href="#"><i class="fa fa-pinterest"></i></a>
                        <a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="copy-right-agile">
                    <p>© 2017 Todos los derechos reservados | Sitio web administrado y diseñado por Vatuni Saa Software</p>
                </div>
            </div>
        </div>
        <!-- for bootstrap working -->
        <script src="js/bootstrap.js"></script>
        <!-- //for bootstrap working -->
        <!-- here stars scrolling icon -->
        <script type="text/javascript">
                                    $(document).ready(function () {
                                        /*
                                         var defaults = {
                                         containerID: 'toTop', // fading element id
                                         containerHoverID: 'toTopHover', // fading element hover id
                                         scrollSpeed: 1200,
                                         easingType: 'linear' 
                                         };
                                         */

                                        $().UItoTop({easingType: 'easeOutQuart'});

                                    });
        </script>
        <!-- //here ends scrolling icon -->
    </body>
</html>