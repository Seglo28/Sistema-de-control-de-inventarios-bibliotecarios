<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name ="viewport" content="whith=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Posh - Ingreso de usuario</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
<body background="imagenes/libro2.jpg">
        <div class="container">
            <div class="row">
                <div class="col-12 text-center">
                    <br/>
                    <ul>
                        <li><b><a href="https://www.barnesandnoble.com/">Tienda en linea</a></b></li>
                        <li><b><a href="https://www.barnesandnoble.com/h/help/about/barnesandnoble">Nosotros</a></b></li>
                        <li><b><a href="IngresoAdministrador.jsp" style="color:#FFFF00">Ingreso administrador</a></b></li>
                        <li><b><a href="Index.jsp">Inicio</a></b></li>
                    </ul>
                    <br/>
                    <br/>
                    <br>
                    <br/>
                    <br/>
                    <br>
                    <form action="usuario?action=Loging" method="post" class="login">
                        <!--<div class="prueba">-->
                        <fieldset>
                            <center><legend>Ingreso de Usuario</legend></center>
                            <div class="form-group">
                                <label>Correo:</label><br>
                                <input class="form-control" size="30" type="text" name="correo" placeholder="Mi correo"><br>
                                <label>Contraseña:</label><br>
                                <input class="form-control" size="30" type="text" name="contrasena" placeholder="Mi contraseña"><br>
                                <center><button type="submit" name="action" class="btn btn-danger" value="MostrarUno">Guardar</button></center>
                            </div>
                        </fieldset>
                        <h5>${mensage}</h5>
                        <center><legend>¿No tienes una cuenta?</legend></center>
                        <center><a class="btn btn-primary" href="AgregarUsuario.jsp">    Registrate    </a></center>
                        </fieldset>
                    </form>
                </div>
            </div>
    </body>
</html>