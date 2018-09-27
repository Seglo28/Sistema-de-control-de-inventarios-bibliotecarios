<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BUS - Agregar nuevo</title>
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
                                <br>
                                <br/>
                                <div class="row">
                                    <div class="col-12 text-center">
                                        <form action="administrador" method="post" class="login">
                                            <fieldset>
                                                <center><legend>Formulario de registro <b>- administrador.</b></legend></center>
                                                <div class="form-group">
                                                    <label>Correo:</label><br>
                                                    <input class="form-control" size="30" type="text" name="correo" placeholder="Mi correo"><br>
                                                    <label>Contraseña:</label><br>
                                                    <input class="form-control" size="30" type="text" name="contrasena" placeholder="Mi contraseña"><br>
                                                    <label>Nombre:</label><br>
                                                    <input class="form-control" size="30" type="text" name="nombre" placeholder="Mi nombre"><br>
                                                    <center><button type="submit" name="action" class="btn btn-danger" value="Insertar">Guardar</button></center>
                                                </div>
                                            </fieldset>
                                            <center><a class="btn btn-primary" href="administrador?action=MostrarTodos"> Cancelar </a></center>
                                        </form>
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