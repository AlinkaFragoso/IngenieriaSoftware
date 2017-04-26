<%-- 
    Document   : maps
    Created on : 23/04/2017, 06:02:37 PM
    Author     : giss_
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="Controladores.ControladorMapa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Puesto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            #map {
                width: 100%;
                height: 400px;
                background-color: grey;
            }
        </style>
    </head>
    <body>
        <h3>My Google Maps Demo</h3>
        <div id="map"></div>
        <script>
            
            function initMap() {
                var ciencias = {lat: 19.323571, lng: -99.179615};
                var map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 18,
                    center: ciencias
                });

                var iconBase = 'https://maps.google.com/mapfiles/kml/shapes/';
                var icons = {
                    parking: {
                        icon: iconBase + 'parking_lot_maps.png'
                    },
                    library: {
                        icon: iconBase + 'library_maps.png'
                    },
                    info: {
                        icon: iconBase + 'info-i_maps.png'
                    }
                };

                function addMarker(feature) {
                    var marker = new google.maps.Marker({
                        position: feature.position,
                        icon: icons[feature.type].icon,
                        map: map,
                        title: nombre
                    });
                }

                var features = [
                    {
                        position: new google.maps.LatLng(19.323350, -99.180781),
                        type: 'info'
                    },
                    {
                        position: new google.maps.LatLng(19.323383, -99.180812),
                        type: 'info'
                    },
                    {
                        position: new google.maps.LatLng(19.323413, -99.180804),
                        type: 'info'
                    },
                    {
                        position: new google.maps.LatLng(19.323428, -99.180787),
                        type: 'info'
                    },
                    {
                        position: new google.maps.LatLng(19.323446, -99.180789),
                        type: 'info'
                    },
                    {
                        position: new google.maps.LatLng(19.323461, -99.180773),
                        type: 'info'
                    },
                    {
                        position: new google.maps.LatLng(19.323473, -99.180765),
                        type: 'info'
                    },
                    {
                        position: new google.maps.LatLng(19.323484, -99.180741),
                        type: 'info'
                    },
                    {
                        position: new google.maps.LatLng(19.323721, -99.180330),
                        type: 'info'
                    },
                    {
                        position: new google.maps.LatLng(19.323744, -99.180137),
                        type: 'info'
                    },
                    {
                        position: new google.maps.LatLng(19.324319, -99.179225),
                        type: 'info'
                    },
                    {
                        position: new google.maps.LatLng(19.324323, -99.179206),
                        type: 'info'
                    },
                    {
                        position: new google.maps.LatLng(19.324320, -99.179163),
                        type: 'info'
                    },
                    {
                        position: new google.maps.LatLng(19.324324, -99.179142),
                        type: 'info'
                    },
                    {
                        position: new google.maps.LatLng(19.324327, -99.179122),
                        type: 'info'
                    },
                    {
                        position: new google.maps.LatLng(19.324371, -99.179160),
                        type: 'info'
                    },
                    {
                        position: new google.maps.LatLng(19.324408, -99.179168),
                        type: 'info'
                    },
                    {
                        position: new google.maps.LatLng(19.324404, -99.179198),
                        type: 'info'
                    },
                    {
                        position: new google.maps.LatLng(19.324523, -99.179384),
                        type: 'info'
                    },
                    {
                        position: new google.maps.LatLng(19.324947, -99.182157),
                        type: 'library'
                    },
                    {
                        position: new google.maps.LatLng(19.324865, -99.180121),
                        type: 'parking'
                    },
                    {
                        position: new google.maps.LatLng(-33.91662347903106, 151.22879464019775),
                        type: 'parking'
                    }, 
                    {
                        position: new google.maps.LatLng(-33.91727341958453, 151.23348314155578),
                        type: 'library'
                    }
                ];

                for (var i = 0, feature; feature = features[i]; i++) {
                    addMarker(feature);
                }
                
                var map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 18,
                    center: {lat: 19.323350, lng: -99.180781}
                });

                var marker = new google.maps.Marker({
                    position: {lat: 19.323332, lng: -99.180766},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });
                var marker = new google.maps.Marker({
                    position: {lat: 19.323350, lng: -99.180781},
                    map: map,
                    title: "Ballena 2"
                });

            }
        </script>
        <table border="1">
            <tr>
                <td>id</td>
                <td>puesto</td>
                <td>Numero</td>
                <td>Descripcion</td>
                <td>latitud</td>
                <td>longitud</td>

            </tr>
            <%
                ControladorMapa map = new ControladorMapa();
                LinkedList<Puesto> lista = map.listaPuestos();
                lista = map.listaPuestos();
                for (int i = 0; i < lista.size(); i++) {
                    out.println("<tr>");
                    out.println("<td>" + lista.get(i).getIdPuesto() + "</td>");
                    out.println("<td>" + lista.get(i).getNombre() + "</td>");
                    out.println("<td>" + lista.get(i).getNumero() + "</td>");
                    out.println("<td>" + lista.get(i).getDescripcion() + "</td>");
                    out.println("<td>" + lista.get(i).getLatitud() + "</td>");
                    out.println("<td>" + lista.get(i).getLongitud() + "</td>");
                    out.println("</tr>");
                }
            %> 

        </table>


        <script async defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCsYXy76BgQSlT7MFSMqtPKkMy9Za2cz3Q&callback=initMap" type="text/javascript">
        </script>

    </body>
</html>