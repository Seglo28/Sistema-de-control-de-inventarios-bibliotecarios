<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualización de datos del libro</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body background="imagenes/actualizar.jpg">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <br/>
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <h4><i>Proveedores - Formulario actualización</i></h4>
                        </div>
                    </div>
                    <br/>
                    <br/>
                    <div class="row">
                        <div class="col-12 text-center">
                            <c:forEach items="${lista}" var="ver">
                                <form action="pc?action=Actualizar&id_proveedor=${ver.id_proveedor}" method="post">
                                    <table class="table table-striped" width="10%" border="2" cellspacing="5">

                                        <tr>
                                            <td>
                                                Nombre: <input type="text" name="nombre"  value="${ver.nombre}" placeholder="Nombre">
                                            </td> 
                                        </tr>
                                        <tr>
                                            <td>
                                                Rubro: <input type="text" name="rubro"  value="${ver.rubro}" placeholder="Rubro">
                                            </td> 
                                        </tr>
                                        <tr>
                                            <td>
                                                <h4><i>Nota:</i></h4> Usted puede elegir entre las siguientes opciones al momento de rellenar este campo:<br/>
                                                <b>Juridica:</b> Proveedor como empresa registrada.<br/>
                                                <b>Natural:</b> Proveedor proveniente de comercio informal.<br/><br/>
                                                <select name="persona">
                                                    <option value="Juridica">Juridica</option>
                                                    <option value="Natural">Natural</option>
                                                </select>
                                            </td> 
                                        </tr>
                                        <tr>
                                            <td>
                                                Telefono: <input type="text" name="telefono"  value="${ver.telefono}" placeholder="Ej: XXXX-XXXX">
                                            </td> 
                                        </tr>
                                        <tr>
                                    </table>
                                    <button type="submit" name="action" class="btn btn-danger" >Guardar</button>
                                </form>
                            </c:forEach>
                            <br/>
                            <br/>
                            <a class="btn btn-success" href="pc?action=MostrarTodos">Atras</a>
                        </div>
                    </div>           
                </div>
            </div>
        </div>
    </body>
</html>