<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Posh | Autores</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body background="imagenes/libro3.jpg">
        <div class="container">
            <div class="container">
                <div class="row">              
                    <div class="col-md-12">
                        <div class="row">
                            <div class="col-12 text-center" >
                                <br/>  
                                <ul>
                                    <li><b><a href="https://www.barnesandnoble.com/">Tienda en linea</a></b></li>
                                    <li><b><a href="https://www.barnesandnoble.com/h/help/about/barnesandnoble">Nosotros</a></b></li>
                                    <li><b><a href="Advertencia.jsp">Seguir como usuario</a></b></li>
                                </ul>
                                <br>
                                <br/>
                                <h4><b>Autores en general</b></h4>
                                <br/>
                                <div class="row">
                                    <div class="col-12 text-center">
                                        <a class="btn btn-primary btn-block" href="AgregarAutor.jsp">Agregar</a></td>
                                        <table class="table table-striped" width="100%" border="2" cellspacing="1">
                                            <thead>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Nombre</th>
                                                    <th>Nacionalidad</th>
                                                    <th>Fecha de nacimiento</th>
                                                    <th>Modificar</th>
                                                    <th>Eliminar</th>
                                                </tr>
                                            </thead>
                                            <c:forEach items="${lista}" var="ver">
                                                <tr>
                                                    <td>${ver.id_autor}</td>
                                                    <td>${ver.nombre}</td>
                                                    <td>${ver.nacionalidad}</td>
                                                    <td>${ver.fecha_de_nacimiento}</td>
                                                    <td><a class="btn btn-info btn-block" href="ac?action=MostrarUno&id_autor=${ver.id_autor}">Modificar</a></td>
                                                    <td><a class="btn btn-danger" href="ac?action=Borrar&id_autor=${ver.id_autor}">Eliminar</a></td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    <h3 style="color:#32CD32">${msg}</h3>
                                        <br>
                                        <table>
                                            <td1><a class="btn btn-info" href="PrincipalAdministracion.jsp">  Atras  </a></td1>
                                            <td1> <---|---></td1>
                                            <td1><a class="btn btn-primary" href="Index.jsp">    Salir   </a></td1>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </body>
                    </html>