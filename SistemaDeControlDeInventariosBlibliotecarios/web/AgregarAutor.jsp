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
                    <div class="row">
                        <div class="col-12 text-center">
                            <h1><i>Agregar nuevo registro de autor</i></h1>

                            <br>
                            <br>
                            <div class="row">
                                <div class="col-12 text-center">
                                    <form action="ac" method="post">
                                        <table class="table table-striped" width="10%" border="2" cellspacing="5">
                                            <tr>
                                                <td>
                                                    Nombre:
                                                    <input type="text" name="nombre" placeholder="Nombre del autor">
                                                </td> 
                                            </tr>
                                            <tr>
                                                <td>
                                                    Fecha de nacimiento: 
                                                    <input type="text" name="fecha_de_nacimiento" placeholder="Fecha">
                                                </td> 
                                            </tr>
                                            <tr>
                                                <td>
                                                    Nacionalidad: 
                                                    <input type="text" name="nacionalidad" placeholder="Nacionalidad">
                                                </td> 
                                            <tr>
                                                <td>
                                        </table>
                                        <button type="submit" name="action" class="btn btn-info" value="insertar">Guardar</button>
                                    </form>
                                    <br>

                                    <br>
                                    <br>

                                    <div class="row">
                                        <div class="col-12 text-center">
                                            <a class="btn btn-danger" href="ac?action=MostrarTodos">Atras</a>
                                        </div>
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