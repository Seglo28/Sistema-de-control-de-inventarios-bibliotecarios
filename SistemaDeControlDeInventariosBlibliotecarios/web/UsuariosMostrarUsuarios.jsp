<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Posh | Usuarios</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body background="imagenes/libro4.jpg">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <br>
                    <div class="col-12 text-center" >
                        <ul>
                            <li><b><a href="https://www.barnesandnoble.com/">Tienda en linea</a></b></li>
                            <li><b><a href="https://www.barnesandnoble.com/h/help/about/barnesandnoble">Nosotros</a></b></li>
                               <li><b><a href="IngresoAdministrador_1.jsp">Ingreso de administración</a></b></li>
                        </ul>
                        <br>
                        <div class="row">
                            <div class="col-12 text-center">
                                <h4><b>Usuarios registrados</b></h4>
                            </div>
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-12 text-center">
                                <table class="table table-striped" width="100%" border="2" cellspacing="1">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Correo</th>
                                            <th>Nombre</th>
                                        </tr>
                                    </thead>
                                    <c:forEach items="${lista}" var="ver">
                                        <tr>
                                            <td>${ver.id}</td>
                                            <td>${ver.correo}</td>
                                            <td>${ver.nombre}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                                <br/>
                                <table>
                                    <td1><a class="btn btn-info" href="PrincipalUsuarios.jsp">  Atras  </a></td1>
                                    <td1> <---|---> </td1>
                                    <td1><a class="btn btn-primary" href="Index.jsp">    Salir   </a></td1>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>