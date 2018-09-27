<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BUS - Actualización de inventarios</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body background="imagenes/actualizar.jpg">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <br/>
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <h4><b>Inventarios - Formulario actualización</b></h4>
                        </div>
                    </div>
                    <br/>
                    <br/>
                    <div class="row">
                        <div class="col-12 text-center">
                            <c:forEach items="${lista}" var="ver">
                                <form action="ic" method="get">
                                    <table class="table table-hover" width="10%" border="2" cellspacing="5">
                                        <tr>
                                        <td>
                                            CODIGO: 
                                            <input type="text" readonly="" name="id_inventario" value="${ver.id_inventario}" />
                                        </td>
                                    </tr>
                                        <tr>
                                        <td>
                                            Proveedor: 
                                            <select name="id_proveedor">
                                                <option value="0">Elija un proveedor</option>
                                                <c:forEach items="${proveedor}" var="pro1">
                                                    <option value="${pro1.id_proveedor}">${pro1.nombre}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Libro: 
                                            <select name="id_libro">
                                                <option value="0">Elija un libro</option>
                                                <c:forEach items="${libro}" var="lb1">
                                                    <option value="${lb1.id_libro}">${lb1.nombre}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                        <tr>
                                            <td>
                                                Estado en mercado: 
                                                <select name="estado_libro">
                                                    <option value="Disponible">Disponible</option>
                                                    <option value="Escaso">Escaso</option>
                                                    <option value="Agotado">Agotado</option>
                                                </select>
                                            </td> 
                                        </tr>
                                        <tr>
                                            <td>
                                                Existencias locales:
                                                <input type="text" name="existencia_libro"  value="${ver.existencia_libro}" placeholder="Ej: # unidades">
                                            </td> 
                                        </tr>
                                        <tr>
                                        <td>
                                            <i><h5>Nota:</h5>
                                                El dato de este campo representa un limite minimo; es decir,
                                                se espera que antes de llegar a la <br/>
                                                cantidad asignada se agregue mas inventario para evitar la escaces.</i><br/>
                                            <br/>
                                            Stock minimo: 
                                            <input class="col-5" type="text" name="stock_minimo_libro" value="${ver.stock_minimo_libro}" placeholder="Ej: # unidades">
                                        </td>
                                    </tr>
                                    </table>
                                    <button type="submit" name="action" value="Actualizar" class="btn btn-danger" >Guardar</button>
                                </form>
                            </c:forEach>
                            <br/>
                            <br/>
                            <a class="btn btn-success" href="ic?action=MostrarTodos">Cancelar</a>
                        </div>
                    </div>           
                </div>
            </div>
        </div>
    </body>
</html>