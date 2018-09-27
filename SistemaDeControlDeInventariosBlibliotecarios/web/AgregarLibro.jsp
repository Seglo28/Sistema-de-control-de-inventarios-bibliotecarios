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
                                <h4><i>Libros - Agregar nuevo registro</i></h4>
                            </div>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="row">
                        <div class="col-12 text-center">
                            <form action="lc" method="post">
                                <table class="table table-striped" width="10%" border="2" cellspacing="5">

                                    <tr>
                                        <td>
                                            Nombre: <input type="text" name="nombre" placeholder="letra">
                                        </td> 
                                    </tr>
                                    <tr>
                                        <td>
                                            Fecha de publicación: <input type="text" name="fecha_de_publicacion" placeholder="letra">
                                        </td> 
                                    </tr>
                                    <tr>
                                        <td>
                                            Tomo n°: <input type="text" name="tomo" placeholder="numero">
                                        </td> 
                                    <tr>
                                        <td>
                                            Edición n°: <input type="text" name="edicion" placeholder="letra">
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            Paginas n°: <input type="text" name="paginas" placeholder="numero">
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            Genero: <input type="text" name="genero" placeholder="letra">
                                        </td>
                                    </tr>
                                </table>
                                <button type="submit" name="action" class="btn btn-danger" value="insertar">Guardar</button>
                                <br>
                                <h3 style="color:#32CD32">${msg}</h3>
                            </form>
                            <br>

                            <br>
                            <br>

                            <div class="row">
                                <div class="col-12 text-center">
                                    <a class="btn btn-success" href="lc?action=MostrarTodos">Atras</a>
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