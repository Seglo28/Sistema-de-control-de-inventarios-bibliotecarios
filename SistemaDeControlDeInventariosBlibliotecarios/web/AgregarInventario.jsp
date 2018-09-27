<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BUS - Agregar nuevo</title>
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
                                <h4><i>Inventario - Agregar nuevo registro</i></h4>
                            </div>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="row">
                        <div class="col-12 text-center">
                            <form action="ic?action=Insertar" method="post">
                                <table class="table table-hover" width="10%" border="2" cellspacing="5">
                                    <tr>
                                        <td>
                                            Proveedor: 
                                            <select name="id_proveedor">
                                                <option value="1">Elija un proveedor</option>
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
                                                <option value="1">Elija un libro</option>
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
                                                <option value="Disponible">Escaso</option>
                                                <option value="Disponible">Agotado</option>
                                            </select>
                                        </td> 
                                    </tr>
                                    <tr>
                                        <td>
                                            Existencias locales: 
                                            <input class="col-5" type="text" name="existencia_libro" placeholder="Ej: # de unidades">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i><h4>Nota:</h4>
                                                El dato de este campo representa un limite minimo; es decir,
                                                se espera que antes de llegar a la <br/>
                                                cantidad asignada se agregue mas inventario para evitar la escaces.</i><br/>
                                            <br/>
                                            Stock minimo: 
                                            <input class="col-5" type="text" name="stock_minimo_libro" placeholder="Ej: # de unidades">
                                        </td>
                                    </tr>
                                </table>
                                    <input type="submit" value="Insertar"/>
                                </form>
                            </form>
                            <br>
                            <br>
                            <br>
                            <div class="row">
                                <div class="col-12 text-center">
                                    <a class="btn btn-success" href="ic?action=MostrarTodos">Atras</a>
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