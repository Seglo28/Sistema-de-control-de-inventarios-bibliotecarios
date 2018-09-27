<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BUS - Agregar nuevo proveedor</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body background="imagenes/actualizar.jpg">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="col-md-12">
                        <br/>
                        <div class="row">
                            <div class="col-12 text-center">
                                <h4><i>Proveedores - Agregar nuevo registro</i></h4>
                            </div>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="row">
                        <div class="col-12 text-center">
                            <form action="pc" method="post">
                                <table class="table table-striped" width="10%" border="2" cellspacing="5">
                                    <tr>
                                        <td>
                                            Nombre: <input type="text" name="nombre" placeholder="Ej: Alberto Ruíz">
                                        </td> 
                                    </tr>
                                    <tr>
                                        <td>
                                            Rubro: <input type="text" name="rubro" placeholder="Ej: Venta de libros">
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
                                    <tr>
                                        <td>
                                            Telefono: <input type="text" name="telefono" placeholder="XXXX-XXXX">
                                        </td>
                                    </tr>
                                </table>
                                <button type="submit" name="action" class="btn btn-danger" value="insertar">Guardar</button>
                            </form>
                            <br>

                            <br>
                            <br>

                            <div class="row">
                                <div class="col-12 text-center">
                                    <a class="btn btn-success" href="pc?action=MostrarTodos">Atras</a>
                                </div>
                            </div>
                        </div>
                    </div>    
                </div>     
            </div>          
        </div>     
    </div>   
</body>
</html>