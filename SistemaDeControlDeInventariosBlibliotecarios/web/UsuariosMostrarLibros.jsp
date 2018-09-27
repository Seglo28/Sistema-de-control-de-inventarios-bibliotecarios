<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Posh | Libros</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body background="imagenes/libro4.jpg">
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <br/>
                    <div class="row">
                        <div class="col-12 text-center" >
                            <ul>
                                <li><b><a href="https://www.barnesandnoble.com/">Tienda en linea</a></b></li>
                                <li><b><a href="https://www.barnesandnoble.com/h/help/about/barnesandnoble">Nosotros</a></b></li>
                                <li><b><a href="IngresoAdministrador_1.jsp">Ingreso de administración</a></b></li>
                            </ul>
                            <br>
                            <div class="row">
                                <div class="col-12 text-center">
                                    <br/>
                                    <h4><b>Literatura general</b></h4><br/>
                                </div>
                            </div>
                            <table class="table table-striped tabla" width="100%" border="2" cellspacing="1">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nombre</th>
                                        <th>Fecha de publicacion</th>
                                        <th>Tomo</th>
                                        <th>Edicion</th>
                                        <th>Paginas</th>
                                        <th>Genero</th>                                
                                    </tr>
                                </thead>
                                <c:forEach items="${lista}" var="ver">
                                    <tr>
                                        <td>${ver.id_libro}</td>
                                        <td>${ver.nombre}</td>
                                        <td>${ver.fecha_de_publicacion}</td>
                                        <td>${ver.tomo}</td>
                                        <td>${ver.edicion}</td>
                                        <td>${ver.paginas}</td>
                                        <td>${ver.genero}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <br/>
                            <table>
                                <td1><a class="btn btn-info" href="PrincipalUsuarios.jsp">  Atras  </a></td1>
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
