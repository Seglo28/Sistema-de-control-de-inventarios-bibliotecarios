<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Posh | Actualización de datos de libro</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body background="imagenes/actualizar.jpg">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <br/>
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <h4><b>Autores - Formulario actualización</b></h4>
                        </div>
                    </div>
                    <br/>
                    <br/>
                    <div class="row">
                        <div class="col-12 text-center">
                            <c:forEach items="${lista}" var="ver">
                                <form action="ac?action=Actualizar&id_autor=${ver.id_autor}" method="post">
                                    <table class="table table-striped" width="10%" border="2" cellspacing="5">

                                        <tr>
                                            <td>
                                                Nombre: <input type="text" name="nombre"  value="${ver.nombre}" placeholder="Nombre">
                                            </td> 
                                        </tr>
                                        <tr>
                                            <td>
                                                Fecha de nacimiento: <input type="text" name="fecha_de_nacimiento"  value="${ver.fecha_de_nacimiento}" placeholder="Año de publicación">
                                            </td> 
                                        </tr>
                                        <tr>
                                            <td>
                                                Nacionalidad: <input type="text" name="nacionalidad" value="${ver.nacionalidad}" placeholder="Tomo">
                                            </td> 
                                        </tr>
                                    </table>
                                    <button type="submit" name="action" class="btn btn-danger" >Guardar</button>
                                </form>
                            </c:forEach>
                            <br/>
                            <br/>
                            <a class="btn btn-success" href="ac?action=MostrarTodos">Inicio</a>
                        </div>
                    </div>           
                </div>
            </div>
        </div>
    </body>
</html>