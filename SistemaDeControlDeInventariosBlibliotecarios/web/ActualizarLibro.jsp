<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Posh | Actualización de datos del libro</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body background="imagenes/actualizar.jpg">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <br/>
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <h4><b>Libros - Formulario actualización</b></h4>
                        </div>
                    </div>
                    <br/>
                    <br/>
                    <div class="row">
                        <div class="col-12 text-center">
                            <c:forEach items="${lista}" var="ver">
                                <form action="lc?action=Actualizar&id_libro=${ver.id_libro}" method="post">
                                    <table class="table table-striped" width="10%" border="2" cellspacing="5">

                                        <tr>
                                            <td>
                                                Nombre: <input type="text" name="nombre"  value="${ver.nombre}" placeholder="Nombre">
                                            </td> 
                                        </tr>
                                        <tr>
                                            <td>

                                                Año de publicación: <input type="text" name="fecha_de_publicacion"  value="${ver.fecha_de_publicacion}" placeholder="Año de publicación">
                                            </td> 
                                        </tr>
                                        <tr>
                                            <td>
                                                Tomo: <input type="text" name="tomo" value="${ver.tomo}" placeholder="Tomo">
                                            </td> 
                                        <tr>
                                            <td>
                                                Edición: <input type="text" name="edicion"  value="${ver.edicion}" placeholder="Edición">
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>
                                                Pagínas: <input type="text" name="paginas"  value="${ver.paginas}" placeholder="Número">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                Género: <input type="text" name="genero" value="${ver.genero}" placeholder="Género">
                                            </td>
                                        </tr>

                                    </table>

                                    <button type="submit" name="action" class="btn btn-danger" >Guardar</button>
                                </form>
                            </c:forEach>
                            <br/>
                            <br/>
                            <a class="btn btn-success" href="lc?action=MostrarTodos">Cancelar</a>
                        </div>
                    </div>           
                </div>
            </div>
        </div>
    </body>
</html>