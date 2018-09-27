<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Posh | Seguridad de administración</title>
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
                        </ul>
                        <br>
                        <div class="row">
                            <div class="col-12 text-center">
                            <h4><b>Administradores registrados</b></h4><br/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 text-center" >
                            <a class="btn btn-primary btn-block" href="AgregarAdministracion_1.jsp">Agregar</a>
                            <table class="table table-striped" width="100%" border="2" cellspacing="1">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Correo</th>
                                        <th>Contraseña</th>
                                        <th>Nombre</th>                          
                                        <th>Modificar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>
                                <c:forEach items="${lista}" var="ver">
                                    <tr>
                                        <td>${ver.id}</td>
                                        <td>${ver.correo}</td>
                                        <td>${ver.contrasena}</td>
                                        <td>${ver.nombre}</td>
                                        <td><a class="btn btn-info btn-block" href="administrador?action=MostrarUno&id=${ver.id}">Modificar</a></td>

                                        <td><a class="btn btn-danger btn-block" href="administrador?action=Borrar&id=${ver.id}">Borrar</a></td>
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