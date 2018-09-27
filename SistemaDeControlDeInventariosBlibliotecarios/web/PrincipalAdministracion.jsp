<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BUS - Agregar nuevo</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body background="imagenes/libro.jpg">
        <div class="container">
            <div class="row">
                <div class="col-12 text-center">
                    <div class="row">
                        <div class="col-12 text-center">
                            <br/>
                            <h3 style="color:#000000">${msg}</h3>
                            <br/>
                            <br/>
                            <br/>
                            <form class="login1">
                                <fieldset>
                                    <br><center><legend>Inicio Administración</legend></center><br>
                                    <div class="form-group">
                                        <a class="btn btn-primary btn-block" href="lc?action=MostrarTodos">Libros</a><br>
                                        <a class="btn btn-primary btn-block" href="ac?action=MostrarTodos">Autores</a><br>
                                        <a class="btn btn-primary btn-block" href="pc?action=MostrarTodos">Proveedores</h4></a><br>
                                        <a class="btn btn-primary btn-block" href="ic?action=MostrarTodos">Inventarios</a><br>
                                        <a class="btn btn-primary btn-block"  href="diagrama?action=MostrarTodos">Diagrama <br> autores y libros</a><br><br>
                                        <a class="btn btn-warning btn-block" href="administrador?action=MostrarTodos">Configuraciones<br>administrativas</h4></a><br>
                                        <a class="btn btn-warning btn-block" href="usuario?action=MostrarTodos2">Configuraciones<br>de usuarios</a><br><br>
                                        <a class="btn btn-danger btn-block" href="Index.jsp">Salir</a><br><br>
                                    </div>
                                </fieldset>
                            </form>
                        </div>    
                    </div>     
                </div>          
            </div>   
        </div>
    </body>
</html>