<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Posh | Actualización de administrador</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body background="imagenes/actualizar.jpg">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <br/>
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <h4><b>Usuarios - Formulario actualización</b></h4>
                        </div>
                    </div>
                    <br/>
                    <br/>
                    <div class="row">
                        <div class="col-12 text-center">
                            <c:forEach items="${lista}" var="ver">
                                <form action="usuario?action=Actualizar&id=${ver.id}" method="post">
                                    <table class="table table-striped" width="10%" border="2" cellspacing="5">

                                        <tr>
                                            <td>
                                                Correo: <input type="text" name="correo"  value="${ver.correo}" placeholder="Mi correo">
                                            </td> 
                                        </tr>
                                        <tr>
                                            <td>
                                                Contraseña: <input type="text" name="contrasena"  value="${ver.contrasena}" placeholder="Mi contraseña">
                                            </td> 
                                        </tr>
                                        <tr>
                                            <td>
                                                Nombre: <input type="text" name="nombre" value="${ver.nombre}" placeholder="Mi nombre">
                                            </td> 
                                        </tr>
                                    </table>
                                    <button type="submit" name="action" class="btn btn-danger" >Guardar</button>
                                </form>
                            </c:forEach>
                            <br/>
                            <br/>
                            <a class="btn btn-success" href="usuario?action=MostrarTodos2">Atras</a>
                        </div>
                    </div>           
                </div>
            </div>
        </div>
    </body>
</html>