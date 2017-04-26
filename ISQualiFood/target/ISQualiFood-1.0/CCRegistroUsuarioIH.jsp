<%-- 
    Document   : RegistroUsuarioIH
    Created on : 14/04/2017, 09:36:45 PM
    Author     : giss_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<?xml version="1.0" encoding="UTF-8"?>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:p="http://primefaces.org/ui"
      xmlns:h="http://xmlns.jcp.org/jsf/html">

    <head>
        <h:outputStylesheet name="./css/default.css"/>
        <h:outputStylesheet name="./css/cssLayout.css"/>
        <h:outputStylesheet name="./css/bootstrap.css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

        <title>Regístro de Usuario</title>
        <!-- for-mobile-apps -->
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Quali Food"/>
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
        <link href="//fonts.googleapis.com/css?family=Oswald" rel="stylesheet"/>
        <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'/>
        <!-- start-smoth-scrolling -->
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <script src="js/validacion.js"></script>

        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script>


    </head>

    <body>
        <!-- start banner -->
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

                    <div id="wrapper">
                        <div class="container">
                            <!--            Campos para llenado de Registro-->
                            <space>
                                <div class="contact-right-w3-agile">
                                    <form action="Registrar" method="POST" id="enviar" class="form-horizontal">
                                        <div>
                                            <center><a>Nombre:</a></center>
                                            <center>
                                                <input type="text" name="nombre" placeholder="Nombre..." required="" id="nombre"/>
                                            </center>
                                        </div>
                                        <div>
                                            <center><a>Apellido:</a></center>
                                            <center>
                                                <input type="text" name="apellido" placeholder="Apellido..." required="" id="apellido"/>
                                            </center>
                                        </div>
                                        <div>
                                            <center><a>Nombre de usuario:</a></center>
                                            <center>
                                                <input type="text" name="usuario" placeholder="Nombre de usuario..." required="" id="nombreUsuario"/>
                                            </center>
                                        </div>
                                        <div>
                                            <center><a>Correo de ciencias:</a></center>
                                            <center>
                                                <input type="text" name="correo" placeholder="Correo ''...@ciencias.unam.mx''" required="" id="correo"/>
                                            </center>
                                        </div>
                                        <div>
                                            <center><a>Contraseña:</a></center>
                                            <center>
                                                <input type="text" name="contrasenia" placeholder="Contraseña..." required="" id="contrasenia"/>
                                            </center>
                                        </div>
                                        <div>
                                            <center><a>Confirmación de contraseña:</a></center>
                                            <center>
                                                <input type="text" name="confirmacion" placeholder="Contraseña..." required=""/>
                                            </center>
                                        </div>
                                        <center>
                                            <input type="submit" value="Enviar" onclick="validarRegistro()"/>
                                        </center>
                                    </form>
                                </div>
                            </space>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- End banner-->
        <!--begin footer-->
        <div class="footer">
            <div class="container">
                <nav class="navbar navbar-default">
                    <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
                        <nav class="menu menu--iris">
                            <ul class="nav navbar-nav menu__list">
                                <li class="menu__item"><a href="CCAcercaDeIH.jsp" class="menu__link">¿Quienes somos?</a></li>
                                <li class="menu__item"><a href="CCMetaIH.jsp" class="menu__link">Nuestra meta</a></li>
                                <li class="menu__item"><a href="CCPreguntasIH.jsp" class="menu__link">Preguntas frecuentes</a></li>
                                <li class="menu__item"><a href="CCContactoIH.jsp" class="menu__link">Contáctanos</a></li>
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
        <!-- //here ends scrolling icon -->
    </body>
    <h:outputScript name="./js/bootstrap.js"/>
    <h:outputScript name="./js/jquery-3.2.0.min.js"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</html>