<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Posh | Sobre nuestros autores y sus libros</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
<body background="imagenes/seguridad.jpg">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <br>
                    <div class="col-12 text-center" >
                        <ul>
                            <li><b><a href="https://www.barnesandnoble.com/">Tienda en linea</a></b></li>
                            <li><b><a href="https://www.barnesandnoble.com/h/help/about/barnesandnoble">Nosotros</a></b></li>
                            <li><b><a href="Advertencia.jsp">Seguir como usuario</a></b></li>
                        </ul>
                        <br>
                        <div class="row">
                            <div class="col-12 text-center">
                            <h4><b>Autores y sus libros</b></h4><br/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 text-center" >
                            <a class="btn btn-primary btn-block" href="diagrama?action=Ids">Agregar</a></td>
                            <table class="table table-striped" width="100%" border="2" cellspacing="1">
                                <thead>
                                    <tr>
                                        <th>ID Global</th>
                                        <th>ID Autor</th>
                                        <th>ID libro</th>
                                    </tr>
                                </thead>
                                <c:forEach items="${lista}" var="ver">
                                    <tr>
                                        <td>${ver.id_autor_libro}</td>
                                        <td>${ver.id_autor}</td>
                                        <td>${ver.id_libro}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </table>
                            <br>
                            <table>
                                <td1><a class="btn btn-info" href="PrincipalAdministracion.jsp">  Atras  </a></td1>
                                <td1> <---|---></td1>
                                <td1><a class="btn btn-primary" href="Index.jsp">    Salir   </a></td1>
                            </table>
                            <h3 style="color:#32CD32">${msg}</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>